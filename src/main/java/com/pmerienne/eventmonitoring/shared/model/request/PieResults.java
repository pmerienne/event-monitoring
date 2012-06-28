package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;

import com.pmerienne.eventmonitoring.shared.model.PieData;

public class PieResults implements Serializable {

	private static final long serialVersionUID = 8964927253637504858L;

	private PieRequest request;

	private PieData data;

	public PieResults() {
		super();
	}

	public PieResults(PieRequest request) {
		super();
		this.request = request;
	}

	public PieResults(PieRequest request, PieData data) {
		super();
		this.request = request;
		this.data = data;
	}

	public PieRequest getRequest() {
		return request;
	}

	public void setRequest(PieRequest request) {
		this.request = request;
	}

	public PieData getData() {
		return data;
	}

	public void setData(PieData data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
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
		PieResults other = (PieResults) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PieResults [request=" + request + ", data=" + data + "]";
	}

}
