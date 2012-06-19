package com.pmerienne.eventmonitoring.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class Dashboard implements Serializable {

	private static final long serialVersionUID = -9168560961869330412L;

	private String id;

	private String name;

	private String description;

	private List<GraphConfiguration> graphConfigurations = new ArrayList<GraphConfiguration>();

	private List<TableConfiguration> tableConfigurations = new ArrayList<TableConfiguration>();

	public Dashboard() {
		super();
	}

	public Dashboard(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Dashboard(String id, String name, String description, List<GraphConfiguration> graphConfigurations, List<TableConfiguration> tableConfigurations) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.graphConfigurations = graphConfigurations;
		this.tableConfigurations = tableConfigurations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GraphConfiguration> getGraphConfigurations() {
		return graphConfigurations;
	}

	public void setGraphConfigurations(List<GraphConfiguration> graphConfigurations) {
		this.graphConfigurations = graphConfigurations;
	}

	public List<TableConfiguration> getTableConfigurations() {
		return tableConfigurations;
	}

	public void setTableConfigurations(List<TableConfiguration> tableConfigurations) {
		this.tableConfigurations = tableConfigurations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((graphConfigurations == null) ? 0 : graphConfigurations.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tableConfigurations == null) ? 0 : tableConfigurations.hashCode());
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
		Dashboard other = (Dashboard) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (graphConfigurations == null) {
			if (other.graphConfigurations != null)
				return false;
		} else if (!graphConfigurations.equals(other.graphConfigurations))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tableConfigurations == null) {
			if (other.tableConfigurations != null)
				return false;
		} else if (!tableConfigurations.equals(other.tableConfigurations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dashboard [id=" + id + ", name=" + name + ", description=" + description + ", graphConfigurations=" + graphConfigurations
				+ ", tableConfigurations=" + tableConfigurations + "]";
	}

}
