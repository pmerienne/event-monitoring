// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/pmerienne/event/vizualisation/shared/parser/Criteria.g 2012-06-11 10:10:34

package com.pmerienne.eventmonitoring.shared.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CriteriaLexer extends Lexer {
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

      //override method
      public void reportError(RecognitionException e) {
        displayRecognitionError(this.getTokenNames(), e);
        throw new RuntimeException(":(", e); 
      }
      


    // delegates
    // delegators

    public CriteriaLexer() {;} 
    public CriteriaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CriteriaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "com/pmerienne/event/vizualisation/shared/parser/Criteria.g"; }

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:45:8: ( '(' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:45:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:46:8: ( ')' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:46:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:47:5: ( '&&' | 'and' | 'AND' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case '&':
                {
                alt1=1;
                }
                break;
            case 'a':
                {
                alt1=2;
                }
                break;
            case 'A':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:47:7: '&&'
                    {
                    match("&&"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:47:14: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:47:22: 'AND'
                    {
                    match("AND"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:48:4: ( '||' | 'or' | 'OR' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case '|':
                {
                alt2=1;
                }
                break;
            case 'o':
                {
                alt2=2;
                }
                break;
            case 'O':
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:48:6: '||'
                    {
                    match("||"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:48:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:48:20: 'OR'
                    {
                    match("OR"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:49:4: ( '<' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:49:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "LTE"
    public final void mLTE() throws RecognitionException {
        try {
            int _type = LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:50:5: ( '<=' | '=<' )
            int alt3=2;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt3=1;
                }
                break;
            case '=':
                {
                alt3=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:50:7: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:50:14: '=<'
                    {
                    match("=<"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:51:4: ( '>' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:51:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "GTE"
    public final void mGTE() throws RecognitionException {
        try {
            int _type = GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:52:5: ( '>=' | '=>' )
            int alt4=2;
            switch ( input.LA(1) ) {
            case '>':
                {
                alt4=1;
                }
                break;
            case '=':
                {
                alt4=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:52:7: '>='
                    {
                    match(">="); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:52:14: '=>'
                    {
                    match("=>"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GTE"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:53:4: ( '==' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:53:6: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:54:4: ( '!=' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:54:6: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:55:6: ( 'null' | 'NULL' )
            int alt5=2;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt5=1;
                }
                break;
            case 'N':
                {
                alt5=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:55:8: 'null'
                    {
                    match("null"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:55:17: 'NULL'
                    {
                    match("NULL"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "ARITHMETIC_OPERATOR"
    public final void mARITHMETIC_OPERATOR() throws RecognitionException {
        try {
            int _type = ARITHMETIC_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:57:21: ( '+' | '-' | '/' | '*' )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:
            {
            if ( (input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARITHMETIC_OPERATOR"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:8: ( ( '0' .. '9' )+ | '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:10: ( '0' .. '9' )+
                    {
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:10: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt6=1;
                            }
                            break;

                        }

                        switch (alt6) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:11: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:25: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:29: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt7=1;
                            }
                            break;

                        }

                        switch (alt7) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:30: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:43: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
                    {
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:43: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt8=1;
                            }
                            break;

                        }

                        switch (alt8) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:44: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match('.'); 
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:59: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        switch ( input.LA(1) ) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            {
                            alt9=1;
                            }
                            break;

                        }

                        switch (alt9) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:58:60: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "FIELD"
    public final void mFIELD() throws RecognitionException {
        try {
            int _type = FIELD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:7: ( 'id' | 'type' | 'date' | 'data.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+ )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt12=1;
                }
                break;
            case 't':
                {
                alt12=2;
                }
                break;
            case 'd':
                {
                switch ( input.LA(2) ) {
                case 'a':
                    {
                    switch ( input.LA(3) ) {
                    case 't':
                        {
                        switch ( input.LA(4) ) {
                        case 'e':
                            {
                            alt12=3;
                            }
                            break;
                        case 'a':
                            {
                            alt12=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 5, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:9: 'id'
                    {
                    match("id"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:16: 'type'
                    {
                    match("type"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:25: 'date'
                    {
                    match("date"); 


                    }
                    break;
                case 4 :
                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:34: 'data.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
                    {
                    match("data."); 

                    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:59:42: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        switch ( input.LA(1) ) {
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            {
                            alt11=1;
                            }
                            break;

                        }

                        switch (alt11) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:
                    	    {
                    	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIELD"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:60:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+ )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:60:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+
            {
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:60:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case '#':
                case '&':
                case '.':
                case '/':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case ':':
                case '?':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:
            	    {
            	    if ( input.LA(1)=='#'||input.LA(1)=='&'||(input.LA(1)>='.' && input.LA(1)<=':')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:61:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:61:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:61:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:8: ( LPAREN | RPAREN | AND | OR | LT | LTE | GT | GTE | IS | NE | NULL | ARITHMETIC_OPERATOR | NUMBER | FIELD | STRING | WS )
        int alt15=16;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:10: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 2 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:17: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 3 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:24: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:28: OR
                {
                mOR(); 

                }
                break;
            case 5 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:31: LT
                {
                mLT(); 

                }
                break;
            case 6 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:34: LTE
                {
                mLTE(); 

                }
                break;
            case 7 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:38: GT
                {
                mGT(); 

                }
                break;
            case 8 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:41: GTE
                {
                mGTE(); 

                }
                break;
            case 9 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:45: IS
                {
                mIS(); 

                }
                break;
            case 10 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:48: NE
                {
                mNE(); 

                }
                break;
            case 11 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:51: NULL
                {
                mNULL(); 

                }
                break;
            case 12 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:56: ARITHMETIC_OPERATOR
                {
                mARITHMETIC_OPERATOR(); 

                }
                break;
            case 13 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:76: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 14 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:83: FIELD
                {
                mFIELD(); 

                }
                break;
            case 15 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:89: STRING
                {
                mSTRING(); 

                }
                break;
            case 16 :
                // com/pmerienne/event/vizualisation/shared/parser/Criteria.g:1:96: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA10_eotS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\2\56\3\uffff";
    static final String DFA10_maxS =
        "\2\71\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "58:1: NUMBER : ( ( '0' .. '9' )+ | '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )+ );";
        }
    }
    static final String DFA15_eotS =
        "\3\uffff\3\26\1\uffff\2\26\1\36\1\uffff\1\41\1\uffff\2\26\1\25\1"+
        "\44\4\26\3\uffff\1\52\2\26\2\6\5\uffff\2\26\1\uffff\1\26\1\44\1"+
        "\60\2\26\1\uffff\2\52\2\26\1\44\1\uffff\2\26\2\70\2\60\1\26\1\uffff"+
        "\1\26\1\60";
    static final String DFA15_eofS =
        "\73\uffff";
    static final String DFA15_minS =
        "\1\11\2\uffff\1\46\1\156\1\116\1\uffff\1\162\1\122\1\75\1\74\1\75"+
        "\1\uffff\1\165\1\125\2\43\1\60\1\144\1\171\1\141\3\uffff\1\43\1"+
        "\144\1\104\2\43\5\uffff\1\154\1\114\1\uffff\1\60\2\43\1\160\1\164"+
        "\1\uffff\2\43\1\154\1\114\1\43\1\uffff\1\145\1\141\4\43\1\56\1\uffff"+
        "\1\56\1\43";
    static final String DFA15_maxS =
        "\1\174\2\uffff\1\46\1\156\1\116\1\uffff\1\162\1\122\1\75\1\76\1"+
        "\75\1\uffff\1\165\1\125\2\172\1\71\1\144\1\171\1\141\3\uffff\1\172"+
        "\1\144\1\104\2\172\5\uffff\1\154\1\114\1\uffff\1\71\2\172\1\160"+
        "\1\164\1\uffff\2\172\1\154\1\114\1\172\1\uffff\2\145\4\172\1\56"+
        "\1\uffff\2\172";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\4\5\uffff\1\12\10\uffff\1\14\1\17\1\20"+
        "\5\uffff\1\6\1\5\1\10\1\11\1\7\2\uffff\1\15\5\uffff\1\3\5\uffff"+
        "\1\16\7\uffff\1\13\2\uffff";
    static final String DFA15_specialS =
        "\73\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\27\2\uffff\1\27\22\uffff\1\27\1\14\1\uffff\1\26\2\uffff\1"+
            "\3\1\uffff\1\1\1\2\2\25\1\uffff\1\25\1\21\1\17\12\20\1\26\1"+
            "\uffff\1\11\1\12\1\13\1\26\1\uffff\1\5\14\26\1\16\1\10\13\26"+
            "\6\uffff\1\4\2\26\1\24\4\26\1\22\4\26\1\15\1\7\4\26\1\23\6\26"+
            "\1\uffff\1\6",
            "",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\35\1\40\1\37",
            "\1\37",
            "",
            "\1\42",
            "\1\43",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\1\45\1\26\12\20\1\26\4\uffff\1\26"+
            "\1\uffff\32\26\6\uffff\32\26",
            "\12\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\53",
            "\1\54",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\56",
            "",
            "\12\57",
            "\1\26\2\uffff\1\26\7\uffff\2\26\12\46\1\26\4\uffff\1\26\1\uffff"+
            "\32\26\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\61",
            "\1\62",
            "",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\63",
            "\1\64",
            "\1\26\2\uffff\1\26\7\uffff\2\26\12\57\1\26\4\uffff\1\26\1\uffff"+
            "\32\26\6\uffff\32\26",
            "",
            "\1\65",
            "\1\67\3\uffff\1\66",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\26\2\uffff\1\26\7\uffff\15\26\4\uffff\1\26\1\uffff\32\26"+
            "\6\uffff\32\26",
            "\1\71",
            "",
            "\1\72\1\uffff\12\72\7\uffff\32\72\6\uffff\32\72",
            "\1\26\2\uffff\1\26\7\uffff\1\72\1\26\12\72\1\26\4\uffff\1\26"+
            "\1\uffff\32\72\6\uffff\32\72"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LPAREN | RPAREN | AND | OR | LT | LTE | GT | GTE | IS | NE | NULL | ARITHMETIC_OPERATOR | NUMBER | FIELD | STRING | WS );";
        }
    }
 

}