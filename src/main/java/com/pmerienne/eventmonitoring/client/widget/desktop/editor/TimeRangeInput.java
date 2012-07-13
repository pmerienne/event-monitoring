package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

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

public class TimeRangeInput extends Composite implements HasValue<Long> {

	private static TimeRangeInputUiBinder uiBinder = GWT.create(TimeRangeInputUiBinder.class);

	interface TimeRangeInputUiBinder extends UiBinder<Widget, TimeRangeInput> {
	}

	@UiField
	TimeRangeListBox listBox;

	private String labelValue;

	@UiField
	LabelElement label;

	public TimeRangeInput() {
		initWidget(uiBinder.createAndBindUi(this));
		this.setLabel("From");
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Long> handler) {
		return this.listBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				Long value = TimeRangeInput.this.getValue();
				// TODO : not working!
				ValueChangeEvent.fire(TimeRangeInput.this, value);
			}
		});
	}

	@Override
	public Long getValue() {
		return this.listBox.getSelectedDuration();
	}

	@Override
	public void setValue(Long value) {
		this.listBox.setSelectedDuration(value);
	}

	@Override
	public void setValue(Long value, boolean fireEvents) {
		// TODO : implement fire events
		this.listBox.setSelectedDuration(value);
	}

	public void clear() {
		this.listBox.setSelectedIndex(0);
	}

	public void setLabel(String label) {
		this.labelValue = label;
		this.label.setInnerHTML(label);
	}

	public String getLabel() {
		return this.labelValue;
	}
}
