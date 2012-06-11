package com.pmerienne.event.vizualisation.shared.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pmerienne.eventmonitoring.shared.parser.CriteriaValidator;

public class CriteriaValidatorTest {

	private CriteriaValidator criteriaValidator = new CriteriaValidator();

	@Test
	public void testIsCriteriaValidWithValiQuery() {
		String criteriaQuery = "((type == REQUEST && data.duration > 300) OR (type == RESPONSE && (data.status < 200 || data.status >= 300))) AND data.component == http://mediadb.4rnd.com";
		boolean actualValidation = this.criteriaValidator.isCriteriaValid(criteriaQuery);
		assertTrue(actualValidation);

		criteriaQuery = "type == null";
		actualValidation = this.criteriaValidator.isCriteriaValid(criteriaQuery);
		assertTrue(actualValidation);

		criteriaQuery = "data.duration > (data.complex + (30 * data.other))";
		actualValidation = this.criteriaValidator.isCriteriaValid(criteriaQuery);
		assertTrue(actualValidation);
	}

	@Test
	public void testIsCriteriaValidWithInvalidQuery() {
		String criteriaQuery = "data.component OR http://mediadb.4rnd.com";
		boolean actualValidation = this.criteriaValidator.isCriteriaValid(criteriaQuery);
		assertFalse(actualValidation);
	}
}
