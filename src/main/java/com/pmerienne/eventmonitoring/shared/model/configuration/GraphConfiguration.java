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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serieConfigurations == null) ? 0 : serieConfigurations.hashCode());
		result = prime * result + ((timeRange == null) ? 0 : timeRange.hashCode());
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
		GraphConfiguration other = (GraphConfiguration) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serieConfigurations == null) {
			if (other.serieConfigurations != null)
				return false;
		} else if (!serieConfigurations.equals(other.serieConfigurations))
			return false;
		if (timeRange == null) {
			if (other.timeRange != null)
				return false;
		} else if (!timeRange.equals(other.timeRange))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GraphConfiguration [name=" + name + ", timeRange=" + timeRange + ", serieConfigurations=" + serieConfigurations + "]";
	}

}
