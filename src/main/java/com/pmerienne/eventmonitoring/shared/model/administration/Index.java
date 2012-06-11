package com.pmerienne.eventmonitoring.shared.model.administration;

import java.io.Serializable;

public class Index implements Serializable {

	private static final long serialVersionUID = -51404023763940484L;

	private String key;

	private boolean ascending = true;

	private boolean unique = false;

	private boolean dropDuplicates = false;

	public Index() {
	}

	public Index(String key) {
		super();
		this.key = key;
	}

	public Index(String key, boolean ascending) {
		super();
		this.key = key;
		this.ascending = ascending;
	}

	public Index(String key, boolean ascending, boolean unique, boolean dropDuplicates) {
		super();
		this.key = key;
		this.ascending = ascending;
		this.unique = unique;
		this.dropDuplicates = dropDuplicates;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isDropDuplicates() {
		return dropDuplicates;
	}

	public void setDropDuplicates(boolean dropDuplicates) {
		this.dropDuplicates = dropDuplicates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ascending ? 1231 : 1237);
		result = prime * result + (dropDuplicates ? 1231 : 1237);
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + (unique ? 1231 : 1237);
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
		Index other = (Index) obj;
		if (ascending != other.ascending)
			return false;
		if (dropDuplicates != other.dropDuplicates)
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (unique != other.unique)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Index [key=" + key + ", ascending=" + ascending + ", unique=" + unique + ", dropDuplicates=" + dropDuplicates + "]";
	}

}
