package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;

public class ColumnConfigurationEditor extends Composite implements Editor<ColumnConfiguration> {

	private static ColumnConfigurationEditorUiBinder uiBinder = GWT.create(ColumnConfigurationEditorUiBinder.class);

	interface ColumnConfigurationEditorUiBinder extends UiBinder<Widget, ColumnConfigurationEditor> {
	}

	@UiField
	HeadingElement columnTitle;

	@UiField
	TextInput labelInput;

	@UiField
	TextInput targetInput;

	@UiField
	TextInput widthInput;

	@UiField
	BooleanInput sortableInput;

	private ColumnConfiguration columnConfiguration;

	public ColumnConfigurationEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@Override
	public boolean validate() {
		boolean isLabelValid = this.labelInput.validate();
		boolean isTargetValid = this.targetInput.validate();
		boolean isWidthValid = this.widthInput.validate();
		boolean isSortableValid = this.sortableInput.validate();

		return isLabelValid && isTargetValid && isWidthValid && isSortableValid;
	}

	@Override
	public ColumnConfiguration getValue() {
		if (this.columnConfiguration == null) {
			this.columnConfiguration = new ColumnConfiguration();
		}
		this.columnConfiguration.setLabel(this.labelInput.getValue());
		this.columnConfiguration.setTarget(this.targetInput.getValue());
		this.columnConfiguration.setWidth(this.widthInput.getValue());
		this.columnConfiguration.setSortable(this.sortableInput.getValue());

		return this.columnConfiguration;
	}

	@Override
	public void setValue(ColumnConfiguration columnConfiguration) {
		this.clear();
		this.columnConfiguration = columnConfiguration;

		this.columnTitle.setInnerHTML(columnConfiguration.getLabel());
		this.labelInput.setValue(columnConfiguration.getLabel());
		this.targetInput.setValue(columnConfiguration.getTarget());
		this.widthInput.setValue(columnConfiguration.getWidth());
		this.sortableInput.setValue(columnConfiguration.isSortable());
	}

	@Override
	public void clear() {
		this.columnConfiguration = new ColumnConfiguration();

		this.labelInput.clear();
		this.targetInput.clear();
		this.widthInput.clear();
		this.sortableInput.clear();
	}

}
