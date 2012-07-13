package com.pmerienne.eventmonitoring.client.factory;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.pmerienne.eventmonitoring.client.view.desktop.ConfigurationView;
import com.pmerienne.eventmonitoring.client.view.desktop.DashBoardView;
import com.pmerienne.eventmonitoring.client.view.desktop.DashboardManagementView;
import com.pmerienne.eventmonitoring.client.view.desktop.EditDashboardView;
import com.pmerienne.eventmonitoring.client.view.desktop.HomeView;
import com.pmerienne.eventmonitoring.client.view.desktop.SearchView;
import com.pmerienne.eventmonitoring.client.view.desktop.ServerDetailsView;

public interface DesktopClientFactory {

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
