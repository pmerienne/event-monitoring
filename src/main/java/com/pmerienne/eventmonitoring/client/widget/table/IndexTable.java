package com.pmerienne.eventmonitoring.client.widget.table;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public class IndexTable extends CellTable<Index> {

	public IndexTable() {
		TextColumn<Index> keyColumn = new TextColumn<Index>() {
			@Override
			public String getValue(Index index) {
				return index.getKey();
			}
		};
		this.addColumn(keyColumn, "Key");

		TextColumn<Index> ascendingColumn = new TextColumn<Index>() {
			@Override
			public String getValue(Index index) {
				return index.isAscending() ? "Ascending" : "Descending";
			}
		};
		this.addColumn(ascendingColumn, "Order");

		TextColumn<Index> uniqueColumn = new TextColumn<Index>() {
			@Override
			public String getValue(Index index) {
				return Boolean.valueOf(index.isUnique()).toString();
			}
		};
		this.addColumn(uniqueColumn, "Unique");

		TextColumn<Index> dropDupsColumn = new TextColumn<Index>() {
			@Override
			public String getValue(Index index) {
				return index.isDropDuplicates() ? "Drop" : "Retain";
			}
		};
		this.addColumn(dropDupsColumn, "Duplicate");

		// Set fixed size
		this.setTableLayoutFixed(true);
		this.setColumnWidth(keyColumn, "25%");
		this.setColumnWidth(ascendingColumn, "25%");
		this.setColumnWidth(uniqueColumn, "25%");
		this.setColumnWidth(dropDupsColumn, "25%");
	}
}
