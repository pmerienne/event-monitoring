package com.pmerienne.eventmonitoring.client.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.ClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.utils.TimeDataFetcher;
import com.pmerienne.eventmonitoring.client.view.DashBoardView;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

public class DashboardActivity extends AbstractActivity implements DashBoardView.Presenter {

	private ClientFactory clientFactory;

	private String dashBoardId;

	private List<Timer> timers = new ArrayList<Timer>();

	public DashboardActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public DashboardActivity(ClientFactory clientFactory, String dashBoardId) {
		super();
		this.clientFactory = clientFactory;
		this.dashBoardId = dashBoardId;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		DashBoardView view = this.clientFactory.getDashBoardView();
		view.setPresenter(this);

		// Load available dashboards
		this.loadAvailableDashboards();

		// Load dashboard if id is not null
		if (this.dashBoardId == null || this.dashBoardId.isEmpty()) {
			view.clear();
		} else {
			this.load(this.dashBoardId);
		}

		panel.setWidget(view);
	}

	private void load(String dashBoardId) {
		Services.getDashboardService().find(dashBoardId, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboard : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, Dashboard dashBoard) {
				// Update view
				DashBoardView view = clientFactory.getDashBoardView();
				if (dashBoard == null) {
					view.clear();
				} else {
					view.setDashBoard(dashBoard);

					// Init time series timers
					initTimeSerieTimers(view.getTimeSeriesGraphs());

					// Init event tables
					initTables(view.getEventTables());
				}
			}
		});
	}

	private void loadAvailableDashboards() {
		Services.getDashboardService().findAll(new MethodCallback<List<Dashboard>>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboards : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, List<Dashboard> dashboards) {
				DashBoardView view = clientFactory.getDashBoardView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}

	private void initTimeSerieTimers(List<TimeSeriesGraph> graphs) {
		for (TimeSeriesGraph graph : graphs) {
			for (SerieConfiguration serieConfiguration : graph.getGraphConfiguration().getSerieConfigurations()) {
				// Create timer
				SerieSearcherTimer timer = new SerieSearcherTimer(graph, serieConfiguration);

				// Do first search
				timer.run();

				// Schedule search
				timer.scheduleRepeating(serieConfiguration.getInterval().intValue());

				// Store timer
				timers.add(timer);
			}

		}
	}

	private void initTables(List<EventTable> eventTables) {
		for (final EventTable table : eventTables) {
			table.addDataProvider(new DataProvider() {
				@Override
				public void onRequestChange(final SearchRequest request) {
					Services.getEventService().search(request, new MethodCallback<SearchResults>() {
						@Override
						public void onFailure(Method method, Throwable caught) {
							Notifications.error("Search failed : " + caught.getMessage());
						}

						@Override
						public void onSuccess(Method method, SearchResults result) {
							table.setRowCount(result.getTotalCount().intValue(), true);
							table.setRowData(request.getStart(), result.getEvents());
						}
					});
				}
			});
		}
	}

	@Override
	public void onCancel() {
		this.clear();
	}

	@Override
	public void onStop() {
		this.clear();
	}

	private void clear() {
		DashBoardView view = this.clientFactory.getDashBoardView();
		view.clear();

		for (Timer timer : this.timers) {
			timer.cancel();
		}
		this.timers.clear();
	}

	private static class SerieSearcherTimer extends Timer {

		private TimeSeriesGraph graph;

		private SerieConfiguration serieConfiguration;

		private Date lastUpdate;

		public SerieSearcherTimer(TimeSeriesGraph graph, SerieConfiguration serieConfiguration) {
			super();
			this.graph = graph;
			this.serieConfiguration = serieConfiguration;
			this.lastUpdate = new Date(new Date().getTime() - graph.getGraphConfiguration().getTimeRange());
		}

		@Override
		public void run() {
			final Date from = this.lastUpdate;
			final Date to = new Date();
			this.lastUpdate = to;

			Services.getEventService().search(new TimeSerieRequest(serieConfiguration, from, to), new MethodCallback<TimeSerieResults>() {
				@Override
				public void onFailure(Method method, Throwable caught) {
					String graphName = graph.getGraphConfiguration().getName();
					String serieName = serieConfiguration.getName();
					Notifications.error("Unable to load data for " + graphName + ":" + serieName + ". Cause : " + caught.getMessage());
				}

				@Override
				public void onSuccess(Method method, TimeSerieResults result) {
					graph.addData(serieConfiguration.getName(), TimeDataFetcher.fetchDatas(result));
				}
			});
		}
	}

}
