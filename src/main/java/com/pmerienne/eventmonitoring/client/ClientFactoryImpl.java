package com.pmerienne.eventmonitoring.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.pmerienne.eventmonitoring.client.view.ConfigurationView;
import com.pmerienne.eventmonitoring.client.view.ConfigurationViewImpl;
import com.pmerienne.eventmonitoring.client.view.DashBoardView;
import com.pmerienne.eventmonitoring.client.view.DashboardManagementView;
import com.pmerienne.eventmonitoring.client.view.DashboardManagementViewImpl;
import com.pmerienne.eventmonitoring.client.view.DashboardViewImpl;
import com.pmerienne.eventmonitoring.client.view.EditDashboardView;
import com.pmerienne.eventmonitoring.client.view.EditDashboardViewImpl;
import com.pmerienne.eventmonitoring.client.view.HomeView;
import com.pmerienne.eventmonitoring.client.view.HomeViewImpl;
import com.pmerienne.eventmonitoring.client.view.SearchView;
import com.pmerienne.eventmonitoring.client.view.SearchViewImpl;

public class ClientFactoryImpl implements ClientFactory {

	private final EventBus eventBus = new SimpleEventBus();

	private final PlaceController placeController = new PlaceController(this.eventBus);
	private final HomeView homeView = new HomeViewImpl();
	private final SearchView searchView = new SearchViewImpl();
	private final DashBoardView dashBoardView = new DashboardViewImpl();
	private final DashboardManagementView dashboardManagementView = new DashboardManagementViewImpl();
	private final EditDashboardView editDashboardView = new EditDashboardViewImpl();
	private final ConfigurationView configurationView = new ConfigurationViewImpl();

	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}

	@Override
	public DashBoardView getDashBoardView() {
		return this.dashBoardView;
	}

	@Override
	public DashboardManagementView getDashboardManagementView() {
		return this.dashboardManagementView;
	}

	@Override
	public EditDashboardView getEditDashboardView() {
		return editDashboardView;
	}

	@Override
	public HomeView getHomeView() {
		return this.homeView;
	}

	@Override
	public ConfigurationView getConfigurationView() {
		return this.configurationView;
	}

	@Override
	public SearchView getSearchView() {
		return this.searchView;
	}
}
