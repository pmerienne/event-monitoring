package com.pmerienne.eventmonitoring.shared.model;

import java.io.Serializable;
import java.util.Date;

public class TimeData implements Serializable, Comparable<TimeData> {

	private static final long serialVersionUID = -8375088391923044407L;

	private Date date;

	private Double value;

	public TimeData() {
		super();
	}

	public TimeData(Date date, Double value) {
		super();
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TimeData other = (TimeData) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeData [date=" + date + ", value=" + value + "]";
	}

	@Override
	public int compareTo(TimeData o) {
		if (o == null) {
			return 1;
		} else {
			return this.date.compareTo(o.date);
		}
	}

}
