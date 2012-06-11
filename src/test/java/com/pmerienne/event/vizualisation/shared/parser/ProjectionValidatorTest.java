package com.pmerienne.event.vizualisation.shared.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pmerienne.eventmonitoring.shared.parser.ProjectionValidator;

public class ProjectionValidatorTest {

	private ProjectionValidator projectionValidator = new ProjectionValidator();

	@Test
	public void isValidProjections() {
		String projection = "count(type == REQUEST)";
		boolean actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "sum(data.duration)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "sum(data.start - data.end)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(type == REQUEST || type == RESPONSE)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(data.complex != null)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(type == REQUEST || type == RESPONSE && data.duration > 12)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(type == REQUEST || type == RESPONSE && data.duration > data.start - data.end)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "sum(data.duration) / count(data.duration > 0)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(date != null) / 60";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);

		projection = "count(data.duration == null) / (sum(data.duration) * count(data.complex == true))";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);
	}

	@Test
	public void isProjectionValidWithInvalidProjections() {
		String projection = "counte(type == REQUEST)";
		boolean actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "count(type = REQUEST)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "count(type == REQUEST))";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sume(data.start - data.end)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum(type == REQUEST)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum(type != NULL)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum(data.start - data.end == 300)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum(count(data == 1))";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum data.duration";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "sum()";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertFalse(actualResult);

		projection = "count(type)";
		actualResult = this.projectionValidator.isProjectionValid(projection);
		assertTrue(actualResult);
	}
}
