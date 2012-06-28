package com.pmerienne.eventmonitoring.server.service;

import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.request.PieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.PieResults;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

public interface EventService {

	SearchResults search(SearchRequest request);

	TimeSerieResults search(TimeSerieRequest request);

	PieResults search(PieRequest request);

	void add(Event event);

	void addRandomEvents();
}
