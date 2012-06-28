package com.pmerienne.eventmonitoring.shared.model;

import java.io.Serializable;

public class PieData implements Serializable {

	private static final long serialVersionUID = 6388488290284219298L;

	private String serieName;

	private Double value;

	public PieData() {
		super();
	}

	public PieData(String serieName, Double value) {
		super();
		this.serieName = serieName;
		this.value = value;
	}

	public String getSerieName() {
		return serieName;
	}

	public void setSerieName(String serieName) {
		this.serieName = serieName;
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
		result = prime * result + ((serieName == null) ? 0 : serieName.hashCode());
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
		PieData other = (PieData) obj;
		if (serieName == null) {
			if (other.serieName != null)
				return false;
		} else if (!serieName.equals(other.serieName))
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
		return "ChartData [serieName=" + serieName + ", value=" + value + "]";
	}

}
