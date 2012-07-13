package com.pmerienne.eventmonitoring.client.factory;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.pmerienne.eventmonitoring.client.view.desktop.ConfigurationView;
import com.pmerienne.eventmonitoring.client.view.desktop.ConfigurationViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.DashBoardView;
import com.pmerienne.eventmonitoring.client.view.desktop.DashboardManagementView;
import com.pmerienne.eventmonitoring.client.view.desktop.DashboardManagementViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.DashboardViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.EditDashboardView;
import com.pmerienne.eventmonitoring.client.view.desktop.EditDashboardViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.HomeView;
import com.pmerienne.eventmonitoring.client.view.desktop.HomeViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.SearchView;
import com.pmerienne.eventmonitoring.client.view.desktop.SearchViewImpl;
import com.pmerienne.eventmonitoring.client.view.desktop.ServerDetailsView;
import com.pmerienne.eventmonitoring.client.view.desktop.ServerDetailsViewImpl;

public class DesktopClientFactoryImpl implements DesktopClientFactory {

	private final EventBus eventBus = new SimpleEventBus();

	private final PlaceController placeController = new PlaceController(this.eventBus);
	private final HomeView homeView = new HomeViewImpl();
	private final SearchView searchView = new SearchViewImpl();
	private final DashBoardView dashBoardView = new DashboardViewImpl();
	private final DashboardManagementView dashboardManagementView = new DashboardManagementViewImpl();
	private final EditDashboardView editDashboardView = new EditDashboardViewImpl();
	private final ConfigurationView configurationView = new ConfigurationViewImpl();
	private final ServerDetailsView serverInformationView = new ServerDetailsViewImpl();

	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}

	@Override
	public DashBoardView getDashboardView() {
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

	@Override
	public ServerDetailsView getServerDetailsView() {
		return serverInformationView;
	}

}
