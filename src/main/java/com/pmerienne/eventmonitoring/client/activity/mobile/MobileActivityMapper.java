package com.pmerienne.eventmonitoring.client.activity.mobile;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardListPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.EventListPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.HomePlace;
import com.pmerienne.eventmonitoring.client.place.mobile.PieChartPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.TimeSeriePlace;

public class MobileActivityMapper implements ActivityMapper {

	private final MobileClientFactory clientFactory;

	public MobileActivityMapper(MobileClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new HomeActivity(this.clientFactory);
		}

		if (place instanceof DashboardListPlace) {
			return new DashboardListActivity(this.clientFactory);
		}

		if (place instanceof DashboardPlace) {
			return new DashboardActivity(this.clientFactory, ((DashboardPlace) place).getId());
		}

		if (place instanceof PieChartPlace) {
			return new PieChartActivity(this.clientFactory, ((PieChartPlace) place).getDashboardId(), ((PieChartPlace) place).getConfigurationIndex());
		}

		if (place instanceof TimeSeriePlace) {
			return new TimeSerieActivity(this.clientFactory, ((TimeSeriePlace) place).getDashboardId(), ((TimeSeriePlace) place).getConfigurationIndex());
		}

		if (place instanceof EventListPlace) {
			return new EventListActivity(this.clientFactory, ((EventListPlace) place).getDashboardId(), ((EventListPlace) place).getConfigurationIndex());
		}

		return new HomeActivity(this.clientFactory);
	}

}
