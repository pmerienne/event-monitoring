package com.pmerienne.eventmonitoring.client.service;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.GWT;

public class Services {

	static {
		// Jersey returns java.util.Date as timestamp
		Defaults.setDateFormat(null);

		// Our rest endpoint
		Defaults.setServiceRoot(GWT.getHostPageBaseURL() + "api/");
	}

	private final static EventRemoteService EVENT_SERVICE = GWT.create(EventRemoteService.class);
	private final static DashboardRemoteService DASHBOARD_SERVICE = GWT.create(DashboardRemoteService.class);
	private final static ConfigurationRemoteService CONFIGURATION_SERVICE = GWT.create(ConfigurationRemoteService.class);

	public static EventRemoteService getEventService() {
		return EVENT_SERVICE;
	}

	public static DashboardRemoteService getDashboardService() {
		return DASHBOARD_SERVICE;
	}

	public static ConfigurationRemoteService getConfigurationService() {
		return CONFIGURATION_SERVICE;
	}
}
