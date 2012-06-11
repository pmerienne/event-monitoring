package com.pmerienne.eventmonitoring.client.widget.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class GraphConfigurationEditor extends Composite implements Editor<GraphConfiguration> {

	private static GraphConfigurationEditorUiBinder uiBinder = GWT.create(GraphConfigurationEditorUiBinder.class);

	interface GraphConfigurationEditorUiBinder extends UiBinder<Widget, GraphConfigurationEditor> {
	}

	@UiField
	HeadingElement graphTitle;

	@UiField
	TextInput nameInput;

	@UiField
	TimeRangeInput timeRangeInput;

	@UiField
	NumberInput intervalInput;

	@UiField
	HTMLPanel seriesContainer;

	private GraphConfiguration graphConfiguration;

	public GraphConfigurationEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		SerieConfigurationEditor editor = new SerieConfigurationEditor();
		this.seriesContainer.add(editor);
	}

	@UiHandler("addTimeSerieButton")
	protected void onAddTimeSerieClicked(ClickEvent event) {
		SerieConfigurationEditor editor = new SerieConfigurationEditor();
		this.seriesContainer.add(editor);
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@Override
	public void setValue(GraphConfiguration graphConfiguration) {
		this.clear();
		this.graphConfiguration = graphConfiguration;
		this.graphTitle.setInnerHTML("Graph : " + graphConfiguration.getName());
		this.nameInput.setValue(graphConfiguration.getName());
		this.timeRangeInput.setValue(graphConfiguration.getTimeRange());

		this.seriesContainer.clear();
		for (SerieConfiguration serieConfiguration : graphConfiguration.getSerieConfigurations()) {
			this.intervalInput.setValue(serieConfiguration.getInterval().toString());
			SerieConfigurationEditor editor = new SerieConfigurationEditor();
			editor.setValue(serieConfiguration);
			this.seriesContainer.add(editor);
		}
	}

	@Override
	public GraphConfiguration getValue() {
		if (this.graphConfiguration == null) {
			this.graphConfiguration = new GraphConfiguration();
		}

		this.graphConfiguration.setName(this.nameInput.getValue());
		this.graphConfiguration.setTimeRange(this.timeRangeInput.getValue());

		this.graphConfiguration.getSerieConfigurations().clear();
		for (int i = 0; i < this.seriesContainer.getWidgetCount(); i++) {
			Widget w = this.seriesContainer.getWidget(i);
			if (w instanceof SerieConfigurationEditor) {
				SerieConfiguration serieConfiguration = ((SerieConfigurationEditor) w).getValue();
				serieConfiguration.setInterval(Long.valueOf(this.intervalInput.getValue()));
				this.graphConfiguration.getSerieConfigurations().add(serieConfiguration);
			}
		}

		return this.graphConfiguration;
	}

	@Override
	public void clear() {
		this.graphConfiguration = new GraphConfiguration();

		// Clear all series
		this.seriesContainer.clear();

		// Clear values/error
		this.nameInput.clear();
		this.timeRangeInput.clear();
		this.intervalInput.clear();
	}

	@Override
	public boolean validate() {
		// Name validation
		boolean isNameValid = this.nameInput.validate();

		// Interval validation
		boolean isIntervalValid = this.intervalInput.validate();

		// Series validation
		boolean areSeriesValid = true;
		for (int i = 0; i < this.seriesContainer.getWidgetCount(); i++) {
			Widget w = this.seriesContainer.getWidget(i);
			if (w instanceof SerieConfigurationEditor) {
				areSeriesValid = ((SerieConfigurationEditor) w).validate() && areSeriesValid;
			}
		}

		return isNameValid && isIntervalValid && areSeriesValid;
	}

}
