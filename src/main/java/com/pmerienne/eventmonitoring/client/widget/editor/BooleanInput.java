package com.pmerienne.eventmonitoring.client.widget.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class BooleanInput extends Composite implements HasValue<Boolean> {

	private static BooleanInputUiBinder uiBinder = GWT.create(BooleanInputUiBinder.class);

	interface BooleanInputUiBinder extends UiBinder<Widget, BooleanInput> {
	}

	private final static String ERROR_CLASS = "error";
	private final static String SUCCESS_CLASS = "success";

	protected final static String REQUIRED_ERROR = "Required";

	@UiField
	LabelElement label;

	@UiField
	CheckBox input;

	@UiField
	SpanElement error;

	public BooleanInput() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private String labelValue;

	public boolean validate() {
		clearError();
		return true;
	}

	protected void clearError() {
		this.removeStyleName(ERROR_CLASS);
		this.addStyleName(SUCCESS_CLASS);
		this.error.setInnerHTML("");
	}

	public void clear() {
		this.removeStyleName(ERROR_CLASS);
		this.removeStyleName(SUCCESS_CLASS);
		this.setValue(false);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
		return this.input.addValueChangeHandler(handler);
	}

	@Override
	public Boolean getValue() {
		return this.input.getValue();
	}

	@Override
	public void setValue(Boolean value) {
		this.input.setValue(value);
	}

	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		this.input.setValue(value, fireEvents);
	}

	public void setLabel(String label) {
		this.labelValue = label;
		this.label.setInnerHTML(label);
	}

	public String getLabel() {
		return this.labelValue;
	}
}
