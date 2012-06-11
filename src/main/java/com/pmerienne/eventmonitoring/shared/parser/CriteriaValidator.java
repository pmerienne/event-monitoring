package com.pmerienne.eventmonitoring.shared.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

public class CriteriaValidator {

	public boolean isCriteriaValid(String criteria) {
		boolean isValid = true;
		try {
			// lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(criteria);
			TokenStream tokens = new CommonTokenStream(new CriteriaLexer(input));

			// parser generates abstract syntax tree
			CriteriaParser parser = new CriteriaParser(tokens);
			CriteriaParser.expression_return ret = parser.expression();

			// acquire parse result
			CommonTree ast = (CommonTree) ret.tree;
			isValid = ast != null;
		} catch (Exception e) {
			isValid = false;
		}

		return isValid;
	}
}
