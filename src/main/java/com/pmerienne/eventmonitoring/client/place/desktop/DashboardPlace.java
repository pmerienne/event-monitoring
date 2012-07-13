package com.pmerienne.eventmonitoring.client.place.desktop;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DashboardPlace extends Place {

	private String id;

	public DashboardPlace() {
		super();
	}

	public DashboardPlace(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static class Tokenizer implements PlaceTokenizer<DashboardPlace> {

		@Override
		public DashboardPlace getPlace(String token) {
			return new DashboardPlace(token);
		}

		@Override
		public String getToken(DashboardPlace place) {
			return place.getId();
		}

	}
}
