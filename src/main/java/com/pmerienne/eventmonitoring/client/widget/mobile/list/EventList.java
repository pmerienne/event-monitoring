package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;

public class EventList extends BasicList<Event> implements HasCellSelectedHandler {

	public EventList(List<ColumnConfiguration> columnConfigurations) {
		super(new EventCell(columnConfigurations));
	}

	public static class EventCell implements Cell<Event> {

		private static StartCellTemplate START_CELL_TEMPLATE = GWT.create(StartCellTemplate.class);
		private static EndCellTemplate END_CELL_TEMPLATE = GWT.create(EndCellTemplate.class);
		private static FieldTemplate FIELD_TEMPLATE = GWT.create(FieldTemplate.class);

		private final List<ColumnConfiguration> configurations;

		public EventCell(List<ColumnConfiguration> configurations) {
			super();
			this.configurations = configurations;
		}

		public interface StartCellTemplate extends SafeHtmlTemplates {
			@SafeHtmlTemplates.Template("<div class=\"{0}\">")
			SafeHtml content(String classes);
		}

		public interface FieldTemplate extends SafeHtmlTemplates {
			@SafeHtmlTemplates.Template("<p><b>{0} : </b>{1}</div>")
			SafeHtml content(String label, String value);
		}

		public interface EndCellTemplate extends SafeHtmlTemplates {
			@SafeHtmlTemplates.Template("</div>")
			SafeHtml content();
		}

		@Override
		public void render(SafeHtmlBuilder safeHtmlBuilder, final Event event) {
			safeHtmlBuilder.append(START_CELL_TEMPLATE.content("mgwt-List-Cell"));
			for (ColumnConfiguration configuration : this.configurations) {
				safeHtmlBuilder.append(this.getField(event, configuration));
			}
			safeHtmlBuilder.append(END_CELL_TEMPLATE.content());
		}

		public SafeHtml getField(Event event, ColumnConfiguration configuration) {
			String label = configuration.getLabel();
			String target = configuration.getTarget();
			String value = this.getFieldValue(event, target);

			return FIELD_TEMPLATE.content(label, value);
		}

		private String getFieldValue(Event event, String field) {
			String value = "";
			String[] valuePath = field.split("\\.");

			if (valuePath.length == 1 && Event.DATE_FIELD.equals(field)) {
				value = DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).format(event.getDate());
			} else if (valuePath.length == 1 && Event.TYPE_FIELD.equals(field)) {
				value = event.getType();
			} else if (valuePath.length == 1 && Event.ID_FIELD.equals(field)) {
				value = event.getId();
			} else if (field.equals(Event.DATA_PREFIX)) {
				value = event.getData().toString();
			} else if (valuePath.length > 1 && field.startsWith(Event.DATA_PREFIX)) {
				Map<?, ?> data = event.getData();
				Object currentValue = null;
				for (int i = 1; i < valuePath.length; i++) {
					currentValue = data.get(valuePath[i]);
					if (currentValue instanceof Map<?, ?>) {
						data = (Map<?, ?>) currentValue;
					}
					if (currentValue != null) {
						value = currentValue.toString();
					}
				}
			}
			return value;
		}

		@Override
		public boolean canBeSelected(Event event) {
			return event != null;
		}

	}
}
