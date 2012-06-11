package com.pmerienne.eventmonitoring.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EditDashboardPlace extends Place {

	private String id;

	public EditDashboardPlace() {
		super();
	}

	public EditDashboardPlace(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static class Tokenizer implements PlaceTokenizer<EditDashboardPlace> {

		@Override
		public EditDashboardPlace getPlace(String token) {
			return new EditDashboardPlace(token);
		}

		@Override
		public String getToken(EditDashboardPlace place) {
			return place.getId();
		}

	}
}