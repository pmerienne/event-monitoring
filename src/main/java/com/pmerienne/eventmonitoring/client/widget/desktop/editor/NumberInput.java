package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

public class NumberInput extends TextInput {

	private final static String NOT_A_NUMBER_ERROR = "Must be a number";

	@Override
	public boolean validate() {
		// Check emptyness
		boolean isInputRequiredAndEmpty = !super.validate();
		boolean isInError = isInputRequiredAndEmpty;

		// If emptyness is not a problem, we check that the input is a number
		if (!isInputRequiredAndEmpty) {
			boolean isANumber = false;
			try {
				Integer.parseInt(this.input.getValue());
				isANumber = true;
			} catch (NumberFormatException nfe) {
				isANumber = false;
			}

			// Add error text
			if (!isANumber) {
				this.setError(NOT_A_NUMBER_ERROR);
			}
			isInError = !isANumber;
		}

		if (!isInError) {
			this.clearError();
		}

		return !isInError;
	}

	public Integer getValueAsInteger() {
		Integer value = null;
		try {
			value = Integer.parseInt(this.input.getValue());
		} catch (NumberFormatException nfe) {
			// Do nothing
		}
		return value;
	}
}
