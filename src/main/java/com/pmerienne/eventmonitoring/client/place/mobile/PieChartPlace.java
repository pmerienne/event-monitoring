package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PieChartPlace extends Place {

	private String dashboardId;

	private Integer configurationIndex;

	public PieChartPlace() {
		super();
	}

	public String getDashboardId() {
		return dashboardId;
	}

	public Integer getConfigurationIndex() {
		return configurationIndex;
	}

	public PieChartPlace(String dashboardId, Integer configurationIndex) {
		super();
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	public static class Tokenizer implements PlaceTokenizer<PieChartPlace> {

		@Override
		public PieChartPlace getPlace(String token) {
			try {
				String[] splittedToken = token.split(":");
				return new PieChartPlace(splittedToken[0], Integer.valueOf(splittedToken[1]));
			} catch (Exception ex) {
				return new PieChartPlace();
			}
		}

		@Override
		public String getToken(PieChartPlace place) {
			String dashboardId = place.getDashboardId();
			Integer configurationIndex = place.getConfigurationIndex();
			return dashboardId + ":" + configurationIndex;
		}
	}
}
