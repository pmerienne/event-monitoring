package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EventListPlace extends Place {

	private String dashboardId;

	private Integer configurationIndex;

	public EventListPlace() {
		super();
	}

	public String getDashboardId() {
		return dashboardId;
	}

	public Integer getConfigurationIndex() {
		return configurationIndex;
	}

	public EventListPlace(String dashboardId, Integer configurationIndex) {
		super();
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	public static class Tokenizer implements PlaceTokenizer<EventListPlace> {

		@Override
		public EventListPlace getPlace(String token) {
			try {
				String[] splittedToken = token.split(":");
				return new EventListPlace(splittedToken[0], Integer.valueOf(splittedToken[1]));
			} catch (Exception ex) {
				return new EventListPlace();
			}
		}

		@Override
		public String getToken(EventListPlace place) {
			String dashboardId = place.getDashboardId();
			Integer configurationIndex = place.getConfigurationIndex();
			return dashboardId + ":" + configurationIndex;
		}
	}
}