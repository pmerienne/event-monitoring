package com.pmerienne.eventmonitoring.client.widget.editor;

import com.pmerienne.eventmonitoring.shared.parser.ProjectionValidator;

public class ProjectionInput extends TextInput {

	private final static String INVALID_ERROR = "Invalid";

	private final static ProjectionValidator PROJECTION_VALIDATOR = new ProjectionValidator();

	@Override
	public boolean validate() {
		// Check emptyness
		boolean isInputRequiredAndEmpty = !super.validate();
		boolean isInError = isInputRequiredAndEmpty;

		// If emptyness is not a problem, we check that the input is a valid
		// projection
		if (!isInputRequiredAndEmpty) {
			boolean isProjectionValid = PROJECTION_VALIDATOR.isProjectionValid(this.input.getValue());

			// Add error text
			if (!isProjectionValid) {
				this.setError(INVALID_ERROR);
			}
			isInError = !isProjectionValid;
		}

		if (!isInError) {
			this.clearError();
		}

		return !isInError;
	}
}
