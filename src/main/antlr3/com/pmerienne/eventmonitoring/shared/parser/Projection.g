grammar Projection;

options
{
  // antlr will generate java lexer and parser
  language = Java;
  // generated parser should create abstract syntax tree
  output = AST;
}

//as the generated lexer will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@lexer::header {
package com.pmerienne.eventmonitoring.shared.parser;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package com.pmerienne.eventmonitoring.shared.parser;
}

//override some methods and add new members to generated lexer
@lexer::members {
  //override method
  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new RuntimeException(":(", e); 
  }
  
}

//override some methods and add new members to generated parser
@parser::members {
  //override method
  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new RuntimeException(":(", e); 
  }
}


// ***************** lexer rules:
//the grammar must contain at least one lexer rule
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&&' | 'and' | 'AND';
OR : '||' | 'or' | 'OR';
LT : '<';
LTE : '<=' | '=<';
GT : '>';
GTE : '>=' | '=>';
IS : '==';
NE : '!=';
NULL : 'null' | 'NULL';

COUNT_FUNCTION : 'count' | 'COUNT';
SUM_FUNCTION : 'sum' | 'SUM';

ARITHMETIC_OPERATOR : '+' | '-' | '/' | '*';
NUMBER : ('0'..'9')+  | '.' ('0'..'9')+ | ('0'..'9')+ '.' ('0'..'9')+;
FIELD	:	'id' | 'type' | 'date' | 'data.' ('a'..'z' | 'A'..'Z' | '0'..'9' | '.')+ ;
STRING	:	('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '/' | ':' | '#' | '&' | '?' )+ ;
WS : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; } ;

// ***************** parser rules:
//This looks useless, but ANTLR would complain about "no start rule (...)"
//without it. As this rule is not referenced by any other rule, ANTLR will 
//start rule and the warning disappears. 
//
//start rule
expression : arithmeticfunctionexpression;

arithmeticfunctionexpression : functionexpression (ARITHMETIC_OPERATOR^ functionexpression)*;

functionexpression : COUNT_FUNCTION^ LPAREN! andexpression RPAREN! | SUM_FUNCTION^ LPAREN! sumarithmeticexpression RPAREN!;

andexpression : orexpression (AND^ orexpression)*;

orexpression : logicalexpression (OR^ logicalexpression)*;

logicalexpression : countarithmeticexpression ((LT | LTE | GT | GTE | IS | NE)^ countarithmeticexpression)*;

countarithmeticexpression : countatom (ARITHMETIC_OPERATOR^ countatom)*;

sumarithmeticexpression : sumatom (ARITHMETIC_OPERATOR^ sumatom)*;

countatom : NULL |NUMBER | STRING | FIELD | LPAREN! andexpression RPAREN!;

sumatom : NUMBER | STRING | FIELD | LPAREN! sumarithmeticexpression RPAREN!;
  