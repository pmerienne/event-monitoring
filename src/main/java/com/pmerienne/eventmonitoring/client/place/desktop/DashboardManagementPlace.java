package com.pmerienne.eventmonitoring.client.place.desktop;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DashboardManagementPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<DashboardManagementPlace> {

		@Override
		public DashboardManagementPlace getPlace(String token) {
			return new DashboardManagementPlace();
		}

		@Override
		public String getToken(DashboardManagementPlace place) {
			return "";
		}

	}
}
