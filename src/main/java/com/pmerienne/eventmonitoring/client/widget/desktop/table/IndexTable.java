package com.pmerienne.eventmonitoring.client.widget.desktop.table;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;
import com.pmerienne.eventmonitoring.shared.model.administration.IndexKey;

public class IndexTable extends CellTable<Index> {

	public IndexTable() {
		TextColumn<Index> keysColumn = new TextColumn<Index>() {
			@Override
			public String getValue(Index index) {
				StringBuilder sb = new StringBuilder();
				for (IndexKey indexKey : index.getKeys()) {
					sb.append(indexKey.getName() + " (ascending : " + indexKey.getAscending() + ") ");
				}
				return sb.toString();
			}
		};
		this.addColumn(keysColumn, "Keys");

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
		this.setColumnWidth(keysColumn, "50%");
		this.setColumnWidth(uniqueColumn, "25%");
		this.setColumnWidth(dropDupsColumn, "25%");
	}
}
