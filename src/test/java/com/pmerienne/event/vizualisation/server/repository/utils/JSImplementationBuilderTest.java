package com.pmerienne.event.vizualisation.server.repository.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pmerienne.eventmonitoring.server.repository.utils.JSImplementationBuilder;

public class JSImplementationBuilderTest {

	private JSImplementationBuilder jsImplementationBuilder = new JSImplementationBuilder();

	@Test
	public void testCreateJSMapValuesWithSimpleCount() {
		// Create tested data
		String projectionQuery = "count(data.duration > 300 || type == REQUEST)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSMapValues(projectionQuery);

		// Assert result
		String expectedResult = "if(((this.data.duration > 300) || (this.type == \"REQUEST\"))) {value.count0 = 1;} else {value.count0 = 0;}";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSMapValuesWithSimpleSum() {
		// Create tested data
		String projectionQuery = "sum(data.duration)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSMapValues(projectionQuery);

		// Assert result
		String expectedResult = "value.sum0 = this.data.duration;";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSMapValuesWithComplexSum() {
		// Create tested data
		String projectionQuery = "sum(data.end - data.start)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSMapValues(projectionQuery);

		// Assert result
		String expectedResult = "value.sum0 = (this.data.end-this.data.start);";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	/**
	 * Test the projection :
	 * 
	 * <pre>
	 * sum(data.duration) / count(data.duration)
	 * </pre>
	 * 
	 * To build the map function :
	 * 
	 * <pre>
	 * 		function () { 
	 * 			var intervalStart = this.date.getTime() - this.date.getTime() % interval;
	 * 			var value = new Object;
	 * 			value.finalValue = 0;
	 * 			if(this.data.duration != null) {
	 * 				value.sum0 = (this.data.duration);
	 * 			} else {
	 * 				value.sum0 = 0;
	 * 			}
	 * 			if(this.data.duration != null) {
	 * 				value.count1 = 1;
	 * 			} else {
	 * 				value.count1 = 0;
	 * 			}
	 * 			emit(intervalStart, values);
	 * 		}
	 * </pre>
	 */
	@Test
	public void testCreateJSMapValuesWithCombinedFunctions() {
		// Create tested data
		String projectionQuery = "sum(data.start - data.end) / count(data.end != null && data.start != null)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSMapValues(projectionQuery);

		// Assert result
		String expectedResult = "value.sum0=(this.data.start - this.data.end); if(((this.data.end != null) && (this.data.start != null))) {value.count1 = 1;} else {value.count1 = 0;}";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSReduceResultWithSimpleCount() {
		// Create tested data
		String projectionQuery = "count(data.duration != null)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSReduceResults(projectionQuery);

		// Assert result
		String expectedResult = "result.count0 = 0;values.forEach(function(value) {result.count0 += value.count0;});";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSReduceResultWithSimpleSum() {
		// Create tested data
		String projectionQuery = "sum(data.duration)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSReduceResults(projectionQuery);

		// Assert result
		String expectedResult = "result.sum0 = 0;values.forEach(function(value) {result.sum0 += value.sum0;});";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSReduceResultWithCombinedFunctions() {
		// Create tested data
		String projectionQuery = "sum(data.duration) / count(data.duration)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSReduceResults(projectionQuery);

		// Assert result
		String expectedResult = "result.sum0 = 0;values.forEach(function(value) {result.sum0 += value.sum0;});result.count1 = 0;values.forEach(function(value) {result.count1 += value.count1;});";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSFinalizeValueWithSimpleCount() {
		// Create tested data
		String projectionQuery = "count(data.duration != null)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSFinalizeValues(projectionQuery);

		// Assert result
		String expectedResult = "value = value.count0;";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSFinalizeValueWithSimpleSum() {
		// Create tested data
		String projectionQuery = "sum(data.duration)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSFinalizeValues(projectionQuery);

		// Assert result
		String expectedResult = "value = value.sum0;";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSFinalizeValueWithCombinedFunctions() {
		// Create tested data
		String projectionQuery = "sum(data.duration) / count(data.duration != null)";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSFinalizeValues(projectionQuery);

		// Assert result
		String expectedResult = "value = (value.sum0 / value.count1);";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	@Test
	public void testCreateJSFinalizeValueWithComplexCombinedFunctions() {
		// Create tested data
		String projectionQuery = "sum(data.duration) / (count(data.duration != null) * count(data.complex == true))";

		// Test
		String actualJS = this.jsImplementationBuilder.createJSFinalizeValues(projectionQuery);

		// Assert result
		String expectedResult = "value = (value.sum0 / (value.count1 * value.count2));";
		assertEquals(magicString(expectedResult), magicString(actualJS));
	}

	private String magicString(String string) {
		string = string.replaceAll(" ", "");
		string = string.replaceAll("\n", "");
		string = string.replaceAll("\t", "");
		return string;
	}
}
