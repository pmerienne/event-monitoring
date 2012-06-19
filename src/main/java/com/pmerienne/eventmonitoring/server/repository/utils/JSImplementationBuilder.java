package com.pmerienne.eventmonitoring.server.repository.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pmerienne.eventmonitoring.shared.parser.CriteriaParser;
import com.pmerienne.eventmonitoring.shared.parser.ProjectionLexer;
import com.pmerienne.eventmonitoring.shared.parser.ProjectionParser;

@Component
public class JSImplementationBuilder {

	private final static Logger LOGGER = Logger.getLogger(JSImplementationBuilder.class);

	private final static String COUNT = "count";
	private final static String SUM = "sum";

	/**
	 * Create a JS simplificated implementation of the map phase of a map/reduce
	 * operation.
	 * 
	 * Assumes that the map function is prefilled like :
	 * 
	 * <pre>
	 * 	function () { 
	 * 		var intervalStart = this.date.getTime() - this.date.getTime() % interval ");
	 * 		var value = new Object;
	 * 		value.finalValue = 0;
	 * 		// Implementation goes here
	 * 		emit(intervalStart, value);
	 * }
	 * </pre>
	 * 
	 * @param projectionQuery
	 * @return
	 */
	public String createJSMapValues(String projectionQuery) {
		String jsMapValues = "";

		// Get projection query as a AST tree
		CommonTree tree = this.getTree(projectionQuery);

		// Visit tree to retrieve all count and sum function
		Map<String, String> functions = this.getFunctionsWithJSMapValuesImplementation(tree, new HashMap<String, String>());

		for (String functionName : functions.keySet()) {
			jsMapValues += this.createJSMapValue(functionName, functions.get(functionName));
		}

		return jsMapValues;
	}

	/**
	 * Create a JS simplificated implementation of the reduce phase of a
	 * map/reduce operation.
	 * 
	 * Assumes that the reduce function is prefilled like :
	 * 
	 * <pre>
	 * 	function (key, values) { 
	 * 		var result = new Object;
	 * 		result.finalValue = 0;
	 * 		// Implementation goes here
	 * 		return result;
	 *  }
	 * </pre>
	 * 
	 * @param projectionQuery
	 * @return
	 */
	public String createJSReduceResults(String projectionQuery) {
		String jsReduceResult = "";

		// Get projection query as a AST tree
		CommonTree tree = this.getTree(projectionQuery);

		// Visit tree to retrieve all count and sum function
		List<String> functionsNames = this.getFunctions(tree, new ArrayList<String>());

		for (String functionName : functionsNames) {
			jsReduceResult += this.createJSReduceResult(functionName);
		}

		return jsReduceResult;
	}

	/**
	 * Create a JS simplificated implementation of the finalize phase of a
	 * map/reduce operation.
	 * 
	 * Assumes that the reduce function is prefilled like :
	 * 
	 * <pre>
	 * 		function (key, value) { 
	 * 			// Implementation goes here
	 * 			return value;
	 *  }
	 * </pre>
	 * 
	 * @param projectionQuery
	 * @return
	 */
	public String createJSFinalizeValues(String projectionQuery) {
		String jsFinalizeValue = "";

		// Get projection query as a AST tree
		CommonTree tree = this.getTree(projectionQuery);

		// Visit tree to retrieve all count and sum function
		String impl = this.getJSFinalizeValuesImplementation(tree, new AtomicInteger(0));
		jsFinalizeValue = "value = " + impl + ";";

		return jsFinalizeValue;
	}

	private CommonTree getTree(String projectionQuery) {
		try {
			// lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(projectionQuery);
			TokenStream tokens = new CommonTokenStream(new ProjectionLexer(input));

			// parser generates abstract syntax tree
			ProjectionParser parser = new ProjectionParser(tokens);
			ProjectionParser.expression_return ret;
			ret = parser.expression();

			// acquire parse result
			CommonTree ast = (CommonTree) ret.getTree();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Projection tree : ");
				LOGGER.debug(print(ast, 0));
			}

			return ast;
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to build tree for projection : " + projectionQuery, e);
		}
	}

	private List<String> getFunctions(CommonTree tree, List<String> functionNames) {
		if (tree.getType() == ProjectionParser.COUNT_FUNCTION) {
			functionNames.add(COUNT + functionNames.size());

		} else if (tree.getType() == ProjectionParser.SUM_FUNCTION) {
			functionNames.add(SUM + functionNames.size());

		} else if (tree.getType() == ProjectionParser.ARITHMETIC_OPERATOR && tree.getChildren() != null) {
			for (Object obj : tree.getChildren()) {
				this.getFunctions((CommonTree) obj, functionNames);
			}
		}
		return functionNames;
	}

	private Map<String, String> getFunctionsWithJSMapValuesImplementation(CommonTree tree, Map<String, String> functions) {
		if (tree.getType() == ProjectionParser.COUNT_FUNCTION) {
			String countFunction = this.visitCountFunctionForJSMapValuesImplementation(tree);
			functions.put(COUNT + functions.size(), countFunction);

		} else if (tree.getType() == ProjectionParser.SUM_FUNCTION) {
			String sumFunction = this.visitSumFunctionForJSMapValuesImplementation(tree);
			functions.put(SUM + functions.size(), sumFunction);

		} else if (tree.getType() == ProjectionParser.ARITHMETIC_OPERATOR && tree.getChildren() != null) {
			for (Object obj : tree.getChildren()) {
				this.getFunctionsWithJSMapValuesImplementation((CommonTree) obj, functions);
			}
		}
		return functions;
	}

	private String getJSFinalizeValuesImplementation(CommonTree tree, AtomicInteger functionCount) {
		String impl = null;
		if (tree.getType() == ProjectionParser.COUNT_FUNCTION) {
			impl = "value." + COUNT + functionCount.getAndIncrement();

		} else if (tree.getType() == ProjectionParser.SUM_FUNCTION) {
			impl = "value." + SUM + functionCount.getAndIncrement();

		} else if (tree.getType() == ProjectionParser.NUMBER) {
			impl = tree.getText();

		} else if (tree.getType() == ProjectionParser.ARITHMETIC_OPERATOR && tree.getChildren() != null) {
			String part1 = this.getJSFinalizeValuesImplementation((CommonTree) tree.getChild(0), functionCount);
			String part2 = this.getJSFinalizeValuesImplementation((CommonTree) tree.getChild(1), functionCount);
			impl = "(" + part1 + tree.getText() + part2 + ")";
		}
		return impl;
	}

	private String createJSMapValue(String functionName, String function) {
		String jsMapValue = null;

		if (functionName.startsWith(COUNT)) {
			jsMapValue = "if(" + function + "){value." + functionName + " = 1;} else {value." + functionName + " = 0;}";
		} else if (functionName.startsWith(SUM)) {
			jsMapValue = "value." + functionName + " = " + function + ";";
		}
		return jsMapValue;
	}

	private String createJSReduceResult(String functionName) {
		String js = "result." + functionName + " = 0;values.forEach(function(value) {result." + functionName + " += value." + functionName + ";});";
		return js;
	}

	private String visitCountFunctionForJSMapValuesImplementation(CommonTree tree) {
		String countFunction = "";
		if (tree.getType() == ProjectionParser.COUNT_FUNCTION && tree.getChildren() != null) {
			for (Object obj : tree.getChildren()) {
				countFunction = this.visitCountFunctionForJSMapValuesImplementation((CommonTree) obj);
			}
		} else if (this.isLogicalOperator(tree.getType()) || this.isRelationalOperator(tree.getType())
				|| tree.getType() == ProjectionParser.ARITHMETIC_OPERATOR) {
			if (tree.getChildren() != null && tree.getChildCount() == 2) {
				String part1 = this.visitCountFunctionForJSMapValuesImplementation((CommonTree) tree.getChild(0));
				String part2 = this.visitCountFunctionForJSMapValuesImplementation((CommonTree) tree.getChild(1));
				countFunction = "(" + part1 + tree.getText() + part2 + ")";
			}
		} else if (tree.getType() == ProjectionParser.STRING) {
			countFunction = "\"" + tree.getText() + "\"";
		} else if (tree.getType() == ProjectionParser.FIELD) {
			countFunction = "this." + tree.getText();
		} else if (tree.getType() == ProjectionParser.NUMBER) {
			countFunction = tree.getText();
		} else if (tree.getType() == ProjectionParser.NULL) {
			countFunction = "null";
		}
		return countFunction;
	}

	private String visitSumFunctionForJSMapValuesImplementation(CommonTree tree) {
		String sumFunction = "";
		if (tree.getType() == ProjectionParser.SUM_FUNCTION && tree.getChildren() != null) {
			for (Object obj : tree.getChildren()) {
				sumFunction = this.visitSumFunctionForJSMapValuesImplementation((CommonTree) obj);
			}
		} else if (tree.getType() == ProjectionParser.ARITHMETIC_OPERATOR) {
			if (tree.getChildren() != null && tree.getChildCount() == 2) {
				String part1 = this.visitCountFunctionForJSMapValuesImplementation((CommonTree) tree.getChild(0));
				String part2 = this.visitCountFunctionForJSMapValuesImplementation((CommonTree) tree.getChild(1));
				sumFunction = "(" + part1 + tree.getText() + part2 + ")";
			}
		} else if (tree.getType() == ProjectionParser.STRING) {
			sumFunction = "\"" + tree.getText() + "\"";
		} else if (tree.getType() == ProjectionParser.FIELD) {
			sumFunction = "this." + tree.getText();
		} else if (tree.getType() == ProjectionParser.NUMBER) {
			sumFunction = tree.getText();
		}
		return sumFunction;
	}

	private boolean isRelationalOperator(int type) {
		return type == CriteriaParser.IS || type == CriteriaParser.NE || type == CriteriaParser.GT || type == CriteriaParser.GTE || type == CriteriaParser.LT
				|| type == CriteriaParser.LTE;
	}

	private boolean isLogicalOperator(int type) {
		return type == CriteriaParser.AND || type == CriteriaParser.OR;
	}

	private StringBuilder print(CommonTree tree, int level) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");

		for (int i = 0; i < level; i++) {
			sb.append("  ");
		}
		sb.append(" " + tree.getText() + " (" + tree.getType() + ")");

		if (tree.getChildren() != null && tree.getChildCount() > 0) {
			for (Object obj : tree.getChildren()) {
				sb.append(print((CommonTree) obj, level + 1));
			}
		}
		return sb;
	}

}
