package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class SerieConfigurationEditor extends Composite implements Editor<SerieConfiguration> {

	private static SerieConfigurationEditorUiBinder uiBinder = GWT.create(SerieConfigurationEditorUiBinder.class);

	interface SerieConfigurationEditorUiBinder extends UiBinder<Widget, SerieConfigurationEditor> {
	}

	@UiField
	HeadingElement serieTitle;

	@UiField
	TextInput nameInput;

	@UiField
	SerieTypeInput serieTypeInput;

	@UiField
	ColorInput colorInput;

	@UiField
	ProjectionInput projectionInput;

	@UiField
	CriteriaInput criteriaInput;

	private SerieConfiguration serieConfiguration;

	public SerieConfigurationEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@Override
	public SerieConfiguration getValue() {
		if (this.serieConfiguration == null) {
			this.serieConfiguration = new SerieConfiguration();
		}

		this.serieConfiguration.setSerieName(this.nameInput.getValue());
		this.serieConfiguration.setType(this.serieTypeInput.getValue());
		this.serieConfiguration.setProjectionQuery(this.projectionInput.getValue());
		this.serieConfiguration.setColor(this.colorInput.getValue());
		this.serieConfiguration.setCriteriaQuery(this.criteriaInput.getValue());

		return this.serieConfiguration;
	}

	@Override
	public void setValue(SerieConfiguration serieConfiguration) {
		this.clear();
		this.serieConfiguration = serieConfiguration;

		this.serieTitle.setInnerHTML("Serie : " + serieConfiguration.getName());
		this.nameInput.setValue(serieConfiguration.getName());
		this.serieTypeInput.setValue(serieConfiguration.getType());
		this.projectionInput.setValue(serieConfiguration.getProjectionQuery());
		this.colorInput.setValue(serieConfiguration.getColor());
		this.criteriaInput.setValue(serieConfiguration.getCriteriaQuery());
	}

	@Override
	public void clear() {
		this.serieConfiguration = new SerieConfiguration();

		this.serieTitle.setInnerHTML("New serie");

		// Clear values
		this.nameInput.clear();
		this.serieTypeInput.setValue(Type.AREA);
		this.projectionInput.clear();
		this.colorInput.clear();
		this.criteriaInput.clear();
	}

	@Override
	public boolean validate() {
		// Name validation
		boolean isNameValid = this.nameInput.validate();

		// Projection validation
		boolean isProjectionValid = this.projectionInput.validate();

		// Criterion validation
		boolean isCriteriaValid = this.criteriaInput.validate();

		// Color validation
		boolean isColorValid = this.colorInput.validate();

		return isNameValid && isProjectionValid && isColorValid && isCriteriaValid;
	}
}
