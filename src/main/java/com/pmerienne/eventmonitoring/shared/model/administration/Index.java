package com.pmerienne.eventmonitoring.shared.model.administration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Index implements Serializable {

	private static final long serialVersionUID = -51404023763940484L;

	private List<IndexKey> keys = new ArrayList<IndexKey>();

	private boolean unique = false;

	private boolean dropDuplicates = false;

	public Index() {
	}

	public Index(boolean unique, boolean dropDuplicates) {
		super();
		this.unique = unique;
		this.dropDuplicates = dropDuplicates;
	}

	public Index(List<IndexKey> keys, boolean unique, boolean dropDuplicates) {
		super();
		this.keys = keys;
		this.unique = unique;
		this.dropDuplicates = dropDuplicates;
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

	public List<IndexKey> getKeys() {
		return keys;
	}

	public void setKeys(List<IndexKey> keys) {
		this.keys = keys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dropDuplicates ? 1231 : 1237);
		result = prime * result + ((keys == null) ? 0 : keys.hashCode());
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
		if (dropDuplicates != other.dropDuplicates)
			return false;
		if (keys == null) {
			if (other.keys != null)
				return false;
		} else if (!keys.equals(other.keys))
			return false;
		if (unique != other.unique)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Index [keys=" + keys + ", unique=" + unique + ", dropDuplicates=" + dropDuplicates + "]";
	}

}
