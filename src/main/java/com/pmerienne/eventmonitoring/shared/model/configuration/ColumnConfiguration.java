package com.pmerienne.eventmonitoring.shared.model.configuration;

import java.io.Serializable;

public class ColumnConfiguration implements Serializable {

	private static final long serialVersionUID = 973678798826883432L;

	private String target;

	private String label;

	private boolean sortable;

	private String width;

	public ColumnConfiguration() {
		super();
	}

	public ColumnConfiguration(String target, String label, boolean sortable, String width) {
		super();
		this.target = target;
		this.label = label;
		this.sortable = sortable;
		this.width = width;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "ColumnConfiguration [target=" + target + ", label=" + label + ", sortable=" + sortable + ", width=" + width + "]";
	}

}
