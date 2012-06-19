package com.pmerienne.eventmonitoring.client.activity;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.ClientFactory;
import com.pmerienne.eventmonitoring.client.activity.DashboardActivity.SerieSearcherTimer;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.ServerDetailsView;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class ServerDetailsActivity extends AbstractActivity {

	private Timer timer;

	private ClientFactory clientFactory;

	public ServerDetailsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ServerDetailsView view = this.clientFactory.getServerDetailsView();
		this.loadAvailableDashboards();
		this.loadServerDetails();

		this.clear();

		GraphConfiguration graphConfiguration = this.getLastEventGraphConfiguration();
		TimeSeriesGraph graph = view.initLastEventsGraph(graphConfiguration);
		this.initTimeSerieTimer(graph);

		panel.setWidget(view);
	}

	private GraphConfiguration getLastEventGraphConfiguration() {
		SerieConfiguration eventPerSeconds = new SerieConfiguration();
		eventPerSeconds.setName("event/seconds");
		eventPerSeconds.setCriteriaQuery("");
		eventPerSeconds.setInterval(60 * 1000L);
		eventPerSeconds.setType(Type.AREA_SPLINE);
		eventPerSeconds.setProjectionQuery("count(date != null) / 60");
		GraphConfiguration graphConfiguration = new GraphConfiguration();
		graphConfiguration.setName("Last events");
		graphConfiguration.setTimeRange(60 * 60 * 1000L);
		graphConfiguration.getSerieConfigurations().add(eventPerSeconds);
		return graphConfiguration;
	}

	private void loadServerDetails() {
		Services.getConfigurationService().getServerDetails(new MethodCallback<DatabaseInformation>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load server details : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, DatabaseInformation databaseInformation) {
				ServerDetailsView view = clientFactory.getServerDetailsView();
				view.setDatabaseInformation(databaseInformation);
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
				ServerDetailsView view = clientFactory.getServerDetailsView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}

	private void initTimeSerieTimer(TimeSeriesGraph graph) {
		for (SerieConfiguration serieConfiguration : graph.getGraphConfiguration().getSerieConfigurations()) {
			// Create timer
			this.timer = new SerieSearcherTimer(graph, serieConfiguration);
			// Do first search
			this.timer.run();
			// Schedule search
			this.timer.scheduleRepeating(serieConfiguration.getInterval().intValue());
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
		ServerDetailsView view = this.clientFactory.getServerDetailsView();
		view.clear();

		if (this.timer != null) {
			this.timer.cancel();
		}
		this.timer = null;
	}
}