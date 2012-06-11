package com.pmerienne.eventmonitoring.server.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pmerienne.eventmonitoring.server.service.EventService;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;
import com.sun.jersey.api.core.InjectParam;

@Path("/events")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class EventsResource {

	@InjectParam
	private EventService eventService;

	@POST
	@Path("search")
	public SearchResults search(SearchRequest request) {
		return this.eventService.search(request);
	}

	@POST
	@Path("timeSerieSearch")
	public TimeSerieResults search(TimeSerieRequest request) {
		return this.eventService.search(request);
	}

	@POST
	@Path("add")
	public void add(Event event) {
		this.eventService.add(event);
	}
}
