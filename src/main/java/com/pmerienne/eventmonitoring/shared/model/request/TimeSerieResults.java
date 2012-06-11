package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.TimeData;


public class TimeSerieResults implements Serializable {

	private static final long serialVersionUID = 5724836557793965930L;

	private TimeSerieRequest request;

	private List<TimeData> data = new ArrayList<TimeData>();

	public TimeSerieResults() {
	}

	public TimeSerieResults(TimeSerieRequest request) {
		this.request = request;
	}

	public void addData(TimeData timeData) {
		this.data.add(timeData);
	}

	public TimeSerieRequest getRequest() {
		return request;
	}

	public void setRequest(TimeSerieRequest request) {
		this.request = request;
	}

	public List<TimeData> getData() {
		return data;
	}

	public void setData(List<TimeData> data) {
		this.data = data;
	}

}
