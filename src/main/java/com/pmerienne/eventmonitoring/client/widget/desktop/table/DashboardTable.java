package com.pmerienne.eventmonitoring.client.widget.desktop.table;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardTable extends CellTable<Dashboard> {

	private final static Integer DESCRIPTION_LIMIT = 40;

	public DashboardTable() {
		super();

		TextColumn<Dashboard> nameColumn = new TextColumn<Dashboard>() {
			@Override
			public String getValue(Dashboard dashboard) {
				return dashboard.getName();
			}
		};
		this.addColumn(nameColumn, "Name");

		TextColumn<Dashboard> descriptionColumn = new TextColumn<Dashboard>() {
			@Override
			public String getValue(Dashboard dashboard) {
				String description = dashboard.getDescription();
				Integer limit = description.length() < DESCRIPTION_LIMIT ? description.length() : DESCRIPTION_LIMIT;
				return dashboard.getDescription().substring(0, limit);
			}
		};
		this.addColumn(descriptionColumn, "Description");

		TextColumn<Dashboard> idColumn = new TextColumn<Dashboard>() {
			@Override
			public String getValue(Dashboard dashboard) {
				return dashboard.getId();
			}
		};
		this.addColumn(idColumn, "Id");

		// Set fixed size
		this.setTableLayoutFixed(true);
		this.setColumnWidth(nameColumn, "33%");
		this.setColumnWidth(descriptionColumn, "33%");
		this.setColumnWidth(idColumn, "33%");
	}
}
