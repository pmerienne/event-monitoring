package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;

public class Projection implements Serializable {

	private static final long serialVersionUID = -8196922117159715847L;

	private String target;

	private Function operator;

	public Projection() {
		super();
	}

	public Projection(String target, Function operator) {
		super();
		this.target = target;
		this.operator = operator;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Function getOperator() {
		return operator;
	}

	public void setOperator(Function operator) {
		this.operator = operator;
	}

	public static enum Function {
		SUM, MEAN, COUNT
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Projection other = (Projection) obj;
		if (operator != other.operator)
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projection [target=" + target + ", operator=" + operator + "]";
	}

}
