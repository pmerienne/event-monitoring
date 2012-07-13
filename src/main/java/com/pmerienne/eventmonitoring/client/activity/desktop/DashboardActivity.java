package com.pmerienne.eventmonitoring.client.activity.desktop;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.activity.PieChartSearcherTimer;
import com.pmerienne.eventmonitoring.client.activity.SerieSearcherTimer;
import com.pmerienne.eventmonitoring.client.factory.DesktopClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.desktop.DashBoardView;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.EventTable;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public class DashboardActivity extends AbstractActivity implements DashBoardView.Presenter {

	private DesktopClientFactory clientFactory;

	private String dashBoardId;

	private List<Timer> timers = new ArrayList<Timer>();

	public DashboardActivity(DesktopClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public DashboardActivity(DesktopClientFactory clientFactory, String dashBoardId) {
		super();
		this.clientFactory = clientFactory;
		this.dashBoardId = dashBoardId;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		DashBoardView view = this.clientFactory.getDashboardView();
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
				DashBoardView view = clientFactory.getDashboardView();
				if (dashBoard == null) {
					view.clear();
				} else {
					view.setDashBoard(dashBoard);

					// Init time series timers
					initTimeSerieTimers(view.getTimeSeriesGraphs());
					initPieChartTimers(view.getPieChartGraphs());

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
				DashBoardView view = clientFactory.getDashboardView();
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

	private void initPieChartTimers(List<PieChart> pieCharts) {
		for (PieChart pieChart : pieCharts) {
			for (SerieConfiguration serieConfiguration : pieChart.getGraphConfiguration().getSerieConfigurations()) {
				// Create timer
				PieChartSearcherTimer timer = new PieChartSearcherTimer(pieChart, serieConfiguration);

				// Do first search
				timer.run();

				// Schedule search
				timer.scheduleRepeating(serieConfiguration.getInterval().intValue());

				// Store timer
				this.timers.add(timer);
			}

		}
	}

	private void initTables(List<EventTable> eventTables) {
		for (final EventTable table : eventTables) {
			table.addDataProvider(new DataProvider() {
				@Override
				public void onRequestChange(final SearchRequest request) {
					table.setPending(true);

					Services.getEventService().search(request, new MethodCallback<SearchResults>() {
						@Override
						public void onFailure(Method method, Throwable caught) {
							Notifications.error("Search failed : " + caught.getMessage());
							table.setPending(false);
						}

						@Override
						public void onSuccess(Method method, SearchResults result) {
							if (result.getTotalCount() != null) {
								table.setRowCount(result.getTotalCount().intValue(), true);
							}
							table.setRowData(request.getStart(), result.getEvents());
							table.setPending(false);
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
		DashBoardView view = this.clientFactory.getDashboardView();
		view.clear();

		for (Timer timer : this.timers) {
			timer.cancel();
		}
		this.timers.clear();
	}

}
