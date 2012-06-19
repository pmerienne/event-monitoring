package com.pmerienne.eventmonitoring.shared.model.administration;

import java.io.Serializable;

public class DatabaseInformation implements Serializable {

	private static final long serialVersionUID = 6907233112932227541L;

	private String name;

	private Long objects;

	private Long dataSize;

	private Long storageSize;

	private Long indexSize;

	private Long fileSize;

	public DatabaseInformation() {
		super();
	}

	public DatabaseInformation(String name, Long objects, Long dataSize, Long storageSize, Long indexSize, Long fileSize) {
		super();
		this.name = name;
		this.objects = objects;
		this.dataSize = dataSize;
		this.storageSize = storageSize;
		this.indexSize = indexSize;
		this.fileSize = fileSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getObjects() {
		return objects;
	}

	public void setObjects(Long objects) {
		this.objects = objects;
	}

	public Long getDataSize() {
		return dataSize;
	}

	public void setDataSize(Long dataSize) {
		this.dataSize = dataSize;
	}

	public Long getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(Long storageSize) {
		this.storageSize = storageSize;
	}

	public Long getIndexSize() {
		return indexSize;
	}

	public void setIndexSize(Long indexSize) {
		this.indexSize = indexSize;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSize == null) ? 0 : dataSize.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((indexSize == null) ? 0 : indexSize.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		result = prime * result + ((storageSize == null) ? 0 : storageSize.hashCode());
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
		DatabaseInformation other = (DatabaseInformation) obj;
		if (dataSize == null) {
			if (other.dataSize != null)
				return false;
		} else if (!dataSize.equals(other.dataSize))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (indexSize == null) {
			if (other.indexSize != null)
				return false;
		} else if (!indexSize.equals(other.indexSize))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		if (storageSize == null) {
			if (other.storageSize != null)
				return false;
		} else if (!storageSize.equals(other.storageSize))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatabaseInformation [name=" + name + ", objects=" + objects + ", dataSize=" + dataSize + ", storageSize=" + storageSize + ", indexSize="
				+ indexSize + ", fileSize=" + fileSize + "]";
	}

}
