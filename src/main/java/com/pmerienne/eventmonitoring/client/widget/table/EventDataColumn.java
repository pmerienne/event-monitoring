package com.pmerienne.eventmonitoring.client.widget.table;

import java.util.Map;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.cellview.client.TextColumn;
import com.pmerienne.eventmonitoring.shared.model.Event;

public class EventDataColumn extends TextColumn<Event> {

	private final static String DATE_FIELD = "date";
	private final static String TYPE_FIELD = "type";
	private final static String ID_FIELD = "_id";

	private final static String DATA_PREFIX = "data";

	private String field;

	public EventDataColumn(String field, boolean sortable) {
		super();
		this.field = field;
		this.setSortable(sortable);
	}

	@Override
	public String getValue(Event event) {
		String displayedValue = "";
		String[] valuePath = this.field.split("\\.");

		if (valuePath.length == 1 && DATE_FIELD.equals(this.field)) {
			displayedValue = DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).format(event.getDate());
		} else if (valuePath.length == 1 && TYPE_FIELD.equals(this.field)) {
			displayedValue = event.getType();
		} else if (valuePath.length == 1 && ID_FIELD.equals(this.field)) {
			displayedValue = event.getId();
		} else if (this.field.equals(DATA_PREFIX)) {
			displayedValue = event.getData().toString();
		} else if (valuePath.length > 1 && this.field.startsWith(DATA_PREFIX)) {
			Map<?, ?> data = event.getData();
			Object currentValue = null;
			for (int i = 1; i < valuePath.length; i++) {
				currentValue = data.get(valuePath[i]);
				if (currentValue instanceof Map<?, ?>) {
					data = (Map<?, ?>) currentValue;
				}
				if (currentValue != null) {
					displayedValue = currentValue.toString();
				}
			}
		}
		return displayedValue;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
