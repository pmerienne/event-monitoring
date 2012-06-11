package com.pmerienne.eventmonitoring.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ LoginPlace.Tokenizer.class, HomePlace.Tokenizer.class, SearchPlace.Tokenizer.class, DashboardPlace.Tokenizer.class,
		DashboardManagementPlace.Tokenizer.class, EditDashboardPlace.Tokenizer.class, ConfigurationPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}