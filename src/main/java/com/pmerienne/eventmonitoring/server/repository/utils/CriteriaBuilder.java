package com.pmerienne.eventmonitoring.server.repository.utils;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.pmerienne.eventmonitoring.shared.parser.CriteriaLexer;
import com.pmerienne.eventmonitoring.shared.parser.CriteriaParser;

@Component
public class CriteriaBuilder {

	private final static Logger LOGGER = Logger.getLogger(CriteriaBuilder.class);

	public Criteria buildCriteria(String criteriaQuery) {
		// Return empty criteria if no one is needed
		if (criteriaQuery == null || criteriaQuery.isEmpty()) {
			return new Criteria();
		}

		try {
			// lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(criteriaQuery);
			TokenStream tokens = new CommonTokenStream(new CriteriaLexer(input));

			// parser generates abstract syntax tree
			CriteriaParser parser = new CriteriaParser(tokens);
			CriteriaParser.expression_return ret;
			ret = parser.expression();

			// acquire parse result
			CommonTree ast = (CommonTree) ret.getTree();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Criteria tree : ");
				LOGGER.debug(print(ast, 0));
			}

			// Visit tree to create criteria
			Criteria criteria = this.visitTree(ast);
			if (criteria == null) {
				criteria = new Criteria();
			}

			return criteria;
		} catch (Exception e) {
			LOGGER.warn("Unable to build criteria for : " + criteriaQuery + ". Cause : " + e.getMessage());
			return new Criteria();
		}
	}

	private Criteria visitTree(CommonTree tree) {
		Criteria criteria = null;

		if (this.isRelationalOperator(tree.getType())) {
			// Create a relational criteria
			criteria = this.createRelationalCriteria(tree);
		} else if (this.isLogicalOperator(tree.getType())) {
			// Create a logical criteria
			criteria = this.createLogicalCriteria(tree);
		}
		return criteria;
	}

	private Criteria createLogicalCriteria(CommonTree tree) {
		// Create criteria
		Criteria criteria = new Criteria();

		// Get childs criteria
		if (tree.getChildren() != null) {
			Criteria[] childCriterias = new Criteria[tree.getChildCount()];
			int i = 0;
			for (Object obj : tree.getChildren()) {
				CommonTree child = (CommonTree) obj;
				Criteria childCriteria = this.visitTree(child);
				childCriterias[i] = childCriteria;
				i++;
			}

			// Assemble criterias
			if (tree.getType() == CriteriaParser.AND) {
				criteria = criteria.andOperator(childCriterias);
			} else if (tree.getType() == CriteriaParser.OR) {
				criteria = criteria.orOperator(childCriterias);
			}
		}
		return criteria;
	}

	private Criteria createRelationalCriteria(CommonTree tree) {
		String field = null;
		Object value = null;
		boolean valueIsField = false;
		boolean valueIsNull = false;

		// Iterate over children to find field and expected value
		for (Object obj : tree.getChildren()) {
			CommonTree child = (CommonTree) obj;
			if (child.getType() == CriteriaParser.FIELD) {
				if (field != null) {
					value = child.getText();
					valueIsField = true;
				} else {
					field = child.getText();
				}
			} else if (child.getType() == CriteriaParser.NUMBER) {
				value = Integer.parseInt(child.getText());

			} else if (child.getType() == CriteriaParser.STRING) {
				value = child.getText();

			} else if (child.getType() == CriteriaParser.NULL) {
				valueIsNull = true;
			}
		}

		// Create criteria according to the operator
		Criteria criteria = null;
		if (!valueIsField && field != null && value != null) {
			// If we have a field and a value which isn't a field
			// We can create a simple criteria using the API
			switch (tree.getType()) {
			case CriteriaParser.IS:
				criteria = where(field).is(value);
				break;
			case CriteriaParser.GT:
				criteria = where(field).gt(value);
				break;
			case CriteriaParser.GTE:
				criteria = where(field).gte(value);
				break;
			case CriteriaParser.LT:
				criteria = where(field).lt(value);
				break;
			case CriteriaParser.LTE:
				criteria = where(field).lte(value);
				break;
			case CriteriaParser.NE:
				criteria = where(field).ne(value);
				break;
			}

		} else if (!valueIsField && field != null && valueIsNull) {
			// We want check that the field exists
			criteria = where(field).exists(tree.getType() == CriteriaParser.NE);

		} else if (field != null && value != null) {
			// If we compare field, we have to use the mongo operator $where
			// This operator use javascrtipt and executes more slowly than the
			// native operators. But is very flexible so we use it!
			criteria = new Criteria("$where").is("this." + field + tree.getText() + "this." + value);

		} else if (tree.getChildren() != null && tree.getChildCount() > 1) {
			// We didn't found any field and value.
			// We will create the criteria using $where operator
			// This operator use javascrtipt and executes more slowly than the
			// native operators. But is very flexible so we use it!
			String part1 = this.visitArithmeticExpression((CommonTree) tree.getChild(0));
			String part2 = this.visitArithmeticExpression((CommonTree) tree.getChild(1));
			criteria = new Criteria("$where").is(part1 + tree.getText() + part2);

		}

		return criteria;
	}

	private String visitArithmeticExpression(CommonTree tree) {
		String expression = null;
		if (tree.getType() == CriteriaParser.NUMBER || tree.getType() == CriteriaParser.STRING) {
			expression = tree.getText();
		} else if (tree.getType() == CriteriaParser.FIELD) {
			expression = "this." + tree.getText();
		} else if (tree.getType() == CriteriaParser.ARITHMETIC_OPERATOR && tree.getChildren() != null && tree.getChildCount() > 1) {
			String part1 = this.visitArithmeticExpression((CommonTree) tree.getChild(0));
			String part2 = this.visitArithmeticExpression((CommonTree) tree.getChild(1));
			expression = "(" + part1 + tree.getText() + part2 + ")";
		}
		return expression;
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
