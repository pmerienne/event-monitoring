package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlace.Tokenizer.class, DashboardListPlace.Tokenizer.class, DashboardPlace.Tokenizer.class, PieChartPlace.Tokenizer.class,
		TimeSeriePlace.Tokenizer.class, EventListPlace.Tokenizer.class })
public interface MobilePlaceHistoryMapper extends PlaceHistoryMapper {

}
