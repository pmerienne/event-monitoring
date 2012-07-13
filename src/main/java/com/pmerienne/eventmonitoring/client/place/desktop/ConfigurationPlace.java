package com.pmerienne.eventmonitoring.client.place.desktop;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ConfigurationPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<ConfigurationPlace> {

		@Override
		public ConfigurationPlace getPlace(String token) {
			return new ConfigurationPlace();
		}

		@Override
		public String getToken(ConfigurationPlace place) {
			return "";
		}

	}
}
