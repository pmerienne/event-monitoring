package com.pmerienne.eventmonitoring.shared.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class SearchRequest implements Serializable {

	private static final long serialVersionUID = 3204176978513115228L;

	private TableConfiguration tableConfiguration;

	private Integer start;

	private Integer end;

	private Boolean needTotalCount = false;

	private List<SortedField> sortedFields = new ArrayList<SortedField>();

	public SearchRequest() {
		super();
	}

	public SearchRequest(TableConfiguration tableConfiguration, Integer start, Integer end) {
		super();
		this.tableConfiguration = tableConfiguration;
		this.start = start;
		this.end = end;
	}

	public SearchRequest(TableConfiguration tableConfiguration, Integer start, Integer end, List<SortedField> sortedFields) {
		super();
		this.tableConfiguration = tableConfiguration;
		this.start = start;
		this.end = end;
		this.sortedFields = sortedFields;
	}

	public SearchRequest(TableConfiguration tableConfiguration, Integer start, Integer end, Boolean needTotalCount, List<SortedField> sortedFields) {
		super();
		this.tableConfiguration = tableConfiguration;
		this.start = start;
		this.end = end;
		this.needTotalCount = needTotalCount;
		this.sortedFields = sortedFields;
	}

	public TableConfiguration getTableConfiguration() {
		return tableConfiguration;
	}

	public void setTableConfiguration(TableConfiguration tableConfiguration) {
		this.tableConfiguration = tableConfiguration;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public List<SortedField> getSortedFields() {
		return sortedFields;
	}

	public void setSortedFields(List<SortedField> sortedFields) {
		this.sortedFields = sortedFields;
	}

	public Boolean getNeedTotalCount() {
		return needTotalCount;
	}

	public void setNeedTotalCount(Boolean needTotalCount) {
		this.needTotalCount = needTotalCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + (needTotalCount ? 1231 : 1237);
		result = prime * result + ((sortedFields == null) ? 0 : sortedFields.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((tableConfiguration == null) ? 0 : tableConfiguration.hashCode());
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
		SearchRequest other = (SearchRequest) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (needTotalCount != other.needTotalCount)
			return false;
		if (sortedFields == null) {
			if (other.sortedFields != null)
				return false;
		} else if (!sortedFields.equals(other.sortedFields))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (tableConfiguration == null) {
			if (other.tableConfiguration != null)
				return false;
		} else if (!tableConfiguration.equals(other.tableConfiguration))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SearchRequest [tableConfiguration=" + tableConfiguration + ", start=" + start + ", end=" + end + ", needTotalCount=" + needTotalCount
				+ ", sortedFields=" + sortedFields + "]";
	}

	public static class SortedField implements Serializable {

		private static final long serialVersionUID = 4291492216118029773L;

		private String field;

		private boolean ascending;

		public SortedField() {
			super();
		}

		public SortedField(String field, boolean ascending) {
			super();
			this.field = field;
			this.ascending = ascending;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public boolean isAscending() {
			return ascending;
		}

		public void setAscending(boolean ascending) {
			this.ascending = ascending;
		}

		@Override
		public String toString() {
			return "Sort [field=" + field + ", ascending=" + ascending + "]";
		}

	}

}
