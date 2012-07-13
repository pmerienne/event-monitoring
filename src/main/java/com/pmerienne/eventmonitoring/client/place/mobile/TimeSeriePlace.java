package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TimeSeriePlace extends Place {

	private String dashboardId;

	private Integer configurationIndex;

	public TimeSeriePlace() {
		super();
	}

	public String getDashboardId() {
		return dashboardId;
	}

	public Integer getConfigurationIndex() {
		return configurationIndex;
	}

	public TimeSeriePlace(String dashboardId, Integer configurationIndex) {
		super();
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	public static class Tokenizer implements PlaceTokenizer<TimeSeriePlace> {

		@Override
		public TimeSeriePlace getPlace(String token) {
			try {
				String[] splittedToken = token.split(":");
				return new TimeSeriePlace(splittedToken[0], Integer.valueOf(splittedToken[1]));
			} catch (Exception ex) {
				return new TimeSeriePlace();
			}
		}

		@Override
		public String getToken(TimeSeriePlace place) {
			String dashboardId = place.getDashboardId();
			Integer configurationIndex = place.getConfigurationIndex();
			return dashboardId + ":" + configurationIndex;
		}
	}
}