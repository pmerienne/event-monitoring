package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class SerieTypeInput extends Composite implements HasValue<Type> {

	private static SerieTypeChooserUiBinder uiBinder = GWT.create(SerieTypeChooserUiBinder.class);

	interface SerieTypeChooserUiBinder extends UiBinder<Widget, SerieTypeInput> {
	}

	public SerieTypeInput() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	SerieTypeListBox listBox;

	private String labelValue;

	@UiField
	LabelElement label;

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Type> handler) {
		return this.listBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				Type value = SerieTypeInput.this.getValue();
				// TODO : not working!
				ValueChangeEvent.fire(SerieTypeInput.this, value);
			}
		});
	}

	@Override
	public Type getValue() {
		return this.listBox.getSelectedType();
	}

	@Override
	public void setValue(Type value) {
		this.listBox.setSelectedType(value);
	}

	@Override
	public void setValue(Type value, boolean fireEvents) {
		// TODO : implement fire events
		this.listBox.setSelectedType(value);
	}

	public void setLabel(String label) {
		this.labelValue = label;
		this.label.setInnerHTML(label);
	}

	public String getLabel() {
		return this.labelValue;
	}

}
