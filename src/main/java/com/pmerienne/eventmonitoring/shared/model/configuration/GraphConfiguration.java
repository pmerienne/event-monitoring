package com.pmerienne.eventmonitoring.shared.model.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraphConfiguration implements Serializable {

	private static final long serialVersionUID = -2139920224893439554L;

	private String name;

	private Long timeRange;

	private List<SerieConfiguration> serieConfigurations = new ArrayList<SerieConfiguration>();

	public GraphConfiguration() {
		super();
	}

	public GraphConfiguration(String name, Long timeRange, Double yAxisMin, Double yAxisMax, List<SerieConfiguration> serieConfigurations) {
		super();
		this.name = name;
		this.timeRange = timeRange;
		this.serieConfigurations = serieConfigurations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(Long timeRange) {
		this.timeRange = timeRange;
	}

	public List<SerieConfiguration> getSerieConfigurations() {
		return serieConfigurations;
	}

	public void setSerieConfigurations(List<SerieConfiguration> serieConfigurations) {
		this.serieConfigurations = serieConfigurations;
	}

}
