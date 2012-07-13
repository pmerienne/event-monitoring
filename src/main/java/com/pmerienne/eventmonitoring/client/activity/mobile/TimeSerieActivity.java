package com.pmerienne.eventmonitoring.client.activity.mobile;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.activity.SerieSearcherTimer;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.mobile.TimeSerieView;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class TimeSerieActivity extends MobileActivity implements TimeSerieView.Presenter {

	private String dashboardId;

	private Integer configurationIndex;

	private List<Timer> timers = new ArrayList<Timer>();

	public TimeSerieActivity(MobileClientFactory clientFactory, String dashboardId, Integer configurationIndex) {
		super(clientFactory);
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		TimeSerieView view = this.clientFactory.getTimeSerieView();
		view.setPresenter(this);

		this.loadTimeSerieGraph();
	}

	private void loadTimeSerieGraph() {
		this.setPending(true);

		final TimeSerieView view = this.clientFactory.getTimeSerieView();

		Services.getDashboardService().find(this.dashboardId, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboard : " + caught.getMessage());
				setPending(false);
			}

			@Override
			public void onSuccess(Method method, Dashboard dashBoard) {
				setPending(false);
				if (dashBoard == null) {
					clear();
				} else {
					GraphConfiguration configuration = dashBoard.getGraphConfigurations().get(configurationIndex);
					TimeSeriesGraph timeSeriesGraph = view.setTimeSerieConfiguration(configuration);
					initTimeSerieTimers(timeSeriesGraph);
				}
			}
		});
	}

	private void initTimeSerieTimers(TimeSeriesGraph graph) {
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

	@Override
	public void onCancel() {
		this.clear();
	}

	@Override
	public void onStop() {
		this.clear();
	}

	private void clear() {
		TimeSerieView view = this.clientFactory.getTimeSerieView();
		view.clear();
		for (Timer timer : this.timers) {
			timer.cancel();
		}
		this.timers.clear();
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void goBack() {
		History.back();
	}

	@Override
	protected IsWidget getView() {
		return this.clientFactory.getTimeSerieView();
	}

}