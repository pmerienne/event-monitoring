package com.pmerienne.eventmonitoring.client.widget.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TextInput extends Composite implements HasValue<String> {

	private static TextInputUiBinder uiBinder = GWT.create(TextInputUiBinder.class);

	interface TextInputUiBinder extends UiBinder<Widget, TextInput> {
	}

	private final static String ERROR_CLASS = "error";
	private final static String SUCCESS_CLASS = "success";

	protected final static String REQUIRED_ERROR = "Required";

	@UiField
	LabelElement label;

	@UiField
	TextBox input;

	@UiField
	SpanElement error;

	@UiField
	HTMLPanel controls;

	private boolean required = false;

	private String labelValue;

	public TextInput() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public boolean validate() {
		boolean isInError = this.required && this.input.getValue().isEmpty();
		if (isInError) {
			this.setError(REQUIRED_ERROR);
		} else {
			clearError();
		}
		return !isInError;
	}

	protected void clearError() {
		this.removeStyleName(ERROR_CLASS);
		this.addStyleName(SUCCESS_CLASS);
		this.error.setInnerHTML("");
	}

	protected void setError(String error) {
		this.removeStyleName(SUCCESS_CLASS);
		this.addStyleName(ERROR_CLASS);
		this.error.setInnerHTML(error);
	}

	public void clear() {
		this.removeStyleName(ERROR_CLASS);
		this.removeStyleName(SUCCESS_CLASS);
		this.setValue("");
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return this.input.addValueChangeHandler(handler);
	}

	@Override
	public String getValue() {
		return this.input.getValue();
	}

	@Override
	public void setValue(String value) {
		this.input.setValue(value);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
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
