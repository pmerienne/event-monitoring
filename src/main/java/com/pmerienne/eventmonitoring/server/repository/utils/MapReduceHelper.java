package com.pmerienne.eventmonitoring.server.repository.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

/**
 * This class provides methods helping you to create map/reduce commands (as
 * String). Example :
 * 
 * @author pmerienne
 * 
 */
@Component
public class MapReduceHelper {

	@Autowired
	private JSImplementationBuilder jsImplementationBuilder;

	public String getMapFunctionForDateAggration(SerieConfiguration configuration) {
		// Get request params
		Long interval = configuration.getInterval();
		String jsMapValues = this.jsImplementationBuilder.createJSMapValues(configuration.getProjectionQuery());

		// Build function
		StringBuilder sb = new StringBuilder();
		sb.append("function () { ");
		sb.append("		var intervalStart = this.date.getTime() - this.date.getTime() % (").append(interval).append("); ");
		sb.append("		var value = new Object; ");
		sb.append("		value.finalValue = 0; ");
		sb.append(jsMapValues);
		sb.append("		emit(intervalStart, value); ");
		sb.append("} ");

		return sb.toString();
	}
	

	public String getMapFunctionForMath(SerieConfiguration configuration) {
		// Get request params
		String jsMapValues = this.jsImplementationBuilder.createJSMapValues(configuration.getProjectionQuery());

		// Build function
		StringBuilder sb = new StringBuilder();
		sb.append("function () { ");
		sb.append("		var value = new Object; ");
		sb.append("		value.finalValue = 0; ");
		sb.append(jsMapValues);
		sb.append("		emit(1, value); ");
		sb.append("} ");

		return sb.toString();
	}

	public String getReduceFunction(SerieConfiguration configuration) {
		String jsReduceResult = this.jsImplementationBuilder.createJSReduceResults(configuration.getProjectionQuery());

		StringBuilder sb = new StringBuilder();
		sb.append("function (key, values) { ");
		sb.append("		var result = new Object; ");
		sb.append("		result.finalValue = 0; ");
		sb.append(jsReduceResult);
		sb.append("		return result; ");
		sb.append("} ");

		return sb.toString();
	}

	public String getFinalizeFunction(SerieConfiguration configuration) {
		String jsFinalizeValue = this.jsImplementationBuilder.createJSFinalizeValues(configuration.getProjectionQuery());

		StringBuilder sb = new StringBuilder();
		sb.append("function (key, value) { ");
		sb.append(jsFinalizeValue);
		sb.append("		return value; ");
		sb.append("} ");
		return sb.toString();
	}

	public static class ValueObject {

		private Long id;

		private Double value;

		public Long getTimestamp() {
			return id;
		}

		public void setTimestamp(Long timestamp) {
			this.id = timestamp;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "ValueObject [id=" + id + ", value=" + value + "]";
		}

	}
}
