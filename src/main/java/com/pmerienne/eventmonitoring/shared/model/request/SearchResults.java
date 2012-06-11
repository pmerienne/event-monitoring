package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.Event;

public class SearchResults implements Serializable {

	private static final long serialVersionUID = -4613201581611070105L;

	private SearchRequest request;

	private List<Event> events = new ArrayList<Event>();

	private Long totalCount;

	public SearchResults() {
		super();
	}

	public SearchResults(SearchRequest request, List<Event> events, Long totalCount) {
		super();
		this.request = request;
		this.events = events;
		this.totalCount = totalCount;
	}

	public SearchRequest getRequest() {
		return request;
	}

	public void setRequest(SearchRequest request) {
		this.request = request;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "SearchResults [request=" + request + ", events=" + events + ", totalCount=" + totalCount + "]";
	}

}
