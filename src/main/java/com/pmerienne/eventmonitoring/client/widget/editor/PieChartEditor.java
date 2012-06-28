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

public class PieChartEditor extends Composite implements Editor<GraphConfiguration> {

	private static PieChartEditorUiBinder uiBinder = GWT.create(PieChartEditorUiBinder.class);

	interface PieChartEditorUiBinder extends UiBinder<Widget, PieChartEditor> {
	}

	@UiField
	HeadingElement pieTitle;

	@UiField
	TextInput nameInput;

	@UiField
	NumberInput intervalInput;

	@UiField
	HTMLPanel slicesContainer;

	private GraphConfiguration graphConfiguration;

	public PieChartEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		SliceEditor editor = new SliceEditor();
		this.slicesContainer.add(editor);
	}

	@UiHandler("addSliceButton")
	protected void onAddSliceClicked(ClickEvent event) {
		SliceEditor editor = new SliceEditor();
		this.slicesContainer.add(editor);
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@Override
	public void setValue(GraphConfiguration graphConfiguration) {
		this.clear();
		this.graphConfiguration = graphConfiguration;
		this.pieTitle.setInnerHTML("Graph : " + graphConfiguration.getName());
		this.nameInput.setValue(graphConfiguration.getName());

		this.slicesContainer.clear();
		for (SerieConfiguration serieConfiguration : graphConfiguration.getSerieConfigurations()) {
			this.intervalInput.setValue(serieConfiguration.getInterval().toString());
			SliceEditor editor = new SliceEditor();
			editor.setValue(serieConfiguration);
			this.slicesContainer.add(editor);
		}
	}

	@Override
	public GraphConfiguration getValue() {
		if (this.graphConfiguration == null) {
			this.graphConfiguration = new GraphConfiguration();
		}

		this.graphConfiguration.setName(this.nameInput.getValue());

		this.graphConfiguration.getSerieConfigurations().clear();
		for (int i = 0; i < this.slicesContainer.getWidgetCount(); i++) {
			Widget w = this.slicesContainer.getWidget(i);
			if (w instanceof SliceEditor) {
				SerieConfiguration serieConfiguration = ((SliceEditor) w).getValue();
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
		this.slicesContainer.clear();

		// Clear values/error
		this.nameInput.clear();
		this.intervalInput.clear();
	}

	@Override
	public boolean validate() {
		// Name validation
		boolean isNameValid = this.nameInput.validate();

		// Interval validation
		boolean isIntervalValid = this.intervalInput.validate();

		// Series validation
		boolean areSlicesValid = true;
		for (int i = 0; i < this.slicesContainer.getWidgetCount(); i++) {
			Widget w = this.slicesContainer.getWidget(i);
			if (w instanceof SliceEditor) {
				areSlicesValid = ((SliceEditor) w).validate() && areSlicesValid;
			}
		}

		return isNameValid && isIntervalValid && areSlicesValid;
	}

}
