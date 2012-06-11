// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/pmerienne/event/vizualisation/shared/parser/Projection.g 2012-06-11 11:55:23

package com.pmerienne.eventmonitoring.shared.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ProjectionLexer extends Lexer {
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

      //override method
      public void reportError(RecognitionException e) {
        displayRecognitionError(this.getTokenNames(), e);
        throw new RuntimeException(":(", e); 
      }
      


    // delegates
    // delegators

    public ProjectionLexer() {;} 
    public ProjectionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ProjectionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "com/pmerienne/event/vizualisation/shared/parser/Projection.g"; }

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:45:8: ( '(' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:45:10: '('
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:46:8: ( ')' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:46:10: ')'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:47:5: ( '&&' | 'and' | 'AND' )
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
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:47:7: '&&'
                    {
                    match("&&"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:47:14: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:47:22: 'AND'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:48:4: ( '||' | 'or' | 'OR' )
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
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:48:6: '||'
                    {
                    match("||"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:48:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:48:20: 'OR'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:49:4: ( '<' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:49:6: '<'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:50:5: ( '<=' | '=<' )
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
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:50:7: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:50:14: '=<'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:51:4: ( '>' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:51:6: '>'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:52:5: ( '>=' | '=>' )
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
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:52:7: '>='
                    {
                    match(">="); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:52:14: '=>'
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:53:4: ( '==' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:53:6: '=='
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:54:4: ( '!=' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:54:6: '!='
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:55:6: ( 'null' | 'NULL' )
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
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:55:8: 'null'
                    {
                    match("null"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:55:17: 'NULL'
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

    // $ANTLR start "COUNT_FUNCTION"
    public final void mCOUNT_FUNCTION() throws RecognitionException {
        try {
            int _type = COUNT_FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:57:16: ( 'count' | 'COUNT' )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 'c':
                {
                alt6=1;
                }
                break;
            case 'C':
                {
                alt6=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:57:18: 'count'
                    {
                    match("count"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:57:28: 'COUNT'
                    {
                    match("COUNT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COUNT_FUNCTION"

    // $ANTLR start "SUM_FUNCTION"
    public final void mSUM_FUNCTION() throws RecognitionException {
        try {
            int _type = SUM_FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:58:14: ( 'sum' | 'SUM' )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt7=1;
                }
                break;
            case 'S':
                {
                alt7=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:58:16: 'sum'
                    {
                    match("sum"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:58:24: 'SUM'
                    {
                    match("SUM"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM_FUNCTION"

    // $ANTLR start "ARITHMETIC_OPERATOR"
    public final void mARITHMETIC_OPERATOR() throws RecognitionException {
        try {
            int _type = ARITHMETIC_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:60:21: ( '+' | '-' | '/' | '*' )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:8: ( ( '0' .. '9' )+ | '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:10: ( '0' .. '9' )+
                    {
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:10: ( '0' .. '9' )+
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
                    	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:11: '0' .. '9'
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


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:25: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:29: ( '0' .. '9' )+
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
                    	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:30: '0' .. '9'
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
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:43: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
                    {
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:43: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
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
                            alt10=1;
                            }
                            break;

                        }

                        switch (alt10) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:44: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    match('.'); 
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:59: ( '0' .. '9' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
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
                            alt11=1;
                            }
                            break;

                        }

                        switch (alt11) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:61:60: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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
    // $ANTLR end "NUMBER"

    // $ANTLR start "FIELD"
    public final void mFIELD() throws RecognitionException {
        try {
            int _type = FIELD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:7: ( 'id' | 'type' | 'date' | 'data.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+ )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt14=1;
                }
                break;
            case 't':
                {
                alt14=2;
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
                            alt14=3;
                            }
                            break;
                        case 'a':
                            {
                            alt14=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 5, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:9: 'id'
                    {
                    match("id"); 


                    }
                    break;
                case 2 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:16: 'type'
                    {
                    match("type"); 


                    }
                    break;
                case 3 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:25: 'date'
                    {
                    match("date"); 


                    }
                    break;
                case 4 :
                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:34: 'data.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
                    {
                    match("data."); 

                    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:62:42: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
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
                            alt13=1;
                            }
                            break;

                        }

                        switch (alt13) {
                    	case 1 :
                    	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:
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
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:63:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+ )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:63:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+
            {
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:63:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | ':' | '#' | '&' | '?' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
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
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:64:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:64:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // com/pmerienne/event/vizualisation/shared/parser/Projection.g:64:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // com/pmerienne/event/vizualisation/shared/parser/Projection.g:
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
        // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:8: ( LPAREN | RPAREN | AND | OR | LT | LTE | GT | GTE | IS | NE | NULL | COUNT_FUNCTION | SUM_FUNCTION | ARITHMETIC_OPERATOR | NUMBER | FIELD | STRING | WS )
        int alt17=18;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:10: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 2 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:17: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 3 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:24: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:28: OR
                {
                mOR(); 

                }
                break;
            case 5 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:31: LT
                {
                mLT(); 

                }
                break;
            case 6 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:34: LTE
                {
                mLTE(); 

                }
                break;
            case 7 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:38: GT
                {
                mGT(); 

                }
                break;
            case 8 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:41: GTE
                {
                mGTE(); 

                }
                break;
            case 9 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:45: IS
                {
                mIS(); 

                }
                break;
            case 10 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:48: NE
                {
                mNE(); 

                }
                break;
            case 11 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:51: NULL
                {
                mNULL(); 

                }
                break;
            case 12 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:56: COUNT_FUNCTION
                {
                mCOUNT_FUNCTION(); 

                }
                break;
            case 13 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:71: SUM_FUNCTION
                {
                mSUM_FUNCTION(); 

                }
                break;
            case 14 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:84: ARITHMETIC_OPERATOR
                {
                mARITHMETIC_OPERATOR(); 

                }
                break;
            case 15 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:104: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 16 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:111: FIELD
                {
                mFIELD(); 

                }
                break;
            case 17 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:117: STRING
                {
                mSTRING(); 

                }
                break;
            case 18 :
                // com/pmerienne/event/vizualisation/shared/parser/Projection.g:1:124: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA12_eotS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA12_eofS =
        "\5\uffff";
    static final String DFA12_minS =
        "\2\56\3\uffff";
    static final String DFA12_maxS =
        "\2\71\3\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA12_specialS =
        "\5\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "61:1: NUMBER : ( ( '0' .. '9' )+ | '.' ( '0' .. '9' )+ | ( '0' .. '9' )+ '.' ( '0' .. '9' )+ );";
        }
    }
    static final String DFA17_eotS =
        "\3\uffff\3\32\1\uffff\2\32\1\42\1\uffff\1\45\1\uffff\6\32\1\31\1"+
        "\54\4\32\3\uffff\1\62\2\32\2\6\5\uffff\6\32\1\uffff\1\32\1\54\1"+
        "\74\2\32\1\uffff\2\62\4\32\2\103\1\54\1\uffff\2\32\2\107\2\32\1"+
        "\uffff\2\74\1\32\1\uffff\2\113\1\32\1\uffff\1\74";
    static final String DFA17_eofS =
        "\115\uffff";
    static final String DFA17_minS =
        "\1\11\2\uffff\1\46\1\156\1\116\1\uffff\1\162\1\122\1\75\1\74\1\75"+
        "\1\uffff\1\165\1\125\1\157\1\117\1\165\1\125\2\43\1\60\1\144\1\171"+
        "\1\141\3\uffff\1\43\1\144\1\104\2\43\5\uffff\1\154\1\114\1\165\1"+
        "\125\1\155\1\115\1\uffff\1\60\2\43\1\160\1\164\1\uffff\2\43\1\154"+
        "\1\114\1\156\1\116\3\43\1\uffff\1\145\1\141\2\43\1\164\1\124\1\uffff"+
        "\2\43\1\56\1\uffff\2\43\1\56\1\uffff\1\43";
    static final String DFA17_maxS =
        "\1\174\2\uffff\1\46\1\156\1\116\1\uffff\1\162\1\122\1\75\1\76\1"+
        "\75\1\uffff\1\165\1\125\1\157\1\117\1\165\1\125\2\172\1\71\1\144"+
        "\1\171\1\141\3\uffff\1\172\1\144\1\104\2\172\5\uffff\1\154\1\114"+
        "\1\165\1\125\1\155\1\115\1\uffff\1\71\2\172\1\160\1\164\1\uffff"+
        "\2\172\1\154\1\114\1\156\1\116\3\172\1\uffff\2\145\2\172\1\164\1"+
        "\124\1\uffff\2\172\1\56\1\uffff\3\172\1\uffff\1\172";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\4\5\uffff\1\12\14\uffff\1\16\1\21\1\22"+
        "\5\uffff\1\6\1\5\1\10\1\11\1\7\6\uffff\1\17\5\uffff\1\3\11\uffff"+
        "\1\20\6\uffff\1\15\3\uffff\1\13\3\uffff\1\14\1\uffff";
    static final String DFA17_specialS =
        "\115\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\33\2\uffff\1\33\22\uffff\1\33\1\14\1\uffff\1\32\2\uffff\1"+
            "\3\1\uffff\1\1\1\2\2\31\1\uffff\1\31\1\25\1\23\12\24\1\32\1"+
            "\uffff\1\11\1\12\1\13\1\32\1\uffff\1\5\1\32\1\20\12\32\1\16"+
            "\1\10\3\32\1\22\7\32\6\uffff\1\4\1\32\1\17\1\30\4\32\1\26\4"+
            "\32\1\15\1\7\3\32\1\21\1\27\6\32\1\uffff\1\6",
            "",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\41\1\44\1\43",
            "\1\43",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\1\55\1\32\12\24\1\32\4\uffff\1\32"+
            "\1\uffff\32\32\6\uffff\32\32",
            "\12\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\63",
            "\1\64",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "\12\73",
            "\1\32\2\uffff\1\32\7\uffff\2\32\12\56\1\32\4\uffff\1\32\1\uffff"+
            "\32\32\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\75",
            "\1\76",
            "",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\2\32\12\73\1\32\4\uffff\1\32\1\uffff"+
            "\32\32\6\uffff\32\32",
            "",
            "\1\104",
            "\1\106\3\uffff\1\105",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\110",
            "\1\111",
            "",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\112",
            "",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\32\2\uffff\1\32\7\uffff\15\32\4\uffff\1\32\1\uffff\32\32"+
            "\6\uffff\32\32",
            "\1\114\1\uffff\12\114\7\uffff\32\114\6\uffff\32\114",
            "",
            "\1\32\2\uffff\1\32\7\uffff\1\114\1\32\12\114\1\32\4\uffff\1"+
            "\32\1\uffff\32\114\6\uffff\32\114"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LPAREN | RPAREN | AND | OR | LT | LTE | GT | GTE | IS | NE | NULL | COUNT_FUNCTION | SUM_FUNCTION | ARITHMETIC_OPERATOR | NUMBER | FIELD | STRING | WS );";
        }
    }
 

}