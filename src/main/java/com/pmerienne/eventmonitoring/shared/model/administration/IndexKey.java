package com.pmerienne.eventmonitoring.shared.model.administration;

import java.io.Serializable;

public class IndexKey implements Serializable {

	private static final long serialVersionUID = 5598898783656981484L;

	private String name;

	private Boolean ascending = false;

	public IndexKey() {
		super();
	}

	public IndexKey(String name, Boolean ascending) {
		super();
		this.name = name;
		this.ascending = ascending;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAscending() {
		return ascending;
	}

	public void setAscending(Boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ascending == null) ? 0 : ascending.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		IndexKey other = (IndexKey) obj;
		if (ascending == null) {
			if (other.ascending != null)
				return false;
		} else if (!ascending.equals(other.ascending))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IndexKey [name=" + name + ", ascending=" + ascending + "]";
	}

}
