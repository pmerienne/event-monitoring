package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DataCriterion implements Serializable {

	private static final long serialVersionUID = 1581588588498747536L;

	private String target;

	private RelationalOperator operator;

	private Object value;

	public DataCriterion() {
		super();
	}

	public DataCriterion(String target, RelationalOperator operator, Object value) {
		super();
		this.target = target;
		this.operator = operator;
		this.value = value;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public RelationalOperator getOperator() {
		return operator;
	}

	public void setOperator(RelationalOperator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DataCriterion [target=" + target + ", operator=" + operator + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		DataCriterion other = (DataCriterion) obj;
		if (operator != other.operator)
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public static enum RelationalOperator {
		GT(">"), GTE(">=", "=>"), LT("<"), LTE("<=", "=<"), IS("=="), NE("!=");

		private List<String> values;

		RelationalOperator(String... values) {
			this.values = Arrays.asList(values);
		}

		public List<String> getValues() {
			return values;
		}

		public static RelationalOperator fromValue(String value) {
			for (RelationalOperator candidate : RelationalOperator.values()) {
				if (candidate.getValues().contains(value)) {
					return candidate;
				}
			}
			throw new IllegalArgumentException("No Operator found for '" + value + "'");
		}
	}
}
