package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import com.pmerienne.eventmonitoring.shared.parser.CriteriaValidator;

public class CriteriaInput extends TextAreaInput {

	private final static String INVALID_ERROR = "Invalid";

	private final static CriteriaValidator CRITERION_VALIDATOR = new CriteriaValidator();

	public CriteriaInput() {
		super();
		this.setLabel("Criteria");
	}

	@Override
	public boolean validate() {
		boolean isValid = this.input.getValue().isEmpty() || CRITERION_VALIDATOR.isCriteriaValid(this.input.getValue());

		if (isValid) {
			this.clearError();
		} else {
			this.setError(INVALID_ERROR);
		}

		return isValid;
	}
}
