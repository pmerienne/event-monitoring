package com.pmerienne.eventmonitoring.client.widget.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class DashboardEditor extends Composite implements Editor<Dashboard> {

	private static DashboardEditorUiBinder uiBinder = GWT.create(DashboardEditorUiBinder.class);

	interface DashboardEditorUiBinder extends UiBinder<Widget, DashboardEditor> {
	}

	@UiField
	TextInput nameInput;

	@UiField
	TextAreaInput descriptionInput;

	@UiField
	HTMLPanel configurationsContainer;

	private Dashboard dashboard;

	public DashboardEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("addGraphButton")
	protected void onAddGraphClicked(ClickEvent event) {
		GraphConfigurationEditor editor = new GraphConfigurationEditor();
		this.configurationsContainer.add(editor);
	}

	@UiHandler("addTableButton")
	protected void onAddTableClicked(ClickEvent event) {
		TableConfigurationEditor editor = new TableConfigurationEditor();
		this.configurationsContainer.add(editor);
	}

	@Override
	public void setValue(Dashboard dashboard) {
		this.clear();
		this.dashboard = dashboard;

		this.nameInput.setValue(dashboard.getName());
		this.descriptionInput.setValue(dashboard.getDescription());

		this.configurationsContainer.clear();
		for (GraphConfiguration graphConfiguration : dashboard.getGraphConfigurations()) {
			GraphConfigurationEditor editor = new GraphConfigurationEditor();
			editor.setValue(graphConfiguration);
			this.configurationsContainer.add(editor);
		}

		for (TableConfiguration tableConfiguration : dashboard.getTableConfigurations()) {
			TableConfigurationEditor editor = new TableConfigurationEditor();
			editor.setValue(tableConfiguration);
			this.configurationsContainer.add(editor);
		}
	}

	@Override
	public Dashboard getValue() {
		if (this.dashboard == null) {
			this.dashboard = new Dashboard();
		}
		this.dashboard.setName(this.nameInput.getValue());
		this.dashboard.setDescription(this.descriptionInput.getValue());

		this.dashboard.getGraphConfigurations().clear();
		this.dashboard.getTableConfigurations().clear();
		for (int i = 0; i < this.configurationsContainer.getWidgetCount(); i++) {
			Widget w = this.configurationsContainer.getWidget(i);
			if (w instanceof GraphConfigurationEditor) {
				GraphConfiguration graphConfiguration = ((GraphConfigurationEditor) w).getValue();
				this.dashboard.getGraphConfigurations().add(graphConfiguration);
			} else if (w instanceof TableConfigurationEditor) {
				TableConfiguration tableConfiguration = ((TableConfigurationEditor) w).getValue();
				this.dashboard.getTableConfigurations().add(tableConfiguration);
			}
		}

		return this.dashboard;
	}

	@Override
	public void clear() {
		this.dashboard = new Dashboard();

		// Clear graph configurations
		this.configurationsContainer.clear();

		// Clear inputs
		this.nameInput.clear();
		this.descriptionInput.clear();
	}

	@Override
	public boolean validate() {
		// Name validation
		boolean isNameValid = this.nameInput.validate();

		// Description validation
		boolean isDescriptionValid = this.descriptionInput.validate();

		// Series validation
		boolean areConfigurationsValid = true;
		for (int i = 0; i < this.configurationsContainer.getWidgetCount(); i++) {
			Widget w = this.configurationsContainer.getWidget(i);
			if (w instanceof Editor<?>) {
				areConfigurationsValid = ((Editor<?>) w).validate() && areConfigurationsValid;
			}
		}

		return isNameValid && isDescriptionValid && areConfigurationsValid;
	}

}
