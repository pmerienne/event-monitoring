package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DashboardListPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<DashboardListPlace> {

		@Override
		public DashboardListPlace getPlace(String token) {
			return new DashboardListPlace();
		}

		@Override
		public String getToken(DashboardListPlace place) {
			return "";
		}

	}
}
