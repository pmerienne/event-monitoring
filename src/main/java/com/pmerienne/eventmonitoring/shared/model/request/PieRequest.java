package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.Date;

import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class PieRequest implements Serializable {

	private static final long serialVersionUID = 1556521576804229196L;

	private SerieConfiguration configuration;

	private Date from;

	private Date to;

	public PieRequest() {
		super();
	}

	public PieRequest(SerieConfiguration configuration, Date from, Date to) {
		super();
		this.configuration = configuration;
		this.from = from;
		this.to = to;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configuration == null) ? 0 : configuration.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PieRequest other = (PieRequest) obj;
		if (configuration == null) {
			if (other.configuration != null)
				return false;
		} else if (!configuration.equals(other.configuration))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PieRequest [configuration=" + configuration + ", from=" + from + ", to=" + to + "]";
	}

}
