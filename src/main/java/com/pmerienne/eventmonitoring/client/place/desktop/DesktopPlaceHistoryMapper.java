package com.pmerienne.eventmonitoring.client.place.desktop;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ LoginPlace.Tokenizer.class, HomePlace.Tokenizer.class, SearchPlace.Tokenizer.class, DashboardPlace.Tokenizer.class,
		DashboardManagementPlace.Tokenizer.class, EditDashboardPlace.Tokenizer.class, ConfigurationPlace.Tokenizer.class,
		ServerDetailsPlace.Tokenizer.class })
public interface DesktopPlaceHistoryMapper extends PlaceHistoryMapper {
}