package com.pmerienne.eventmonitoring.client.factory;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardListView;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardView;
import com.pmerienne.eventmonitoring.client.view.mobile.EventListView;
import com.pmerienne.eventmonitoring.client.view.mobile.HomeView;
import com.pmerienne.eventmonitoring.client.view.mobile.PendingView;
import com.pmerienne.eventmonitoring.client.view.mobile.PieChartView;
import com.pmerienne.eventmonitoring.client.view.mobile.TimeSerieView;

public interface MobileClientFactory {

	EventBus getEventBus();

	PlaceController getPlaceController();

	PendingView getPendingView();

	HomeView getHomeView();

	DashboardListView getDashboardListView();

	DashboardView getDashboardView();

	PieChartView getPieChartView();

	TimeSerieView getTimeSerieView();

	EventListView getEventListView();
}
