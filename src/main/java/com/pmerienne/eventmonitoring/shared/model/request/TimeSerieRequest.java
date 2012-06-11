package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.Date;

import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class TimeSerieRequest implements Serializable {

	private static final long serialVersionUID = -8136009868412775931L;

	private SerieConfiguration configuration;

	private Date from;

	private Date to;

	public TimeSerieRequest() {
		super();
	}

	public TimeSerieRequest(SerieConfiguration configuration, Date from, Date to) {
		super();
		this.configuration = configuration;

		// Truncate date to be valid with interval
		Date truncatedFrom = new Date(from.getTime() - from.getTime() % configuration.getInterval());
		Date truncatedTo = new Date(to.getTime() - to.getTime() % configuration.getInterval());

		this.from = truncatedFrom;
		this.to = truncatedTo;
	}

	public SerieConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(SerieConfiguration configuration) {
		this.configuration = configuration;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "TimeSeriesRequest [configuration=" + configuration + ", from=" + from + ", to=" + to + "]";
	}

}
