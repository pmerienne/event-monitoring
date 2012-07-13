package com.pmerienne.eventmonitoring.client.place.desktop;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ServerDetailsPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<ServerDetailsPlace> {

		@Override
		public ServerDetailsPlace getPlace(String token) {
			return new ServerDetailsPlace();
		}

		@Override
		public String getToken(ServerDetailsPlace place) {
			return "";
		}

	}
}
