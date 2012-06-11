// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/pmerienne/eventmonitoring/shared/parser/Criteria.g 2012-06-11 15:03:17

package com.pmerienne.eventmonitoring.shared.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class CriteriaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LPAREN", "RPAREN", "AND", "OR", "LT", "LTE", "GT", "GTE", "IS", "NE", "NULL", "ARITHMETIC_OPERATOR", "NUMBER", "FIELD", "STRING", "WS"
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
    public static final int ARITHMETIC_OPERATOR=15;
    public static final int NUMBER=16;
    public static final int FIELD=17;
    public static final int STRING=18;
    public static final int WS=19;

    // delegates
    // delegators


        public CriteriaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CriteriaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CriteriaParser.tokenNames; }
    public String getGrammarFileName() { return "com/pmerienne/eventmonitoring/shared/parser/Criteria.g"; }


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
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:69:1: expression : andexpression ;
    public final CriteriaParser.expression_return expression() throws RecognitionException {
        CriteriaParser.expression_return retval = new CriteriaParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CriteriaParser.andexpression_return andexpression1 = null;



        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:69:12: ( andexpression )
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:69:14: andexpression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andexpression_in_expression380);
            andexpression1=andexpression();

            state._fsp--;

            adaptor.addChild(root_0, andexpression1.getTree());

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

    public static class andexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:72:1: andexpression : orexpression ( AND orexpression )* ;
    public final CriteriaParser.andexpression_return andexpression() throws RecognitionException {
        CriteriaParser.andexpression_return retval = new CriteriaParser.andexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND3=null;
        CriteriaParser.orexpression_return orexpression2 = null;

        CriteriaParser.orexpression_return orexpression4 = null;


        Object AND3_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:72:15: ( orexpression ( AND orexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:72:17: orexpression ( AND orexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orexpression_in_andexpression389);
            orexpression2=orexpression();

            state._fsp--;

            adaptor.addChild(root_0, orexpression2.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:72:30: ( AND orexpression )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case AND:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:72:31: AND orexpression
            	    {
            	    AND3=(Token)match(input,AND,FOLLOW_AND_in_andexpression392); 
            	    AND3_tree = (Object)adaptor.create(AND3);
            	    root_0 = (Object)adaptor.becomeRoot(AND3_tree, root_0);

            	    pushFollow(FOLLOW_orexpression_in_andexpression395);
            	    orexpression4=orexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, orexpression4.getTree());

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
    // $ANTLR end "andexpression"

    public static class orexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:75:1: orexpression : logicalexpression ( OR logicalexpression )* ;
    public final CriteriaParser.orexpression_return orexpression() throws RecognitionException {
        CriteriaParser.orexpression_return retval = new CriteriaParser.orexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR6=null;
        CriteriaParser.logicalexpression_return logicalexpression5 = null;

        CriteriaParser.logicalexpression_return logicalexpression7 = null;


        Object OR6_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:75:14: ( logicalexpression ( OR logicalexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:75:16: logicalexpression ( OR logicalexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalexpression_in_orexpression406);
            logicalexpression5=logicalexpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalexpression5.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:75:34: ( OR logicalexpression )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case OR:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:75:35: OR logicalexpression
            	    {
            	    OR6=(Token)match(input,OR,FOLLOW_OR_in_orexpression409); 
            	    OR6_tree = (Object)adaptor.create(OR6);
            	    root_0 = (Object)adaptor.becomeRoot(OR6_tree, root_0);

            	    pushFollow(FOLLOW_logicalexpression_in_orexpression412);
            	    logicalexpression7=logicalexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalexpression7.getTree());

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
    // $ANTLR end "orexpression"

    public static class logicalexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:77:1: logicalexpression : arithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) arithmeticexpression )* ;
    public final CriteriaParser.logicalexpression_return logicalexpression() throws RecognitionException {
        CriteriaParser.logicalexpression_return retval = new CriteriaParser.logicalexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set9=null;
        CriteriaParser.arithmeticexpression_return arithmeticexpression8 = null;

        CriteriaParser.arithmeticexpression_return arithmeticexpression10 = null;


        Object set9_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:77:19: ( arithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) arithmeticexpression )* )
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:77:21: arithmeticexpression ( ( LT | LTE | GT | GTE | IS | NE ) arithmeticexpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_arithmeticexpression_in_logicalexpression422);
            arithmeticexpression8=arithmeticexpression();

            state._fsp--;

            adaptor.addChild(root_0, arithmeticexpression8.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:77:42: ( ( LT | LTE | GT | GTE | IS | NE ) arithmeticexpression )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case LT:
                case LTE:
                case GT:
                case GTE:
                case IS:
                case NE:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:77:43: ( LT | LTE | GT | GTE | IS | NE ) arithmeticexpression
            	    {
            	    set9=(Token)input.LT(1);
            	    set9=(Token)input.LT(1);
            	    if ( (input.LA(1)>=LT && input.LA(1)<=NE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set9), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_arithmeticexpression_in_logicalexpression450);
            	    arithmeticexpression10=arithmeticexpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, arithmeticexpression10.getTree());

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
    // $ANTLR end "logicalexpression"

    public static class arithmeticexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithmeticexpression"
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:79:1: arithmeticexpression : atom ( ARITHMETIC_OPERATOR atom )* ;
    public final CriteriaParser.arithmeticexpression_return arithmeticexpression() throws RecognitionException {
        CriteriaParser.arithmeticexpression_return retval = new CriteriaParser.arithmeticexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ARITHMETIC_OPERATOR12=null;
        CriteriaParser.atom_return atom11 = null;

        CriteriaParser.atom_return atom13 = null;


        Object ARITHMETIC_OPERATOR12_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:79:22: ( atom ( ARITHMETIC_OPERATOR atom )* )
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:79:24: atom ( ARITHMETIC_OPERATOR atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_arithmeticexpression460);
            atom11=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom11.getTree());
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:79:29: ( ARITHMETIC_OPERATOR atom )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case ARITHMETIC_OPERATOR:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:79:30: ARITHMETIC_OPERATOR atom
            	    {
            	    ARITHMETIC_OPERATOR12=(Token)match(input,ARITHMETIC_OPERATOR,FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticexpression463); 
            	    ARITHMETIC_OPERATOR12_tree = (Object)adaptor.create(ARITHMETIC_OPERATOR12);
            	    root_0 = (Object)adaptor.becomeRoot(ARITHMETIC_OPERATOR12_tree, root_0);

            	    pushFollow(FOLLOW_atom_in_arithmeticexpression466);
            	    atom13=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom13.getTree());

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
    // $ANTLR end "arithmeticexpression"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:1: atom : ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN );
    public final CriteriaParser.atom_return atom() throws RecognitionException {
        CriteriaParser.atom_return retval = new CriteriaParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL14=null;
        Token NUMBER15=null;
        Token STRING16=null;
        Token FIELD17=null;
        Token LPAREN18=null;
        Token RPAREN20=null;
        CriteriaParser.andexpression_return andexpression19 = null;


        Object NULL14_tree=null;
        Object NUMBER15_tree=null;
        Object STRING16_tree=null;
        Object FIELD17_tree=null;
        Object LPAREN18_tree=null;
        Object RPAREN20_tree=null;

        try {
            // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:6: ( NULL | NUMBER | STRING | FIELD | LPAREN andexpression RPAREN )
            int alt5=5;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt5=1;
                }
                break;
            case NUMBER:
                {
                alt5=2;
                }
                break;
            case STRING:
                {
                alt5=3;
                }
                break;
            case FIELD:
                {
                alt5=4;
                }
                break;
            case LPAREN:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:8: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL14=(Token)match(input,NULL,FOLLOW_NULL_in_atom477); 
                    NULL14_tree = (Object)adaptor.create(NULL14);
                    adaptor.addChild(root_0, NULL14_tree);


                    }
                    break;
                case 2 :
                    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:14: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER15=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom480); 
                    NUMBER15_tree = (Object)adaptor.create(NUMBER15);
                    adaptor.addChild(root_0, NUMBER15_tree);


                    }
                    break;
                case 3 :
                    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:23: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING16=(Token)match(input,STRING,FOLLOW_STRING_in_atom484); 
                    STRING16_tree = (Object)adaptor.create(STRING16);
                    adaptor.addChild(root_0, STRING16_tree);


                    }
                    break;
                case 4 :
                    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:32: FIELD
                    {
                    root_0 = (Object)adaptor.nil();

                    FIELD17=(Token)match(input,FIELD,FOLLOW_FIELD_in_atom488); 
                    FIELD17_tree = (Object)adaptor.create(FIELD17);
                    adaptor.addChild(root_0, FIELD17_tree);


                    }
                    break;
                case 5 :
                    // com/pmerienne/eventmonitoring/shared/parser/Criteria.g:82:40: LPAREN andexpression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN18=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom492); 
                    pushFollow(FOLLOW_andexpression_in_atom495);
                    andexpression19=andexpression();

                    state._fsp--;

                    adaptor.addChild(root_0, andexpression19.getTree());
                    RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom497); 

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
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_andexpression_in_expression380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpression_in_andexpression389 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AND_in_andexpression392 = new BitSet(new long[]{0x0000000000074010L});
    public static final BitSet FOLLOW_orexpression_in_andexpression395 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression406 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_OR_in_orexpression409 = new BitSet(new long[]{0x0000000000074010L});
    public static final BitSet FOLLOW_logicalexpression_in_orexpression412 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_arithmeticexpression_in_logicalexpression422 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_set_in_logicalexpression425 = new BitSet(new long[]{0x0000000000074010L});
    public static final BitSet FOLLOW_arithmeticexpression_in_logicalexpression450 = new BitSet(new long[]{0x0000000000003F02L});
    public static final BitSet FOLLOW_atom_in_arithmeticexpression460 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ARITHMETIC_OPERATOR_in_arithmeticexpression463 = new BitSet(new long[]{0x0000000000074010L});
    public static final BitSet FOLLOW_atom_in_arithmeticexpression466 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_NULL_in_atom477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_in_atom488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom492 = new BitSet(new long[]{0x0000000000074010L});
    public static final BitSet FOLLOW_andexpression_in_atom495 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RPAREN_in_atom497 = new BitSet(new long[]{0x0000000000000002L});

}