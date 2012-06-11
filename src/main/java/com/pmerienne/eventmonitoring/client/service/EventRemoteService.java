package com.pmerienne.eventmonitoring.client.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

@Path("events/")
public interface EventRemoteService extends RestService {

	@POST
	@Path("search")
	void search(SearchRequest request, MethodCallback<SearchResults> callback);

	@POST
	@Path("timeSerieSearch")
	void search(TimeSerieRequest request, MethodCallback<TimeSerieResults> callback);

	@POST
	@Path("add")
	void add(Event eventData, MethodCallback<Void> callback);
}
