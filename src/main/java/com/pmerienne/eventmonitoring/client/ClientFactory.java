package com.pmerienne.eventmonitoring.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.pmerienne.eventmonitoring.client.view.ConfigurationView;
import com.pmerienne.eventmonitoring.client.view.DashBoardView;
import com.pmerienne.eventmonitoring.client.view.DashboardManagementView;
import com.pmerienne.eventmonitoring.client.view.EditDashboardView;
import com.pmerienne.eventmonitoring.client.view.HomeView;
import com.pmerienne.eventmonitoring.client.view.SearchView;
import com.pmerienne.eventmonitoring.client.view.ServerDetailsView;

public interface ClientFactory {

	EventBus getEventBus();

	PlaceController getPlaceController();

	HomeView getHomeView();

	SearchView getSearchView();

	DashBoardView getDashboardView();

	DashboardManagementView getDashboardManagementView();

	EditDashboardView getEditDashboardView();

	ConfigurationView getConfigurationView();

	ServerDetailsView getServerDetailsView();
}
