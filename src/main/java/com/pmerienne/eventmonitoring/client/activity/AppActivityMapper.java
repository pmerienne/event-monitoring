package com.pmerienne.eventmonitoring.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.pmerienne.eventmonitoring.client.ClientFactory;
import com.pmerienne.eventmonitoring.client.place.ConfigurationPlace;
import com.pmerienne.eventmonitoring.client.place.DashboardManagementPlace;
import com.pmerienne.eventmonitoring.client.place.DashboardPlace;
import com.pmerienne.eventmonitoring.client.place.EditDashboardPlace;
import com.pmerienne.eventmonitoring.client.place.HomePlace;
import com.pmerienne.eventmonitoring.client.place.SearchPlace;
import com.pmerienne.eventmonitoring.client.place.ServerDetailsPlace;

public class AppActivityMapper implements ActivityMapper {

	private final Activity defaultActivity;

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.defaultActivity = new HomeActivity(clientFactory);
	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = defaultActivity;

		if (place instanceof HomePlace) {
			activity = new HomeActivity(this.clientFactory);

		} else if (place instanceof SearchPlace) {
			activity = new SearchActivity(this.clientFactory);

		} else if (place instanceof DashboardPlace) {
			String dashboardId = ((DashboardPlace) place).getId();
			activity = new DashboardActivity(this.clientFactory, dashboardId);

		} else if (place instanceof DashboardManagementPlace) {
			activity = new DashboardManagementActivity(this.clientFactory);

		} else if (place instanceof EditDashboardPlace) {
			String dashboardId = ((EditDashboardPlace) place).getId();
			activity = new EditDashboardActivity(this.clientFactory, dashboardId);

		} else if (place instanceof ConfigurationPlace) {
			activity = new ConfigurationActivity(this.clientFactory);

		} else if (place instanceof ServerDetailsPlace) {
			activity = new ServerDetailsActivity(this.clientFactory);

		}
		return activity;
	}

}
