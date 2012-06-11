// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/pmerienne/eventmonitoring/shared/parser/Projection.g 2012-06-11 15:03:18

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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:72:1: expression : arithmeticfunctionexpression ;
    public final ProjectionParser.expression_return expression() throws RecognitionException {
        ProjectionParser.expression_return retval = new ProjectionParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ProjectionParser.arithmeticfunctionexpression_return arithmeticfunctionexpression1 = null;



        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:72:12: ( arithmeticfunctionexpression )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:72:14: arithmeticfunctionexpression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_arithmeticfunctionexpression_in_expression403);
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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:74:1: arithmeticfunctionexpression : functionexpression ( ARITHMETIC_OPERATOR functionexpression )* ;
    public final ProjectionParser.arithmeticfunctionexpression_return arithmeticfunctionexpression() throws RecognitionException {
        ProjectionParser.arithmeticfunctionexpression_return retval = new ProjectionParser.arithmeticfunctionexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR3=null;
        ProjectionParser.functionexpression_return functionexpression2 = null;

        ProjectionParser.functionexpression_return functionexpression4 = null;


        Object ARITHMETIC_OPERATOR3_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:74:30: ( functionexpression ( ARITHMETIC_OPERATOR functionexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:74:32: functionexpression ( ARITHMETIC_OPERATOR functionexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_functionexpression_in_arithmeticfunctionexpression411);
            functionexpression2=functionexpression();

            state._fsp--;

            adaptor.addChild(root_0, functionexpression2.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:74:51: ( ARITHMETIC_OPERATOR functionexpression )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:74:52: ARITHMETIC_OPERATOR functionexpression
            	    {
            	    ARITHMETIC_OPERATOR3=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticfunctionexpression414); 
            	    ARITHMETIC_OPERATOR3_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR3);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR3_tree, root_0);

            	    pushFollow(FOLLOW_functionexpression_in_arithmeticfunctionexpression417);
            	    functionexpression4=functionexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, functionexpression4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:76:1: functionexpression : ( COUNT_FUNCTION LPAREN andexpression RPAREN | SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN );
    public final ProjectionParser.functionexpression_return functionexpression() throws RecognitionException {
        ProjectionParser.functionexpression_return retval = new ProjectionParser.functionexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COUNT_FUNCTION5=null;
        Token LPAREN6=null;
        Token RPAREN8=null;
        Token SUM_FUNCTION9=null;
        Token LPAREN10=null;
        Token RPAREN12=null;
        ProjectionParser.andexpression_return andexpression7 = null;

        ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression11 = null;


        Object COUNT_FUNCTION5_tree=null;
        Object LPAREN6_tree=null;
        Object RPAREN8_tree=null;
        Object SUM_FUNCTION9_tree=null;
        Object LPAREN10_tree=null;
        Object RPAREN12_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:76:20: ( COUNT_FUNCTION LPAREN andexpression RPAREN | SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN )
            int alt2=2;
            switch ( input.LA(1) ) {
            case COUNT_FUNCTION:
                {
                alt2=1;
                }
                break;
            case SUM_FUNCTION:
                {
                alt2=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:76:22: COUNT_FUNCTION LPAREN andexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    COUNT_FUNCTION5=(Token)match(input,COUNT_FUNCTION,FOLLOW_COUNT_FUNCTION_in_functionexpression427); 
                    COUNT_FUNCTION5_tree = (Object)adaptor.create(COUNT_FUNCTION5);
                    root_0 = (Object)adaptor.becomeRoot(COUNT_FUNCTION5_tree, root_0);

                    LPAREN6=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionexpression430); 
                    pushFollow(FOLLOW_andexpression_in_functionexpression433);
                    andexpression7=andexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, andexpression7.getTree());
                    RPAREN8=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionexpression435); 

                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:76:70: SUM_FUNCTION LPAREN sumarithmeticexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    SUM_FUNCTION9=(Token)match(input,SUM_FUNCTION,FOLLOW_SUM_FUNCTION_in_functionexpression440); 
                    SUM_FUNCTION9_tree = (Object)adaptor.create(SUM_FUNCTION9);
                    root_0 = (Object)adaptor.becomeRoot(SUM_FUNCTION9_tree, root_0);

                    LPAREN10=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionexpression443); 
                    pushFollow(FOLLOW_sumarithmeticexpression_in_functionexpression446);
                    sumarithmeticexpression11=sumarithmeticexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, sumarithmeticexpression11.getTree());
                    RPAREN12=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionexpression448); 

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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:78:1: andexpression : orexpression ( AND orexpression )* ;
    public final ProjectionParser.andexpression_return andexpression() throws RecognitionException {
        ProjectionParser.andexpression_return retval = new ProjectionParser.andexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND14=null;
        ProjectionParser.orexpression_return orexpression13 = null;

        ProjectionParser.orexpression_return orexpression15 = null;


        Object AND14_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:78:15: ( orexpression ( AND orexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:78:17: orexpression ( AND orexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orexpression_in_andexpression457);
            orexpression13=orexpression();

            state._fsp--;

            adaptor.addChild(root_0, orexpression13.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:78:30: ( AND orexpression )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case AND:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:78:31: AND orexpression
            	    {
            	    AND14=(Token)match(input,AND,FOLLOW_AND_in_andexpression460); 
            	    AND14_tree = (Object)adaptor.create(AND14);
            	    root_0 = (Object)adaptor.becomeRoot(AND14_tree, root_0);

            	    pushFollow(FOLLOW_orexpression_in_andexpression463);
            	    orexpression15=orexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, orexpression15.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:80:1: orexpression : logicalexpression ( OR logicalexpression )* ;
    public final ProjectionParser.orexpression_return orexpression() throws RecognitionException {
        ProjectionParser.orexpression_return retval = new ProjectionParser.orexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR17=null;
        ProjectionParser.logicalexpression_return logicalexpression16 = null;

        ProjectionParser.logicalexpression_return logicalexpression18 = null;


        Object OR17_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:80:14: ( logicalexpression ( OR logicalexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:80:16: logicalexpression ( OR logicalexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalexpression_in_orexpression473);
            logicalexpression16=logicalexpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalexpression16.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:80:34: ( OR logicalexpression )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case OR:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:80:35: OR logicalexpression
            	    {
            	    OR17=(Token)match(input,OR,FOLLOW_OR_in_orexpression476); 
            	    OR17_tree = (Object)adaptor.create(OR17);
            	    root_0 = (Object)adaptor.becomeRoot(OR17_tree, root_0);

            	    pushFollow(FOLLOW_logicalexpression_in_orexpression479);
            	    logicalexpression18=logicalexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalexpression18.getTree());

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
    // $ANTLR end "orexpression"

    public static class logicalexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:82:1: logicalexpression : countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )* ;
    public final ProjectionParser.logicalexpression_return logicalexpression() throws RecognitionException {
        ProjectionParser.logicalexpression_return retval = new ProjectionParser.logicalexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set20=null;
        ProjectionParser.countarithmeticexpression_return countarithmeticexpression19 = null;

        ProjectionParser.countarithmeticexpression_return countarithmeticexpression21 = null;


        Object set20_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:82:19: ( countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:82:21: countarithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_countarithmeticexpression_in_logicalexpression489);
            countarithmeticexpression19=countarithmeticexpression();

            state._fsp--;

            adaptor.addChild(root_0, countarithmeticexpression19.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:82:47: ( ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case LT:
                case LTE:
                case GT:
                case GTE:
                case IS:
                case NE:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:82:48: ( LT | LTE | GT | GTE | IS | NE ) countarithmeticexpression
            	    {
            	    set20=(Token)input.LT(1);
            	    set20=(Token)input.LT(1);
            	    if ( (input.LA(1)>=LT && input.LA(1)<=NE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set20), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_countarithmeticexpression_in_logicalexpression517);
            	    countarithmeticexpression21=countarithmeticexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, countarithmeticexpression21.getTree());

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
    // $ANTLR end "logicalexpression"

    public static class countarithmeticexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countarithmeticexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:84:1: countarithmeticexpression : countatom ( ARITHMETIC_OPERATOR countatom )* ;
    public final ProjectionParser.countarithmeticexpression_return countarithmeticexpression() throws RecognitionException {
        ProjectionParser.countarithmeticexpression_return retval = new ProjectionParser.countarithmeticexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR23=null;
        ProjectionParser.countatom_return countatom22 = null;

        ProjectionParser.countatom_return countatom24 = null;


        Object ARITHMETIC_OPERATOR23_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:84:27: ( countatom ( ARITHMETIC_OPERATOR countatom )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:84:29: countatom ( ARITHMETIC_OPERATOR countatom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_countatom_in_countarithmeticexpression527);
            countatom22=countatom();

            state._fsp--;

            adaptor.addChild(root_0, countatom22.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:84:39: ( ARITHMETIC_OPERATOR countatom )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:84:40: ARITHMETIC_OPERATOR countatom
            	    {
            	    ARITHMETIC_OPERATOR23=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_countarithmeticexpression530); 
            	    ARITHMETIC_OPERATOR23_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR23);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR23_tree, root_0);

            	    pushFollow(FOLLOW_countatom_in_countarithmeticexpression533);
            	    countatom24=countatom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, countatom24.getTree());

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
    // $ANTLR end "countarithmeticexpression"

    public static class sumarithmeticexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sumarithmeticexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:86:1: sumarithmeticexpression : sumatom ( ARITHMETIC_OPERATOR sumatom )* ;
    public final ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression() throws RecognitionException {
        ProjectionParser.sumarithmeticexpression_return retval = new ProjectionParser.sumarithmeticexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR26=null;
        ProjectionParser.sumatom_return sumatom25 = null;

        ProjectionParser.sumatom_return sumatom27 = null;


        Object ARITHMETIC_OPERATOR26_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:86:25: ( sumatom ( ARITHMETIC_OPERATOR sumatom )* )
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:86:27: sumatom ( ARITHMETIC_OPERATOR sumatom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sumatom_in_sumarithmeticexpression543);
            sumatom25=sumatom();

            state._fsp--;

            adaptor.addChild(root_0, sumatom25.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:86:35: ( ARITHMETIC_OPERATOR sumatom )*
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
            	    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:86:36: ARITHMETIC_OPERATOR sumatom
            	    {
            	    ARITHMETIC_OPERATOR26=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_sumarithmeticexpression546); 
            	    ARITHMETIC_OPERATOR26_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR26);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR26_tree, root_0);

            	    pushFollow(FOLLOW_sumatom_in_sumarithmeticexpression549);
            	    sumatom27=sumatom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sumatom27.getTree());

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
    // $ANTLR end "sumarithmeticexpression"

    public static class countatom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countatom"
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:1: countatom : ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN );
    public final ProjectionParser.countatom_return countatom() throws RecognitionException {
        ProjectionParser.countatom_return retval = new ProjectionParser.countatom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL28=null;
        Token NUMBER29=null;
        Token STRING30=null;
        Token FIELD31=null;
        Token LPAREN32=null;
        Token RPAREN34=null;
        ProjectionParser.andexpression_return andexpression33 = null;


        Object NULL28_tree=null;
        Object NUMBER29_tree=null;
        Object STRING30_tree=null;
        Object FIELD31_tree=null;
        Object LPAREN32_tree=null;
        Object RPAREN34_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:11: ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN )
            int alt8=5;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt8=1;
                }
                break;
            case NUMBER:
                {
                alt8=2;
                }
                break;
            case STRING:
                {
                alt8=3;
                }
                break;
            case FIELD:
                {
                alt8=4;
                }
                break;
            case LPAREN:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:13: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL28=(Token)match(input,NULL,FOLLOW_NULL_in_countatom559); 
                    NULL28_tree = (Object)adaptor.create(NULL28);
                    adaptor.addChild(root_0, NULL28_tree);


                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:19: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER29=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_countatom562); 
                    NUMBER29_tree = (Object)adaptor.create(NUMBER29);
                    adaptor.addChild(root_0, NUMBER29_tree);


                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:28: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING30=(Token)match(input,STRING,FOLLOW_STRING_in_countatom566); 
                    STRING30_tree = (Object)adaptor.create(STRING30);
                    adaptor.addChild(root_0, STRING30_tree);


                    }
                    break;
                case 4 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:37: FIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    FIELD31=(Token)match(input,FIELD,FOLLOW_FIELD_in_countatom570); 
                    FIELD31_tree = (Object)adaptor.create(FIELD31);
                    adaptor.addChild(root_0, FIELD31_tree);


                    }
                    break;
                case 5 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:88:45: LPAREN andexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_countatom574); 
                    pushFollow(FOLLOW_andexpression_in_countatom577);
                    andexpression33=andexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, andexpression33.getTree());
                    RPAREN34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_countatom579); 

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
    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:1: sumatom : ( NUMBER | STRING | FIELD | LPAREN sumarithmeticexpression RPAREN );
    public final ProjectionParser.sumatom_return sumatom() throws RecognitionException {
        ProjectionParser.sumatom_return retval = new ProjectionParser.sumatom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NUMBER35=null;
        Token STRING36=null;
        Token FIELD37=null;
        Token LPAREN38=null;
        Token RPAREN40=null;
        ProjectionParser.sumarithmeticexpression_return sumarithmeticexpression39 = null;


        Object NUMBER35_tree=null;
        Object STRING36_tree=null;
        Object FIELD37_tree=null;
        Object LPAREN38_tree=null;
        Object RPAREN40_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:9: ( NUMBER | STRING | FIELD | LPAREN sumarithmeticexpression RPAREN )
            int alt9=4;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt9=1;
                }
                break;
            case STRING:
                {
                alt9=2;
                }
                break;
            case FIELD:
                {
                alt9=3;
                }
                break;
            case LPAREN:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:11: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER35=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_sumatom588); 
                    NUMBER35_tree = (Object)adaptor.create(NUMBER35);
                    adaptor.addChild(root_0, NUMBER35_tree);


                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:20: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING36=(Token)match(input,STRING,FOLLOW_STRING_in_sumatom592); 
                    STRING36_tree = (Object)adaptor.create(STRING36);
                    adaptor.addChild(root_0, STRING36_tree);


                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:29: FIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    FIELD37=(Token)match(input,FIELD,FOLLOW_FIELD_in_sumatom596); 
                    FIELD37_tree = (Object)adaptor.create(FIELD37);
                    adaptor.addChild(root_0, FIELD37_tree);


                    }
                    break;
                case 4 :
                    // com/pmerienne/eventmonitoring/shared/parser/Projection.g:90:37: LPAREN sumarithmeticexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN38=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_sumatom600); 
                    pushFollow(FOLLOW_sumarithmeticexpression_in_sumatom603);
                    sumarithmeticexpression39=sumarithmeticexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, sumarithmeticexpression39.getTree());
                    RPAREN40=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_sumatom605); 

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


 

    public static final BitSet FOLLOW_arithmeticfunctionexpression_in_expression403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionexpression_in_arithmeticfunctionexpression411 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticfunctionexpression414 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_functionexpression_in_arithmeticfunctionexpression417 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COUNT_FUNCTION_in_functionexpression427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_functionexpression430 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_andexpression_in_functionexpression433 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_functionexpression435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_FUNCTION_in_functionexpression440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LPAREN_in_functionexpression443 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumarithmeticexpression_in_functionexpression446 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_functionexpression448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpression_in_andexpression457 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AND_in_andexpression460 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_orexpression_in_andexpression463 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression473 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_OR_in_orexpression476 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression479 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_countarithmeticexpression_in_logicalexpression489 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_set_in_logicalexpression492 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_countarithmeticexpression_in_logicalexpression517 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_countatom_in_countarithmeticexpression527 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_countarithmeticexpression530 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_countatom_in_countarithmeticexpression533 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_sumatom_in_sumarithmeticexpression543 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_sumarithmeticexpression546 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumatom_in_sumarithmeticexpression549 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_NULL_in_countatom559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_countatom562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_countatom566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_in_countatom570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_countatom574 = new BitSet(new long[]{0x00000000001C4010L});
    public static final BitSet FOLLOW_andexpression_in_countatom577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_countatom579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_sumatom588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_sumatom592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_in_sumatom596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_sumatom600 = new BitSet(new long[]{0x00000000001C0010L});
    public static final BitSet FOLLOW_sumarithmeticexpression_in_sumatom603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_sumatom605 = new BitSet(new long[]{0x0000000000000002L});

}