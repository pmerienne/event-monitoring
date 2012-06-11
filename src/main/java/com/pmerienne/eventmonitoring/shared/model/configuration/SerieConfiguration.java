package com.pmerienne.eventmonitoring.shared.model.configuration;

import java.io.Serializable;

import org.moxieapps.gwt.highcharts.client.Series.Type;

public class SerieConfiguration implements Serializable {

	private static final long serialVersionUID = 549799236088449812L;

	private String name;

	private Long interval;

	private String projectionQuery;

	private String criteriaQuery;

	private Type type;

	private String color;

	public SerieConfiguration() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setSerieName(String serieName) {
		this.name = serieName;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public String getProjectionQuery() {
		return projectionQuery;
	}

	public void setProjectionQuery(String projectionQuery) {
		this.projectionQuery = projectionQuery;
	}

	public String getCriteriaQuery() {
		return criteriaQuery;
	}

	public void setCriteriaQuery(String criteriaQuery) {
		this.criteriaQuery = criteriaQuery;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((criteriaQuery == null) ? 0 : criteriaQuery.hashCode());
		result = prime * result + ((interval == null) ? 0 : interval.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectionQuery == null) ? 0 : projectionQuery.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SerieConfiguration other = (SerieConfiguration) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (criteriaQuery == null) {
			if (other.criteriaQuery != null)
				return false;
		} else if (!criteriaQuery.equals(other.criteriaQuery))
			return false;
		if (interval == null) {
			if (other.interval != null)
				return false;
		} else if (!interval.equals(other.interval))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectionQuery == null) {
			if (other.projectionQuery != null)
				return false;
		} else if (!projectionQuery.equals(other.projectionQuery))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SerieConfiguration [name=" + name + ", interval=" + interval + ", projectionQuery=" + projectionQuery + ", criteriaQuery=" + criteriaQuery
				+ ", type=" + type + ", color=" + color + "]";
	}

}
