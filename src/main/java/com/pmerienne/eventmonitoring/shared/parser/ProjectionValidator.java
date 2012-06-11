package com.pmerienne.eventmonitoring.shared.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.springframework.stereotype.Component;

@Component
public class ProjectionValidator {

	public boolean isProjectionValid(String projectionQuery) {
		boolean isValid = true;
		try {
			// lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(projectionQuery);
			TokenStream tokens = new CommonTokenStream(new ProjectionLexer(input));

			// parser generates abstract syntax tree
			ProjectionParser parser = new ProjectionParser(tokens);
			ProjectionParser.expression_return ret = parser.expression();

			// acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			isValid = ast != null;
		} catch (Exception e) {
			isValid = false;
		}

		return isValid;
	}
}
