package com.pmerienne.eventmonitoring.client.factory;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardListView;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardListViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardView;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.EventListView;
import com.pmerienne.eventmonitoring.client.view.mobile.EventListViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.HomeView;
import com.pmerienne.eventmonitoring.client.view.mobile.HomeViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.PendingView;
import com.pmerienne.eventmonitoring.client.view.mobile.PendingViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.PieChartView;
import com.pmerienne.eventmonitoring.client.view.mobile.PieChartViewImpl;
import com.pmerienne.eventmonitoring.client.view.mobile.TimeSerieView;
import com.pmerienne.eventmonitoring.client.view.mobile.TimeSerieViewImpl;

public class MobileClientFactoryImpl implements MobileClientFactory {

	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(this.eventBus);

	private HomeView homeView;
	private PendingView pendingView;
	private DashboardListView dashboardListView;
	private DashboardView dashboardView;
	private PieChartView pieChartView;
	private TimeSerieView timeSerieView;
	private EventListView eventListView;

	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}

	@Override
	public PendingView getPendingView() {
		if (this.pendingView == null) {
			this.pendingView = new PendingViewImpl();
		}
		return this.pendingView;
	}

	@Override
	public HomeView getHomeView() {
		if (this.homeView == null) {
			this.homeView = new HomeViewImpl();
		}
		return this.homeView;
	}

	@Override
	public DashboardListView getDashboardListView() {
		if (this.dashboardListView == null) {
			this.dashboardListView = new DashboardListViewImpl();
		}
		return this.dashboardListView;
	}

	@Override
	public DashboardView getDashboardView() {
		if (this.dashboardView == null) {
			this.dashboardView = new DashboardViewImpl();
		}
		return this.dashboardView;
	}

	@Override
	public PieChartView getPieChartView() {
		if (this.pieChartView == null) {
			this.pieChartView = new PieChartViewImpl();
		}
		return this.pieChartView;
	}

	@Override
	public TimeSerieView getTimeSerieView() {
		if (this.timeSerieView == null) {
			this.timeSerieView = new TimeSerieViewImpl();
		}
		return this.timeSerieView;
	}

	@Override
	public EventListView getEventListView() {
		if (this.eventListView == null) {
			this.eventListView = new EventListViewImpl();
		}
		return this.eventListView;
	}
}
