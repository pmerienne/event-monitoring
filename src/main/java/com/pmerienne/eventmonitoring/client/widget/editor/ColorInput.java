package com.pmerienne.eventmonitoring.client.widget.editor;

public class ColorInput extends TextInput {

	private final static String NOT_A_COLOR_ERROR = "Must be a hex-based color";

	@Override
	public boolean validate() {
		boolean isInError = false;
		boolean isEmpty = this.input.getValue().isEmpty();
		boolean validColor = this.input.getValue().startsWith("#") && this.input.getValue().length() == 7;

		if ((isEmpty && !this.isRequired()) || !isEmpty && validColor) {
			isInError = false;
			this.clearError();
		} else if (isEmpty && this.isRequired()) {
			isInError = true;
			this.setError(REQUIRED_ERROR);
		} else if (!isEmpty && !validColor) {
			isInError = true;
			this.setError(NOT_A_COLOR_ERROR);
		}

		return !isInError;
	}
}
