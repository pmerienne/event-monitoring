package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class EventTableList extends BasicList<TableConfiguration> implements HasCellSelectedHandler {

	public EventTableList() {
		super(new BasicCell<TableConfiguration>() {
			@Override
			public String getTitleString(TableConfiguration configuration) {
				String title = configuration.getName();
				return title;
			}

			@Override
			public String getSecondaryString(TableConfiguration configuration) {
				String fields = "";
				int i = 0;
				for (ColumnConfiguration columnConfiguration : configuration.getColumnConfigurations()) {
					i++;
					fields += columnConfiguration.getLabel();
					if (i < configuration.getColumnConfigurations().size()) {
						fields += ", ";
					}
				}

				if (fields.length() > CHAR_LIMIT) {
					fields = fields.substring(0, CHAR_LIMIT);
				}
				return fields;
			}
		});
		this.setHeader("Event tables");
	}

}