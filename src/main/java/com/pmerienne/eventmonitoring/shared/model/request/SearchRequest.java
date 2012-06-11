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

	@Override
	public String toString() {
		return "EventTableRequest [tableConfiguration=" + tableConfiguration + ", start=" + start + ", end=" + end + ", sortedFields=" + sortedFields + "]";
	}

}
