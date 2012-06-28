package com.pmerienne.eventmonitoring.server.repository;

import com.pmerienne.eventmonitoring.shared.model.request.PieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.PieResults;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

public interface EventSearcher {

	TimeSerieResults search(TimeSerieRequest request);

	SearchResults search(SearchRequest request);

	PieResults search(PieRequest request);
}
