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
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class TableConfigurationEditor extends Composite implements Editor<TableConfiguration> {

	private static TableConfigurationEditorUiBinder uiBinder = GWT.create(TableConfigurationEditorUiBinder.class);

	interface TableConfigurationEditorUiBinder extends UiBinder<Widget, TableConfigurationEditor> {
	}

	@UiField
	HeadingElement tableTitle;

	@UiField
	TextInput nameInput;

	@UiField
	NumberInput nbResultsInput;

	@UiField
	TimeRangeInput timeRangeInput;
	
	@UiField
	CriteriaInput criteriaInput;

	@UiField
	HTMLPanel columnsContainer;

	private TableConfiguration tableConfiguration;

	public TableConfigurationEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@UiHandler("addColumnButton")
	protected void onAddColumn(ClickEvent event) {
		ColumnConfigurationEditor editor = new ColumnConfigurationEditor();
		this.columnsContainer.add(editor);
	}

	@Override
	public boolean validate() {
		boolean isNameValid = this.nameInput.validate();
		boolean isNbResultsValid = this.nbResultsInput.validate();

		// Criterion validation
		boolean isCriteriaValid = this.criteriaInput.validate();

		// Columns configuration
		boolean areColumnsValid = true;
		for (int i = 0; i < this.columnsContainer.getWidgetCount(); i++) {
			Widget w = this.columnsContainer.getWidget(i);
			if (w instanceof Editor<?>) {
				areColumnsValid = ((Editor<?>) w).validate() && areColumnsValid;
			}
		}

		return isNameValid && isNbResultsValid && isCriteriaValid && areColumnsValid;
	}

	@Override
	public TableConfiguration getValue() {
		if (this.tableConfiguration == null) {
			this.tableConfiguration = new TableConfiguration();
		}

		this.tableConfiguration.setName(this.nameInput.getValue());
		this.tableConfiguration.setNbResults(this.nbResultsInput.getValueAsInteger());
		this.tableConfiguration.setCriteria(this.criteriaInput.getValue());
		this.tableConfiguration.setTimeRange(this.timeRangeInput.getValue());

		this.tableConfiguration.getColumnConfigurations().clear();
		for (int i = 0; i < this.columnsContainer.getWidgetCount(); i++) {
			Widget w = this.columnsContainer.getWidget(i);
			if (w instanceof ColumnConfigurationEditor) {
				ColumnConfiguration columnConfiguration = ((ColumnConfigurationEditor) w).getValue();
				this.tableConfiguration.getColumnConfigurations().add(columnConfiguration);
			}
		}

		return this.tableConfiguration;
	}

	@Override
	public void setValue(TableConfiguration tableConfiguration) {
		this.clear();
		this.tableConfiguration = tableConfiguration;

		this.tableTitle.setInnerHTML("Table : " + tableConfiguration.getName());
		this.nameInput.setValue(tableConfiguration.getName());
		this.nbResultsInput.setValue(tableConfiguration.getNbResults().toString());
		this.criteriaInput.setValue(tableConfiguration.getCriteria());
		this.timeRangeInput.setValue(tableConfiguration.getTimeRange());

		for (ColumnConfiguration columnConfiguration : tableConfiguration.getColumnConfigurations()) {
			ColumnConfigurationEditor editor = new ColumnConfigurationEditor();
			editor.setValue(columnConfiguration);
			this.columnsContainer.add(editor);
		}
	}

	@Override
	public void clear() {
		this.tableConfiguration = new TableConfiguration();

		this.tableTitle.setInnerHTML("New table");
		this.nameInput.clear();
		this.nbResultsInput.clear();
		this.criteriaInput.clear();
		this.timeRangeInput.clear();
	}
}
