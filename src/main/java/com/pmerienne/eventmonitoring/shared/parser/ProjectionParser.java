// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/pmerienne/eventmonitoring/shared/parser/Projection.g 2012-06-19 14:07:21

package com.pmerienne.eventmonitoring.shared.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ProjectionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LPAREN", "RPAREN", "AND", "OR", "LT", "LTE", "GT", "GTE", "IS", "NE", "NULL", "COUNT_FUNCTION", "SUM_FUNCTION", "ARITHMETIC_OPERATOR", "NUMBER", "FIELD", "STRING", "WS"
    };
    public static final int EOF=-1;
    public static final int LPAREN=4;
    public static final int RPAREN=5;
    public static final int AND=6;
    public static final int OR=7;
    public static final int LT=8;
    public static final int LTE=9;
    public static final int GT=10;
    public static final int GTE=11;
    public static final int IS=12;
    public static final int NE=13;
    public static final int NULL=14;
    public static final int COUNT_FUNCTION=15;
    public static final int SUM_FUNCTION=16;
    public static final int ARITHMETIC_OPERATOR=17;
    public static final int NUMBER=18;
    public static final int FIELD=19;
    public static final int STRING=20;
    public static final int WS=21;

    // delegates
    // delegators


        public ProjectionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ProjectionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ProjectionParser.tokenNames; }
    public String getGrammarFileName() { return "com/pmerienne/eventmonitoring/shared/parser/Projection.g"; }


      //override method
      public void reportError(RecognitionException e) {
        displayRecognitionError(this.getTokenNames(), e);
        throw new RuntimeException(":(", e); 
      }


    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:71:1: expression : arithmeticfunctionexpression ;
    public final ProjectionParser.expression_return expression() throws RecognitionException {
        ProjectionParser.expression_return retval = new ProjectionParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ProjectionParser.arithmeticfunctionexpression_return arithmeticfunctionexpression1 = null;



        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:71:12: ( arithmeticfunctionexpression )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:71:14: arithmeticfunctionexpression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_arithmeticfunctionexpression_in_expression402);
            arithmeticfunctionexpression1=arithmeticfunctionexpression();

            state._fsp--;

            adaptor.addChild(root_0, arithmeticfunctionexpression1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class arithmeticfunctionexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithmeticfunctionexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:1: arithmeticfunctionexpression : functionexpression ( ARITHMETIC_OPERATOR ( functionexpression | NUMBER ) )* ;
    public final ProjectionParser.arithmeticfunctionexpression_return arithmeticfunctionexpression() throws RecognitionException {
        ProjectionParser.arithmeticfunctionexpression_return retval = new ProjectionParser.arithmeticfunctionexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR3=null;
        Token NUMBER5=null;
        ProjectionParser.functionexpression_return functionexpression2 = null;

        ProjectionParser.functionexpression_return functionexpression4 = null;


        Object ARITHMETIC_OPERATOR3_tree=null;
        Object NUMBER5_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:30: ( functionexpression ( ARITHMETIC_OPERATOR ( functionexpression | NUMBER ) )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:32: functionexpression ( ARITHMETIC_OPERATOR ( functionexpression | NUMBER ) )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_functionexpression_in_arithmeticfunctionexpression410);
            functionexpression2=functionexpression();

            state._fsp--;

            adaptor.addChild(root_0, functionexpression2.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:51: ( ARITHMETIC_OPERATOR ( functionexpression | NUMBER ) )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:52: ARITHMETIC_OPERATOR ( functionexpression | NUMBER )
            	    {
            	    ARITHMETIC_OPERATOR3=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticfunctionexpression413); 
            	    ARITHMETIC_OPERATOR3_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR3);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR3_tree, root_0);

            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:73: ( functionexpression | NUMBER )
            	    int alt1=2;
            	    switch ( input.LA(1) ) {
            	    case LPAREN:
            	    case COUNT_FUNCTION:
            	    case SUM_FUNCTION:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:74: functionexpression
            	            {
            	            pushFollow(FOLLOW_functionexpression_in_arithmeticfunctionexpression417);
            	            functionexpression4=functionexpression();

            	            state._fsp--;

            	            adaptor.addChild(root_0, functionexpression4.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:73:95: NUMBER
            	            {
            	            NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_arithmeticfunctionexpression421); 
            	            NUMBER5_tree = (Object)adaptor.create(NUMBER5);
            	            adaptor.addChild(root_0, NUMBER5_tree);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arithmeticfunctionexpression"

    public static class functionexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:75:1: functionexpression : ( COUNT_FUNCTION LPAREN andexpression RPAREN | SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN | LPAREN arithmeticfunctionexpression RPAREN );
    public final ProjectionParser.functionexpression_return functionexpression() throws RecognitionException {
        ProjectionParser.functionexpression_return retval = new ProjectionParser.functionexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COUNT_FUNCTION6=null;
        Token LPAREN7=null;
        Token RPAREN9=null;
        Token SUM_FUNCTION10=null;
        Token LPAREN11=null;
        Token RPAREN13=null;
        Token LPAREN14=null;
        Token RPAREN16=null;
        ProjectionParser.andexpression_return andexpression8 = null;

        ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression12 = null;

        ProjectionParser.arithmeticfunctionexpression_return arithmeticfunctionexpression15 = null;


        Object COUNT_FUNCTION6_tree=null;
        Object LPAREN7_tree=null;
        Object RPAREN9_tree=null;
        Object SUM_FUNCTION10_tree=null;
        Object LPAREN11_tree=null;
        Object RPAREN13_tree=null;
        Object LPAREN14_tree=null;
        Object RPAREN16_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:75:20: ( COUNT_FUNCTION LPAREN andexpression RPAREN | SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN | LPAREN arithmeticfunctionexpression RPAREN )
            int alt3=3;
            switch ( input.LA(1) ) {
            case COUNT_FUNCTION:
                {
                alt3=1;
                }
                break;
            case SUM_FUNCTION:
                {
                alt3=2;
                }
                break;
            case LPAREN:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:75:23: COUNT_FUNCTION LPAREN andexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    COUNT_FUNCTION6=(Token)match(input,COUNT_FUNCTION,FOLLOW_COUNT_FUNCTION_in_functionexpression433); 
                    COUNT_FUNCTION6_tree = (Object)adaptor.create(COUNT_FUNCTION6);
                    root_0 = (Object)adaptor.becomeRoot(COUNT_FUNCTION6_tree, root_0);

                    LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionexpression436); 
                    pushFollow(FOLLOW_andexpression_in_functionexpression439);
                    andexpression8=andexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, andexpression8.getTree());
                    RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionexpression441); 

                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:75:71: SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    SUM_FUNCTION10=(Token)match(input,SUM_FUNCTION,FOLLOW_SUM_FUNCTION_in_functionexpression446); 
                    SUM_FUNCTION10_tree = (Object)adaptor.create(SUM_FUNCTION10);
                    root_0 = (Object)adaptor.becomeRoot(SUM_FUNCTION10_tree, root_0);

                    LPAREN11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionexpression449); 
                    pushFollow(FOLLOW_sumarithmeticexpression_in_functionexpression452);
                    sumarithmeticexpression12=sumarithmeticexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, sumarithmeticexpression12.getTree());
                    RPAREN13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionexpression454); 

                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:75:127: LPAREN arithmeticfunctionexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN14=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionexpression459); 
                    pushFollow(FOLLOW_arithmeticfunctionexpression_in_functionexpression462);
                    arithmeticfunctionexpression15=arithmeticfunctionexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, arithmeticfunctionexpression15.getTree());
                    RPAREN16=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionexpression464); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionexpression"

    public static class andexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:77:1: andexpression : orexpression ( AND orexpression )* ;
    public final ProjectionParser.andexpression_return andexpression() throws RecognitionException {
        ProjectionParser.andexpression_return retval = new ProjectionParser.andexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND18=null;
        ProjectionParser.orexpression_return orexpression17 = null;

        ProjectionParser.orexpression_return orexpression19 = null;


        Object AND18_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:77:15: ( orexpression ( AND orexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:77:17: orexpression ( AND orexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orexpression_in_andexpression473);
            orexpression17=orexpression();

            state._fsp--;

            adaptor.addChild(root_0, orexpression17.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:77:30: ( AND orexpression )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case AND:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:77:31: AND orexpression
            	    {
            	    AND18=(Token)match(input,AND,FOLLOW_AND_in_andexpression476); 
            	    AND18_tree = (Object)adaptor.create(AND18);
            	    root_0 = (Object)adaptor.becomeRoot(AND18_tree, root_0);

            	    pushFollow(FOLLOW_orexpression_in_andexpression479);
            	    orexpression19=orexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, orexpression19.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andexpression"

    public static class orexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:79:1: orexpression : logicalexpression ( OR logicalexpression )* ;
    public final ProjectionParser.orexpression_return orexpression() throws RecognitionException {
        ProjectionParser.orexpression_return retval = new ProjectionParser.orexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR21=null;
        ProjectionParser.logicalexpression_return logicalexpression20 = null;

        ProjectionParser.logicalexpression_return logicalexpression22 = null;


        Object OR21_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:79:14: ( logicalexpression ( OR logicalexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:79:16: logicalexpression ( OR logicalexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalexpression_in_orexpression489);
            logicalexpression20=logicalexpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalexpression20.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:79:34: ( OR logicalexpression )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case OR:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:79:35: OR logicalexpression
            	    {
            	    OR21=(Token)match(input,OR,FOLLOW_OR_in_orexpression492); 
            	    OR21_tree = (Object)adaptor.create(OR21);
            	    root_0 = (Object)adaptor.becomeRoot(OR21_tree, root_0);

            	    pushFollow(FOLLOW_logicalexpression_in_orexpression495);
            	    logicalexpression22=logicalexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalexpression22.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orexpression"

    public static class logicalexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:81:1: logicalexpression : countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )* ;
    public final ProjectionParser.logicalexpression_return logicalexpression() throws RecognitionException {
        ProjectionParser.logicalexpression_return retval = new ProjectionParser.logicalexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set24=null;
        ProjectionParser.countarithmeticexpression_return countarithmeticexpression23 = null;

        ProjectionParser.countarithmeticexpression_return countarithmeticexpression25 = null;


        Object set24_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:81:19: ( countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:81:21: countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_countarithmeticexpression_in_logicalexpression505);
            countarithmeticexpression23=countarithmeticexpression();

            state._fsp--;

            adaptor.addChild(root_0, countarithmeticexpression23.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:81:47: ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case LT:
                case LTE:
                case GT:
                case GTE:
                case IS:
                case NE:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:81:48: ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression
            	    {
            	    set24=(Token)input.LT(1);
            	    set24=(Token)input.LT(1);
            	    if ( (input.LA(1)>=LT && input.LA(1)<=NE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set24), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_countarithmeticexpression_in_logicalexpression533);
            	    countarithmeticexpression25=countarithmeticexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, countarithmeticexpression25.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalexpression"

    public static class countarithmeticexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countarithmeticexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:83:1: countarithmeticexpression : countatom ( ARITHMETIC_OPERATOR countatom )* ;
    public final ProjectionParser.countarithmeticexpression_return countarithmeticexpression() throws RecognitionException {
        ProjectionParser.countarithmeticexpression_return retval = new ProjectionParser.countarithmeticexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR27=null;
        ProjectionParser.countatom_return countatom26 = null;

        ProjectionParser.countatom_return countatom28 = null;


        Object ARITHMETIC_OPERATOR27_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:83:27: ( countatom ( ARITHMETIC_OPERATOR countatom )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:83:29: countatom ( ARITHMETIC_OPERATOR countatom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_countatom_in_countarithmeticexpression543);
            countatom26=countatom();

            state._fsp--;

            adaptor.addChild(root_0, countatom26.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:83:39: ( ARITHMETIC_OPERATOR countatom )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:83:40: ARITHMETIC_OPERATOR countatom
            	    {
            	    ARITHMETIC_OPERATOR27=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_countarithmeticexpression546); 
            	    ARITHMETIC_OPERATOR27_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR27);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR27_tree, root_0);

            	    pushFollow(FOLLOW_countatom_in_countarithmeticexpression549);
            	    countatom28=countatom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, countatom28.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countarithmeticexpression"

    public static class sumarithmeticexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sumarithmeticexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:85:1: sumarithmeticexpression : sumatom ( ARITHMETIC_OPERATOR sumatom )* ;
    public final ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression() throws RecognitionException {
        ProjectionParser.sumarithmeticexpression_return retval = new ProjectionParser.sumarithmeticexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR30=null;
        ProjectionParser.sumatom_return sumatom29 = null;

        ProjectionParser.sumatom_return sumatom31 = null;


        Object ARITHMETIC_OPERATOR30_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:85:25: ( sumatom ( ARITHMETIC_OPERATOR sumatom )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:85:27: sumatom ( ARITHMETIC_OPERATOR sumatom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sumatom_in_sumarithmeticexpression559);
            sumatom29=sumatom();

            state._fsp--;

            adaptor.addChild(root_0, sumatom29.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:85:35: ( ARITHMETIC_OPERATOR sumatom )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:85:36: ARITHMETIC_OPERATOR sumatom
            	    {
            	    ARITHMETIC_OPERATOR30=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_sumarithmeticexpression562); 
            	    ARITHMETIC_OPERATOR30_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR30);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR30_tree, root_0);

            	    pushFollow(FOLLOW_sumatom_in_sumarithmeticexpression565);
            	    sumatom31=sumatom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sumatom31.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sumarithmeticexpression"

    public static class countatom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countatom"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:1: countatom : ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN );
    public final ProjectionParser.countatom_return countatom() throws RecognitionException {
        ProjectionParser.countatom_return retval = new ProjectionParser.countatom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL32=null;
        Token NUMBER33=null;
        Token STRING34=null;
        Token FIELD35=null;
        Token LPAREN36=null;
        Token RPAREN38=null;
        ProjectionParser.andexpression_return andexpression37 = null;


        Object NULL32_tree=null;
        Object NUMBER33_tree=null;
        Object STRING34_tree=null;
        Object FIELD35_tree=null;
        Object LPAREN36_tree=null;
        Object RPAREN38_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:11: ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN )
            int alt9=5;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt9=1;
                }
                break;
            case NUMBER:
                {
                alt9=2;
                }
                break;
            case STRING:
                {
                alt9=3;
                }
                break;
            case FIELD:
                {
                alt9=4;
                }
                break;
            case LPAREN:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:13: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL32=(Token)match(input,NULL,FOLLOW_NULL_in_countatom575); 
                    NULL32_tree = (Object)adaptor.create(NULL32);
                    adaptor.addChild(root_0, NULL32_tree);


                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:19: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER33=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_countatom578); 
                    NUMBER33_tree = (Object)adaptor.create(NUMBER33);
                    adaptor.addChild(root_0, NUMBER33_tree);


                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:28: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_countatom582); 
                    STRING34_tree = (Object)adaptor.create(STRING34);
                    adaptor.addChild(root_0, STRING34_tree);


                    }
                    break;
                case 4 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:37: FIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    FIELD35=(Token)match(input,FIELD,FOLLOW_FIELD_in_countatom586); 
                    FIELD35_tree = (Object)adaptor.create(FIELD35);
                    adaptor.addChild(root_0, FIELD35_tree);


                    }
                    break;
                case 5 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:87:45: LPAREN andexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN36=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_countatom590); 
                    pushFollow(FOLLOW_andexpression_in_countatom593);
                    andexpression37=andexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, andexpression37.getTree());
                    RPAREN38=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_countatom595); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countatom"

    public static class sumatom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sumatom"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:1: sumatom : ( NUMBER | STRING | FIELD | LPAREN sumarithmeticexpression RPAREN );
    public final ProjectionParser.sumatom_return sumatom() throws RecognitionException {
        ProjectionParser.sumatom_return retval = new ProjectionParser.sumatom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NUMBER39=null;
        Token STRING40=null;
        Token FIELD41=null;
        Token LPAREN42=null;
        Token RPAREN44=null;
        ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression43 = null;


        Object NUMBER39_tree=null;
        Object STRING40_tree=null;
        Object FIELD41_tree=null;
        Object LPAREN42_tree=null;
        Object RPAREN44_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:9: ( NUMBER | STRING | FIELD | LPAREN sumarithmeticexpression RPAREN )
            int alt10=4;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt10=1;
                }
                break;
            case STRING:
                {
                alt10=2;
                }
                break;
            case FIELD:
                {
                alt10=3;
                }
                break;
            case LPAREN:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:11: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER39=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_sumatom604); 
                    NUMBER39_tree = (Object)adaptor.create(NUMBER39);
                    adaptor.addChild(root_0, NUMBER39_tree);


                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:20: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING40=(Token)match(input,STRING,FOLLOW_STRING_in_sumatom608); 
                    STRING40_tree = (Object)adaptor.create(STRING40);
                    adaptor.addChild(root_0, STRING40_tree);


                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:29: FIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    FIELD41=(Token)match(input,FIELD,FOLLOW_FIELD_in_sumatom612); 
                    FIELD41_tree = (Object)adaptor.create(FIELD41);
                    adaptor.addChild(root_0, FIELD41_tree);


                    }
                    break;
                case 4 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:89:37: LPAREN sumarithmeticexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN42=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_sumatom616); 
                    pushFollow(FOLLOW_sumarithmeticexpression_in_sumatom619);
                    sumarithmeticexpression43=sumarithmeticexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, sumarithmeticexpression43.getTree());
                    RPAREN44=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_sumatom621); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sumatom"

    // Delegated rules


 

    public static final BitSet FOLLOW_arithmeticfunctionexpression_in_expression402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionexpression_in_arithmeticfunctionexpression410 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticfunctionexpression413 = new BitSet(new long[]{0x0000000000058010L});
    public static final BitSet FOLLOW_functionexpression_in_arithmeticfunctionexpression417 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_NUMBER_in_arithmeticfunctionexpression421 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COUNT_FUNCTION_in_functionexpression433 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_functionexpression436 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_andexpression_in_functionexpression439 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_functionexpression441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_FUNCTION_in_functionexpression446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_functionexpression449 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumarithmeticexpression_in_functionexpression452 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_functionexpression454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_functionexpression459 = new BitSet(new long[]{0x0000000000018010L});
    public static final BitSet FOLLOW_arithmeticfunctionexpression_in_functionexpression462 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_functionexpression464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpression_in_andexpression473 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AND_in_andexpression476 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_orexpression_in_andexpression479 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression489 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_OR_in_orexpression492 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression495 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_countarithmeticexpression_in_logicalexpression505 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_set_in_logicalexpression508 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_countarithmeticexpression_in_logicalexpression533 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_countatom_in_countarithmeticexpression543 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_countarithmeticexpression546 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_countatom_in_countarithmeticexpression549 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_sumatom_in_sumarithmeticexpression559 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_sumarithmeticexpression562 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumatom_in_sumarithmeticexpression565 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_NULL_in_countatom575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_countatom578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_countatom582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_in_countatom586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_countatom590 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_andexpression_in_countatom593 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_countatom595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_sumatom604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_sumatom608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_in_sumatom612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_sumatom616 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumarithmeticexpression_in_sumatom619 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_sumatom621 = new BitSet(new long[]{0x0000000000000002L});

}