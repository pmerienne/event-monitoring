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
import com.pmerienne.eventmonitoring.client.activity.PieChartSearcherTimer;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.mobile.PieChartView;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class PieChartActivity extends MobileActivity implements PieChartView.Presenter {

	private String dashboardId;

	private Integer configurationIndex;

	private List<Timer> timers = new ArrayList<Timer>();

	public PieChartActivity(MobileClientFactory clientFactory, String dashboardId, Integer configurationIndex) {
		super(clientFactory);
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		PieChartView view = this.clientFactory.getPieChartView();
		view.setPresenter(this);

		this.loadPieChart();
	}

	private void loadPieChart() {
		this.setPending(true);
		
		final PieChartView view = this.clientFactory.getPieChartView();

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
					GraphConfiguration configuration = dashBoard.getPieConfigurations().get(configurationIndex);
					PieChart pieChart = view.setPieChartConfiguration(configuration);
					initPieChartTimers(pieChart);
				}
			}
		});
	}

	private void initPieChartTimers(PieChart pieChart) {
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

	@Override
	public void onCancel() {
		this.clear();
	}

	@Override
	public void onStop() {
		this.clear();
	}

	private void clear() {
		PieChartView view = this.clientFactory.getPieChartView();
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
		return this.clientFactory.getPieChartView();
	}

}