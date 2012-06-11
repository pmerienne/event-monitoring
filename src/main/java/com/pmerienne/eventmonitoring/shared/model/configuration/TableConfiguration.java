package com.pmerienne.eventmonitoring.shared.model.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableConfiguration implements Serializable {

	private static final long serialVersionUID = 1360676989842179346L;

	private String name;

	private Integer nbResults;

	private String criteria;

	private Long timeRange;

	private List<ColumnConfiguration> columnConfigurations = new ArrayList<ColumnConfiguration>();

	public TableConfiguration() {
		super();
	}

	public TableConfiguration(String name, Integer nbResults, Long timeRange) {
		super();
		this.name = name;
		this.nbResults = nbResults;
		this.timeRange = timeRange;
	}

	public TableConfiguration(String name, Integer nbResults, String criteria, Long timeRange, List<ColumnConfiguration> columnConfigurations) {
		super();
		this.name = name;
		this.nbResults = nbResults;
		this.criteria = criteria;
		this.timeRange = timeRange;
		this.columnConfigurations = columnConfigurations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNbResults() {
		return nbResults;
	}

	public void setNbResults(Integer nbResults) {
		this.nbResults = nbResults;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Long getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(Long timeRange) {
		this.timeRange = timeRange;
	}

	public List<ColumnConfiguration> getColumnConfigurations() {
		return columnConfigurations;
	}

	public void setColumnConfigurations(List<ColumnConfiguration> columnConfigurations) {
		this.columnConfigurations = columnConfigurations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnConfigurations == null) ? 0 : columnConfigurations.hashCode());
		result = prime * result + ((criteria == null) ? 0 : criteria.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nbResults == null) ? 0 : nbResults.hashCode());
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
		TableConfiguration other = (TableConfiguration) obj;
		if (columnConfigurations == null) {
			if (other.columnConfigurations != null)
				return false;
		} else if (!columnConfigurations.equals(other.columnConfigurations))
			return false;
		if (criteria == null) {
			if (other.criteria != null)
				return false;
		} else if (!criteria.equals(other.criteria))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbResults == null) {
			if (other.nbResults != null)
				return false;
		} else if (!nbResults.equals(other.nbResults))
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
		return "TableConfiguration [name=" + name + ", nbResults=" + nbResults + ", criteria=" + criteria + ", timeRange=" + timeRange
				+ ", columnConfigurations=" + columnConfigurations + "]";
	}

}
