package com.pmerienne.eventmonitoring.shared.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Event implements Serializable {

	private static final long serialVersionUID = -645295179948901126L;

	public final static String DATE_FIELD = "date";
	public final static String TYPE_FIELD = "type";
	public final static String ID_FIELD = "_id";
	public final static String DATA_PREFIX = "data";

	private String id;

	private String type;

	private Date date;

	private Map<String, Object> data;

	public Event() {
		this("default");
	}

	public Event(String type) {
		this(type, new Date());
	}

	public Event(String type, Date date) {
		this(type, date, new HashMap<String, Object>());
	}

	public Event(String type, Date date, Map<String, Object> data) {
		super();
		this.type = type;
		this.date = date;
		this.data = data;
	}

	public void addData(String key, Object value) {
		this.data.put(key, value);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Event other = (Event) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", date=" + date + ", data=" + data + "]";
	}

}
