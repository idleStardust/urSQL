// $ANTLR 3.5 /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g 2015-09-26 20:00:06

package urSQL.QueryProcessor;
import java.io.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int ALL=5;
	public static final int ALTER=6;
	public static final int AS=7;
	public static final int AVERAGE=8;
	public static final int BY=9;
	public static final int CHAR=10;
	public static final int CHARACTER=11;
	public static final int COLON=12;
	public static final int COMMENT=13;
	public static final int CONSTRAINT=14;
	public static final int COUNT=15;
	public static final int CREATE=16;
	public static final int DATABASE=17;
	public static final int DATABASES=18;
	public static final int DATETIME=19;
	public static final int DECIMAL=20;
	public static final int DELETE=21;
	public static final int DISPLAY=22;
	public static final int DROP=23;
	public static final int EQUALS=24;
	public static final int ESC_SEQ=25;
	public static final int EXPONENT=26;
	public static final int FLOAT=27;
	public static final int FOR=28;
	public static final int FOREIGN=29;
	public static final int FROM=30;
	public static final int GET=31;
	public static final int GREATER_EQUALS=32;
	public static final int GREATER_THAN=33;
	public static final int GROUP=34;
	public static final int HEX_DIGIT=35;
	public static final int ID=36;
	public static final int INDEX=37;
	public static final int INSERT=38;
	public static final int INT=39;
	public static final int INTEGER=40;
	public static final int INTO=41;
	public static final int IS=42;
	public static final int JOIN=43;
	public static final int JSON=44;
	public static final int KEY=45;
	public static final int LEFT_PAR=46;
	public static final int LESS_EQUALS=47;
	public static final int LESS_THAN=48;
	public static final int LIKE=49;
	public static final int LIST=50;
	public static final int MAX=51;
	public static final int MIN=52;
	public static final int NEWLINE=53;
	public static final int NOT=54;
	public static final int NULL=55;
	public static final int OCTAL_ESC=56;
	public static final int ON=57;
	public static final int PRIMARY=58;
	public static final int REFERENCES=59;
	public static final int RIGHT_PAR=60;
	public static final int SELECT=61;
	public static final int SET=62;
	public static final int START=63;
	public static final int STATUS=64;
	public static final int STOP=65;
	public static final int STRING=66;
	public static final int TABLE=67;
	public static final int UNICODE_ESC=68;
	public static final int UPDATE=69;
	public static final int VALUES=70;
	public static final int VARCHAR=71;
	public static final int WHERE=72;
	public static final int WS=73;
	public static final int XML=74;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public urSQLLexer() {} 
	public urSQLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public urSQLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g"; }

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:616:2: ( 'SELECT' | 'select' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='S') ) {
				alt1=1;
			}
			else if ( (LA1_0=='s') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:616:4: 'SELECT'
					{
					match("SELECT"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:617:4: 'select'
					{
					match("select"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "ALL"
	public final void mALL() throws RecognitionException {
		try {
			int _type = ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:621:2: ( '*' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:621:4: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALL"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:625:2: ( 'FROM' | 'from' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='F') ) {
				alt2=1;
			}
			else if ( (LA2_0=='f') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:625:4: 'FROM'
					{
					match("FROM"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:626:4: 'from'
					{
					match("from"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			int _type = JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:630:2: ( 'JOIN' | 'join' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='J') ) {
				alt3=1;
			}
			else if ( (LA3_0=='j') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:630:4: 'JOIN'
					{
					match("JOIN"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:631:4: 'join'
					{
					match("join"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:635:2: ( 'WHERE' | 'where' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='W') ) {
				alt4=1;
			}
			else if ( (LA4_0=='w') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:635:4: 'WHERE'
					{
					match("WHERE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:636:4: 'where'
					{
					match("where"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHERE"

	// $ANTLR start "GREATER_THAN"
	public final void mGREATER_THAN() throws RecognitionException {
		try {
			int _type = GREATER_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:640:2: ( '>' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:640:4: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_THAN"

	// $ANTLR start "GREATER_EQUALS"
	public final void mGREATER_EQUALS() throws RecognitionException {
		try {
			int _type = GREATER_EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:644:2: ( '>=' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:644:4: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_EQUALS"

	// $ANTLR start "LESS_THAN"
	public final void mLESS_THAN() throws RecognitionException {
		try {
			int _type = LESS_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:648:2: ( '<' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:648:4: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_THAN"

	// $ANTLR start "LESS_EQUALS"
	public final void mLESS_EQUALS() throws RecognitionException {
		try {
			int _type = LESS_EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:652:2: ( '<=' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:652:4: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_EQUALS"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:656:2: ( '=' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:656:4: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "LIKE"
	public final void mLIKE() throws RecognitionException {
		try {
			int _type = LIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:660:2: ( 'LIKE' | 'like' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='L') ) {
				alt5=1;
			}
			else if ( (LA5_0=='l') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:660:4: 'LIKE'
					{
					match("LIKE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:661:4: 'like'
					{
					match("like"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIKE"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:665:2: ( 'IS' | 'is' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='I') ) {
				alt6=1;
			}
			else if ( (LA6_0=='i') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:665:4: 'IS'
					{
					match("IS"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:666:4: 'is'
					{
					match("is"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:670:2: ( 'GROUP' | 'group' )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='G') ) {
				alt7=1;
			}
			else if ( (LA7_0=='g') ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:670:4: 'GROUP'
					{
					match("GROUP"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:671:4: 'group'
					{
					match("group"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GROUP"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:675:2: ( 'BY' | 'by' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='B') ) {
				alt8=1;
			}
			else if ( (LA8_0=='b') ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:675:4: 'BY'
					{
					match("BY"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:676:4: 'by'
					{
					match("by"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:680:2: ( 'FOR' | 'for' )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='F') ) {
				alt9=1;
			}
			else if ( (LA9_0=='f') ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:680:4: 'FOR'
					{
					match("FOR"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:681:4: 'for'
					{
					match("for"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "JSON"
	public final void mJSON() throws RecognitionException {
		try {
			int _type = JSON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:2: ( 'JSON' | 'json' )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='J') ) {
				alt10=1;
			}
			else if ( (LA10_0=='j') ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:4: 'JSON'
					{
					match("JSON"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:686:4: 'json'
					{
					match("json"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JSON"

	// $ANTLR start "XML"
	public final void mXML() throws RecognitionException {
		try {
			int _type = XML;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:690:2: ( 'XML' | 'xml' )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='X') ) {
				alt11=1;
			}
			else if ( (LA11_0=='x') ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:690:4: 'XML'
					{
					match("XML"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:691:4: 'xml'
					{
					match("xml"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XML"

	// $ANTLR start "COUNT"
	public final void mCOUNT() throws RecognitionException {
		try {
			int _type = COUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:695:2: ( 'COUNT' | 'count' )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='C') ) {
				alt12=1;
			}
			else if ( (LA12_0=='c') ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:695:4: 'COUNT'
					{
					match("COUNT"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:696:4: 'count'
					{
					match("count"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COUNT"

	// $ANTLR start "AVERAGE"
	public final void mAVERAGE() throws RecognitionException {
		try {
			int _type = AVERAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:700:2: ( 'AVERAGE' | 'average' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='A') ) {
				alt13=1;
			}
			else if ( (LA13_0=='a') ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:700:4: 'AVERAGE'
					{
					match("AVERAGE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:701:4: 'average'
					{
					match("average"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AVERAGE"

	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:705:2: ( 'MIN' | 'min' )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='M') ) {
				alt14=1;
			}
			else if ( (LA14_0=='m') ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:705:4: 'MIN'
					{
					match("MIN"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:706:4: 'min'
					{
					match("min"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIN"

	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:710:2: ( 'MAX' | 'max' )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='M') ) {
				alt15=1;
			}
			else if ( (LA15_0=='m') ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:710:4: 'MAX'
					{
					match("MAX"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:711:4: 'max'
					{
					match("max"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAX"

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:715:2: ( 'UPDATE' | 'update' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='U') ) {
				alt16=1;
			}
			else if ( (LA16_0=='u') ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:715:4: 'UPDATE'
					{
					match("UPDATE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:716:4: 'update'
					{
					match("update"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:720:2: ( 'DELETE' | 'delete' )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='D') ) {
				alt17=1;
			}
			else if ( (LA17_0=='d') ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:720:4: 'DELETE'
					{
					match("DELETE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:721:4: 'delete'
					{
					match("delete"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETE"

	// $ANTLR start "INSERT"
	public final void mINSERT() throws RecognitionException {
		try {
			int _type = INSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:725:2: ( 'INSERT' | 'insert' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='I') ) {
				alt18=1;
			}
			else if ( (LA18_0=='i') ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:725:4: 'INSERT'
					{
					match("INSERT"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:726:4: 'insert'
					{
					match("insert"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INSERT"

	// $ANTLR start "INTO"
	public final void mINTO() throws RecognitionException {
		try {
			int _type = INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:730:2: ( 'INTO' | 'into' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0=='I') ) {
				alt19=1;
			}
			else if ( (LA19_0=='i') ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:730:4: 'INTO'
					{
					match("INTO"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:731:4: 'into'
					{
					match("into"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTO"

	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:735:2: ( 'VALUES' | 'values' )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0=='V') ) {
				alt20=1;
			}
			else if ( (LA20_0=='v') ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:735:4: 'VALUES'
					{
					match("VALUES"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:736:4: 'values'
					{
					match("values"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUES"

	// $ANTLR start "CREATE"
	public final void mCREATE() throws RecognitionException {
		try {
			int _type = CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:740:2: ( 'CREATE' | 'create' )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0=='C') ) {
				alt21=1;
			}
			else if ( (LA21_0=='c') ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:740:4: 'CREATE'
					{
					match("CREATE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:741:4: 'create'
					{
					match("create"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CREATE"

	// $ANTLR start "DATABASE"
	public final void mDATABASE() throws RecognitionException {
		try {
			int _type = DATABASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:745:2: ( 'DATABASE' | 'database' )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0=='D') ) {
				alt22=1;
			}
			else if ( (LA22_0=='d') ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:745:4: 'DATABASE'
					{
					match("DATABASE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:746:4: 'database'
					{
					match("database"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATABASE"

	// $ANTLR start "DROP"
	public final void mDROP() throws RecognitionException {
		try {
			int _type = DROP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:2: ( 'DROP' | 'drop' )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0=='D') ) {
				alt23=1;
			}
			else if ( (LA23_0=='d') ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:4: 'DROP'
					{
					match("DROP"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:751:4: 'drop'
					{
					match("drop"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DROP"

	// $ANTLR start "LIST"
	public final void mLIST() throws RecognitionException {
		try {
			int _type = LIST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:755:2: ( 'LIST' | 'list' )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0=='L') ) {
				alt24=1;
			}
			else if ( (LA24_0=='l') ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:755:4: 'LIST'
					{
					match("LIST"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:756:4: 'list'
					{
					match("list"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIST"

	// $ANTLR start "DATABASES"
	public final void mDATABASES() throws RecognitionException {
		try {
			int _type = DATABASES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:760:2: ( 'DATABASES' | 'databases' )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0=='D') ) {
				alt25=1;
			}
			else if ( (LA25_0=='d') ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:760:4: 'DATABASES'
					{
					match("DATABASES"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:761:4: 'databases'
					{
					match("databases"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATABASES"

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:765:2: ( 'START' | 'start' )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0=='S') ) {
				alt26=1;
			}
			else if ( (LA26_0=='s') ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:765:4: 'START'
					{
					match("START"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:766:4: 'start'
					{
					match("start"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "GET"
	public final void mGET() throws RecognitionException {
		try {
			int _type = GET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:770:2: ( 'GET' | 'get' )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0=='G') ) {
				alt27=1;
			}
			else if ( (LA27_0=='g') ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:770:4: 'GET'
					{
					match("GET"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:771:4: 'get'
					{
					match("get"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GET"

	// $ANTLR start "STATUS"
	public final void mSTATUS() throws RecognitionException {
		try {
			int _type = STATUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:775:2: ( 'STATUS' | 'status' )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0=='S') ) {
				alt28=1;
			}
			else if ( (LA28_0=='s') ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:775:4: 'STATUS'
					{
					match("STATUS"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:776:4: 'status'
					{
					match("status"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STATUS"

	// $ANTLR start "STOP"
	public final void mSTOP() throws RecognitionException {
		try {
			int _type = STOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:780:2: ( 'STOP' | 'stop' )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0=='S') ) {
				alt29=1;
			}
			else if ( (LA29_0=='s') ) {
				alt29=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:780:4: 'STOP'
					{
					match("STOP"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:781:4: 'stop'
					{
					match("stop"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOP"

	// $ANTLR start "DISPLAY"
	public final void mDISPLAY() throws RecognitionException {
		try {
			int _type = DISPLAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:785:2: ( 'DISPLAY' | 'display' )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0=='D') ) {
				alt30=1;
			}
			else if ( (LA30_0=='d') ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:785:4: 'DISPLAY'
					{
					match("DISPLAY"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:786:4: 'display'
					{
					match("display"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISPLAY"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:790:2: ( '\\n' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:790:4: '\\n'
			{
			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:794:2: ( 'SET' | 'set' )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0=='S') ) {
				alt31=1;
			}
			else if ( (LA31_0=='s') ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:794:4: 'SET'
					{
					match("SET"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:795:4: 'set'
					{
					match("set"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "INDEX"
	public final void mINDEX() throws RecognitionException {
		try {
			int _type = INDEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:799:2: ( 'INDEX' | 'index' )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0=='I') ) {
				alt32=1;
			}
			else if ( (LA32_0=='i') ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:799:4: 'INDEX'
					{
					match("INDEX"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:800:4: 'index'
					{
					match("index"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INDEX"

	// $ANTLR start "ON"
	public final void mON() throws RecognitionException {
		try {
			int _type = ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:804:2: ( 'ON' | 'on' )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0=='O') ) {
				alt33=1;
			}
			else if ( (LA33_0=='o') ) {
				alt33=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:804:4: 'ON'
					{
					match("ON"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:805:4: 'on'
					{
					match("on"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ON"

	// $ANTLR start "TABLE"
	public final void mTABLE() throws RecognitionException {
		try {
			int _type = TABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:809:2: ( 'TABLE' | 'table' )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0=='T') ) {
				alt34=1;
			}
			else if ( (LA34_0=='t') ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:809:4: 'TABLE'
					{
					match("TABLE"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:810:4: 'table'
					{
					match("table"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLE"

	// $ANTLR start "ALTER"
	public final void mALTER() throws RecognitionException {
		try {
			int _type = ALTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:814:2: ( 'ALTER' | 'alter' )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0=='A') ) {
				alt35=1;
			}
			else if ( (LA35_0=='a') ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:814:4: 'ALTER'
					{
					match("ALTER"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:815:4: 'alter'
					{
					match("alter"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALTER"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:819:2: ( 'ADD' | 'add' )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0=='A') ) {
				alt36=1;
			}
			else if ( (LA36_0=='a') ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:819:4: 'ADD'
					{
					match("ADD"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:820:4: 'add'
					{
					match("add"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "CONSTRAINT"
	public final void mCONSTRAINT() throws RecognitionException {
		try {
			int _type = CONSTRAINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:824:2: ( 'CONSTRAINT' | 'constraint' )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0=='C') ) {
				alt37=1;
			}
			else if ( (LA37_0=='c') ) {
				alt37=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:824:4: 'CONSTRAINT'
					{
					match("CONSTRAINT"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:825:4: 'constraint'
					{
					match("constraint"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTRAINT"

	// $ANTLR start "FOREIGN"
	public final void mFOREIGN() throws RecognitionException {
		try {
			int _type = FOREIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:829:2: ( 'FOREIGN' | 'foreign' )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0=='F') ) {
				alt38=1;
			}
			else if ( (LA38_0=='f') ) {
				alt38=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:829:4: 'FOREIGN'
					{
					match("FOREIGN"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:830:4: 'foreign'
					{
					match("foreign"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOREIGN"

	// $ANTLR start "KEY"
	public final void mKEY() throws RecognitionException {
		try {
			int _type = KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:834:2: ( 'KEY' | 'key' )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0=='K') ) {
				alt39=1;
			}
			else if ( (LA39_0=='k') ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:834:4: 'KEY'
					{
					match("KEY"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:835:4: 'key'
					{
					match("key"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "KEY"

	// $ANTLR start "REFERENCES"
	public final void mREFERENCES() throws RecognitionException {
		try {
			int _type = REFERENCES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:839:2: ( 'REFERENCES' | 'references' )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0=='R') ) {
				alt40=1;
			}
			else if ( (LA40_0=='r') ) {
				alt40=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:839:4: 'REFERENCES'
					{
					match("REFERENCES"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:840:4: 'references'
					{
					match("references"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REFERENCES"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:844:2: ( 'AS' | 'as' )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0=='A') ) {
				alt41=1;
			}
			else if ( (LA41_0=='a') ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:844:4: 'AS'
					{
					match("AS"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:845:4: 'as'
					{
					match("as"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:849:2: ( 'INTEGER' | 'integer' )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0=='I') ) {
				alt42=1;
			}
			else if ( (LA42_0=='i') ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:849:4: 'INTEGER'
					{
					match("INTEGER"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:850:4: 'integer'
					{
					match("integer"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "DECIMAL"
	public final void mDECIMAL() throws RecognitionException {
		try {
			int _type = DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:854:2: ( 'DECIMAL' | 'decimal' )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0=='D') ) {
				alt43=1;
			}
			else if ( (LA43_0=='d') ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:854:4: 'DECIMAL'
					{
					match("DECIMAL"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:855:4: 'decimal'
					{
					match("decimal"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL"

	// $ANTLR start "LEFT_PAR"
	public final void mLEFT_PAR() throws RecognitionException {
		try {
			int _type = LEFT_PAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:859:2: ( '(' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:859:4: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_PAR"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:863:2: ( ',' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:863:4: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "RIGHT_PAR"
	public final void mRIGHT_PAR() throws RecognitionException {
		try {
			int _type = RIGHT_PAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:867:2: ( ')' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:867:4: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_PAR"

	// $ANTLR start "CHARACTER"
	public final void mCHARACTER() throws RecognitionException {
		try {
			int _type = CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:871:2: ( 'CHAR' | 'char' )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0=='C') ) {
				alt44=1;
			}
			else if ( (LA44_0=='c') ) {
				alt44=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:871:4: 'CHAR'
					{
					match("CHAR"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:872:4: 'char'
					{
					match("char"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARACTER"

	// $ANTLR start "VARCHAR"
	public final void mVARCHAR() throws RecognitionException {
		try {
			int _type = VARCHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:876:2: ( 'VARCHAR' | 'varchar' )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0=='V') ) {
				alt45=1;
			}
			else if ( (LA45_0=='v') ) {
				alt45=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:876:4: 'VARCHAR'
					{
					match("VARCHAR"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:877:4: 'varchar'
					{
					match("varchar"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARCHAR"

	// $ANTLR start "DATETIME"
	public final void mDATETIME() throws RecognitionException {
		try {
			int _type = DATETIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:881:2: ( 'DATETIME' | 'datetime' )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0=='D') ) {
				alt46=1;
			}
			else if ( (LA46_0=='d') ) {
				alt46=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:881:4: 'DATETIME'
					{
					match("DATETIME"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:882:4: 'datetime'
					{
					match("datetime"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATETIME"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:886:2: ( 'NULL' | 'null' )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0=='N') ) {
				alt47=1;
			}
			else if ( (LA47_0=='n') ) {
				alt47=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:886:4: 'NULL'
					{
					match("NULL"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:887:4: 'null'
					{
					match("null"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:891:2: ( 'NOT' | 'not' )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0=='N') ) {
				alt48=1;
			}
			else if ( (LA48_0=='n') ) {
				alt48=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:891:4: 'NOT'
					{
					match("NOT"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:892:4: 'not'
					{
					match("not"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "PRIMARY"
	public final void mPRIMARY() throws RecognitionException {
		try {
			int _type = PRIMARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:896:2: ( 'PRIMARY' | 'primary' )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0=='P') ) {
				alt49=1;
			}
			else if ( (LA49_0=='p') ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:896:4: 'PRIMARY'
					{
					match("PRIMARY"); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:897:4: 'primary'
					{
					match("primary"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIMARY"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:900:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:900:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:900:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop50:
			while (true) {
				int alt50=2;
				int LA50_0 = input.LA(1);
				if ( ((LA50_0 >= '0' && LA50_0 <= '9')||(LA50_0 >= 'A' && LA50_0 <= 'Z')||LA50_0=='_'||(LA50_0 >= 'a' && LA50_0 <= 'z')) ) {
					alt50=1;
				}

				switch (alt50) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop50;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:903:5: ( ( '0' .. '9' )+ )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:903:7: ( '0' .. '9' )+
			{
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:903:7: ( '0' .. '9' )+
			int cnt51=0;
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( ((LA51_0 >= '0' && LA51_0 <= '9')) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt51 >= 1 ) break loop51;
					EarlyExitException eee = new EarlyExitException(51, input);
					throw eee;
				}
				cnt51++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
			int alt58=3;
			alt58 = dfa58.predict(input);
			switch (alt58) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:9: ( '0' .. '9' )+
					int cnt52=0;
					loop52:
					while (true) {
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( ((LA52_0 >= '0' && LA52_0 <= '9')) ) {
							alt52=1;
						}

						switch (alt52) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt52 >= 1 ) break loop52;
							EarlyExitException eee = new EarlyExitException(52, input);
							throw eee;
						}
						cnt52++;
					}

					match('.'); 
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:25: ( '0' .. '9' )*
					loop53:
					while (true) {
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( ((LA53_0 >= '0' && LA53_0 <= '9')) ) {
							alt53=1;
						}

						switch (alt53) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop53;
						}
					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:37: ( EXPONENT )?
					int alt54=2;
					int LA54_0 = input.LA(1);
					if ( (LA54_0=='E'||LA54_0=='e') ) {
						alt54=1;
					}
					switch (alt54) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:907:37: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:908:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
					{
					match('.'); 
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:908:13: ( '0' .. '9' )+
					int cnt55=0;
					loop55:
					while (true) {
						int alt55=2;
						int LA55_0 = input.LA(1);
						if ( ((LA55_0 >= '0' && LA55_0 <= '9')) ) {
							alt55=1;
						}

						switch (alt55) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt55 >= 1 ) break loop55;
							EarlyExitException eee = new EarlyExitException(55, input);
							throw eee;
						}
						cnt55++;
					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:908:25: ( EXPONENT )?
					int alt56=2;
					int LA56_0 = input.LA(1);
					if ( (LA56_0=='E'||LA56_0=='e') ) {
						alt56=1;
					}
					switch (alt56) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:908:25: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:909:9: ( '0' .. '9' )+ EXPONENT
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:909:9: ( '0' .. '9' )+
					int cnt57=0;
					loop57:
					while (true) {
						int alt57=2;
						int LA57_0 = input.LA(1);
						if ( ((LA57_0 >= '0' && LA57_0 <= '9')) ) {
							alt57=1;
						}

						switch (alt57) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt57 >= 1 ) break loop57;
							EarlyExitException eee = new EarlyExitException(57, input);
							throw eee;
						}
						cnt57++;
					}

					mEXPONENT(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:913:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0=='/') ) {
				int LA62_1 = input.LA(2);
				if ( (LA62_1=='/') ) {
					alt62=1;
				}
				else if ( (LA62_1=='*') ) {
					alt62=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 62, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}

			switch (alt62) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:913:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:913:14: (~ ( '\\n' | '\\r' ) )*
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( ((LA59_0 >= '\u0000' && LA59_0 <= '\t')||(LA59_0 >= '\u000B' && LA59_0 <= '\f')||(LA59_0 >= '\u000E' && LA59_0 <= '\uFFFF')) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop59;
						}
					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:913:28: ( '\\r' )?
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0=='\r') ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:913:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:914:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:914:14: ( options {greedy=false; } : . )*
					loop61:
					while (true) {
						int alt61=2;
						int LA61_0 = input.LA(1);
						if ( (LA61_0=='*') ) {
							int LA61_1 = input.LA(2);
							if ( (LA61_1=='/') ) {
								alt61=2;
							}
							else if ( ((LA61_1 >= '\u0000' && LA61_1 <= '.')||(LA61_1 >= '0' && LA61_1 <= '\uFFFF')) ) {
								alt61=1;
							}

						}
						else if ( ((LA61_0 >= '\u0000' && LA61_0 <= ')')||(LA61_0 >= '+' && LA61_0 <= '\uFFFF')) ) {
							alt61=1;
						}

						switch (alt61) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:914:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop61;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:917:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:917:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:925:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:925:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:925:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop63:
			while (true) {
				int alt63=3;
				int LA63_0 = input.LA(1);
				if ( (LA63_0=='\\') ) {
					alt63=1;
				}
				else if ( ((LA63_0 >= '\u0000' && LA63_0 <= '!')||(LA63_0 >= '#' && LA63_0 <= '[')||(LA63_0 >= ']' && LA63_0 <= '\uFFFF')) ) {
					alt63=2;
				}

				switch (alt63) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:925:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:925:24: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop63;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:928:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:928:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:928:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0=='\\') ) {
				alt64=1;
			}
			else if ( ((LA64_0 >= '\u0000' && LA64_0 <= '&')||(LA64_0 >= '(' && LA64_0 <= '[')||(LA64_0 >= ']' && LA64_0 <= '\uFFFF')) ) {
				alt64=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}

			switch (alt64) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:928:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:928:25: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:933:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:933:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:933:22: ( '+' | '-' )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0=='+'||LA65_0=='-') ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:933:33: ( '0' .. '9' )+
			int cnt66=0;
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( ((LA66_0 >= '0' && LA66_0 <= '9')) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt66 >= 1 ) break loop66;
					EarlyExitException eee = new EarlyExitException(66, input);
					throw eee;
				}
				cnt66++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:936:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:940:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt67=3;
			int LA67_0 = input.LA(1);
			if ( (LA67_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt67=1;
					}
					break;
				case 'u':
					{
					alt67=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt67=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 67, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:940:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:941:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:942:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:947:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt68=3;
			int LA68_0 = input.LA(1);
			if ( (LA68_0=='\\') ) {
				int LA68_1 = input.LA(2);
				if ( ((LA68_1 >= '0' && LA68_1 <= '3')) ) {
					int LA68_2 = input.LA(3);
					if ( ((LA68_2 >= '0' && LA68_2 <= '7')) ) {
						int LA68_4 = input.LA(4);
						if ( ((LA68_4 >= '0' && LA68_4 <= '7')) ) {
							alt68=1;
						}

						else {
							alt68=2;
						}

					}

					else {
						alt68=3;
					}

				}
				else if ( ((LA68_1 >= '4' && LA68_1 <= '7')) ) {
					int LA68_3 = input.LA(3);
					if ( ((LA68_3 >= '0' && LA68_3 <= '7')) ) {
						alt68=2;
					}

					else {
						alt68=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 68, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:947:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:948:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:949:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:954:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:954:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:8: ( SELECT | ALL | FROM | JOIN | WHERE | GREATER_THAN | GREATER_EQUALS | LESS_THAN | LESS_EQUALS | EQUALS | LIKE | IS | GROUP | BY | FOR | JSON | XML | COUNT | AVERAGE | MIN | MAX | UPDATE | DELETE | INSERT | INTO | VALUES | CREATE | DATABASE | DROP | LIST | DATABASES | START | GET | STATUS | STOP | DISPLAY | NEWLINE | SET | INDEX | ON | TABLE | ALTER | ADD | CONSTRAINT | FOREIGN | KEY | REFERENCES | AS | INTEGER | DECIMAL | LEFT_PAR | COLON | RIGHT_PAR | CHARACTER | VARCHAR | DATETIME | NULL | NOT | PRIMARY | ID | INT | FLOAT | COMMENT | WS | STRING | CHAR )
		int alt69=66;
		alt69 = dfa69.predict(input);
		switch (alt69) {
			case 1 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:10: SELECT
				{
				mSELECT(); 

				}
				break;
			case 2 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:17: ALL
				{
				mALL(); 

				}
				break;
			case 3 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:21: FROM
				{
				mFROM(); 

				}
				break;
			case 4 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:26: JOIN
				{
				mJOIN(); 

				}
				break;
			case 5 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:31: WHERE
				{
				mWHERE(); 

				}
				break;
			case 6 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:37: GREATER_THAN
				{
				mGREATER_THAN(); 

				}
				break;
			case 7 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:50: GREATER_EQUALS
				{
				mGREATER_EQUALS(); 

				}
				break;
			case 8 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:65: LESS_THAN
				{
				mLESS_THAN(); 

				}
				break;
			case 9 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:75: LESS_EQUALS
				{
				mLESS_EQUALS(); 

				}
				break;
			case 10 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:87: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 11 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:94: LIKE
				{
				mLIKE(); 

				}
				break;
			case 12 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:99: IS
				{
				mIS(); 

				}
				break;
			case 13 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:102: GROUP
				{
				mGROUP(); 

				}
				break;
			case 14 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:108: BY
				{
				mBY(); 

				}
				break;
			case 15 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:111: FOR
				{
				mFOR(); 

				}
				break;
			case 16 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:115: JSON
				{
				mJSON(); 

				}
				break;
			case 17 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:120: XML
				{
				mXML(); 

				}
				break;
			case 18 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:124: COUNT
				{
				mCOUNT(); 

				}
				break;
			case 19 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:130: AVERAGE
				{
				mAVERAGE(); 

				}
				break;
			case 20 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:138: MIN
				{
				mMIN(); 

				}
				break;
			case 21 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:142: MAX
				{
				mMAX(); 

				}
				break;
			case 22 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:146: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 23 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:153: DELETE
				{
				mDELETE(); 

				}
				break;
			case 24 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:160: INSERT
				{
				mINSERT(); 

				}
				break;
			case 25 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:167: INTO
				{
				mINTO(); 

				}
				break;
			case 26 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:172: VALUES
				{
				mVALUES(); 

				}
				break;
			case 27 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:179: CREATE
				{
				mCREATE(); 

				}
				break;
			case 28 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:186: DATABASE
				{
				mDATABASE(); 

				}
				break;
			case 29 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:195: DROP
				{
				mDROP(); 

				}
				break;
			case 30 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:200: LIST
				{
				mLIST(); 

				}
				break;
			case 31 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:205: DATABASES
				{
				mDATABASES(); 

				}
				break;
			case 32 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:215: START
				{
				mSTART(); 

				}
				break;
			case 33 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:221: GET
				{
				mGET(); 

				}
				break;
			case 34 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:225: STATUS
				{
				mSTATUS(); 

				}
				break;
			case 35 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:232: STOP
				{
				mSTOP(); 

				}
				break;
			case 36 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:237: DISPLAY
				{
				mDISPLAY(); 

				}
				break;
			case 37 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:245: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 38 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:253: SET
				{
				mSET(); 

				}
				break;
			case 39 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:257: INDEX
				{
				mINDEX(); 

				}
				break;
			case 40 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:263: ON
				{
				mON(); 

				}
				break;
			case 41 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:266: TABLE
				{
				mTABLE(); 

				}
				break;
			case 42 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:272: ALTER
				{
				mALTER(); 

				}
				break;
			case 43 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:278: ADD
				{
				mADD(); 

				}
				break;
			case 44 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:282: CONSTRAINT
				{
				mCONSTRAINT(); 

				}
				break;
			case 45 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:293: FOREIGN
				{
				mFOREIGN(); 

				}
				break;
			case 46 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:301: KEY
				{
				mKEY(); 

				}
				break;
			case 47 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:305: REFERENCES
				{
				mREFERENCES(); 

				}
				break;
			case 48 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:316: AS
				{
				mAS(); 

				}
				break;
			case 49 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:319: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 50 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:327: DECIMAL
				{
				mDECIMAL(); 

				}
				break;
			case 51 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:335: LEFT_PAR
				{
				mLEFT_PAR(); 

				}
				break;
			case 52 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:344: COLON
				{
				mCOLON(); 

				}
				break;
			case 53 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:350: RIGHT_PAR
				{
				mRIGHT_PAR(); 

				}
				break;
			case 54 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:360: CHARACTER
				{
				mCHARACTER(); 

				}
				break;
			case 55 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:370: VARCHAR
				{
				mVARCHAR(); 

				}
				break;
			case 56 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:378: DATETIME
				{
				mDATETIME(); 

				}
				break;
			case 57 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:387: NULL
				{
				mNULL(); 

				}
				break;
			case 58 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:392: NOT
				{
				mNOT(); 

				}
				break;
			case 59 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:396: PRIMARY
				{
				mPRIMARY(); 

				}
				break;
			case 60 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:404: ID
				{
				mID(); 

				}
				break;
			case 61 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:407: INT
				{
				mINT(); 

				}
				break;
			case 62 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:411: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 63 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:417: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 64 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:425: WS
				{
				mWS(); 

				}
				break;
			case 65 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:428: STRING
				{
				mSTRING(); 

				}
				break;
			case 66 :
				// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:1:435: CHAR
				{
				mCHAR(); 

				}
				break;

		}
	}


	protected DFA58 dfa58 = new DFA58(this);
	protected DFA69 dfa69 = new DFA69(this);
	static final String DFA58_eotS =
		"\5\uffff";
	static final String DFA58_eofS =
		"\5\uffff";
	static final String DFA58_minS =
		"\2\56\3\uffff";
	static final String DFA58_maxS =
		"\1\71\1\145\3\uffff";
	static final String DFA58_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA58_specialS =
		"\5\uffff}>";
	static final String[] DFA58_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
			"",
			"",
			""
	};

	static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
	static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
	static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
	static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
	static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
	static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
	static final short[][] DFA58_transition;

	static {
		int numStates = DFA58_transitionS.length;
		DFA58_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
		}
	}

	protected class DFA58 extends DFA {

		public DFA58(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 58;
			this.eot = DFA58_eot;
			this.eof = DFA58_eof;
			this.min = DFA58_min;
			this.max = DFA58_max;
			this.accept = DFA58_accept;
			this.special = DFA58_special;
			this.transition = DFA58_transition;
		}
		@Override
		public String getDescription() {
			return "906:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
		}
	}

	static final String DFA69_eotS =
		"\1\uffff\2\63\1\uffff\6\63\1\111\1\113\1\uffff\26\63\1\uffff\10\63\3\uffff"+
		"\4\63\1\uffff\1\u0087\5\uffff\16\63\4\uffff\2\63\1\u009e\1\63\1\u009e"+
		"\5\63\2\u00a9\13\63\1\u00b7\3\63\1\u00b7\20\63\1\uffff\2\u00cf\14\63\1"+
		"\uffff\1\63\1\u00dd\3\63\1\u00dd\3\63\1\u00e7\1\63\1\u00e7\12\63\1\uffff"+
		"\7\63\1\u00fd\1\63\1\u00fd\1\uffff\2\u00ff\12\63\1\u010a\1\uffff\2\63"+
		"\1\u010a\1\u010d\1\u010e\1\u010d\1\u010e\20\63\1\uffff\2\63\2\u0123\3"+
		"\63\1\u0127\1\63\1\u0127\3\63\1\uffff\2\63\1\u012e\3\63\1\u012e\1\u0132"+
		"\1\63\1\uffff\1\u0132\1\63\1\u0135\1\u0136\1\u0135\1\u0136\2\63\1\u0139"+
		"\1\u013a\1\u0139\1\u013a\1\63\1\u013c\3\63\1\u013c\3\63\1\uffff\1\63\1"+
		"\uffff\3\63\1\u0147\3\63\1\u0147\2\63\1\uffff\2\63\2\uffff\6\63\1\u0155"+
		"\5\63\1\u0155\7\63\1\uffff\2\63\1\u0164\1\uffff\1\u0164\3\63\1\u0168\1"+
		"\63\1\uffff\1\63\1\u0168\1\63\1\uffff\2\63\2\uffff\2\u016e\2\uffff\1\63"+
		"\1\uffff\1\63\1\u0171\2\63\1\u0171\2\u0174\1\u0175\2\63\1\uffff\1\u0175"+
		"\3\63\1\u017b\1\63\1\u017b\6\63\1\uffff\12\63\2\u018d\2\63\1\uffff\2\63"+
		"\1\u0192\1\uffff\1\u0193\1\u0192\1\u0193\2\63\1\uffff\1\u0196\1\63\1\uffff"+
		"\1\u0196\1\63\2\uffff\1\63\1\u019a\1\63\1\u019a\1\63\1\uffff\1\63\2\u019e"+
		"\1\u019f\4\63\1\u019f\4\63\1\u01a8\1\63\1\u01a8\1\63\1\uffff\4\63\2\uffff"+
		"\2\u01af\1\uffff\2\u01b0\1\63\1\uffff\1\63\2\u01b3\2\uffff\1\u01b4\2\63"+
		"\1\u01b7\1\u01b4\2\63\1\u01b7\1\uffff\2\u01ba\2\63\2\u01bd\2\uffff\2\63"+
		"\2\uffff\1\u01c1\1\u01c2\1\uffff\1\u01c1\1\u01c2\1\uffff\2\63\1\uffff"+
		"\2\63\1\u01c8\2\uffff\1\u01c8\2\63\2\u01cb\1\uffff\2\u01cc\2\uffff";
	static final String DFA69_eofS =
		"\u01cd\uffff";
	static final String DFA69_minS =
		"\1\11\1\105\1\145\1\uffff\1\117\1\157\1\117\1\157\1\110\1\150\2\75\1\uffff"+
		"\1\111\1\151\1\116\1\156\1\105\1\145\1\131\1\171\1\115\1\155\1\110\1\150"+
		"\1\104\1\144\1\101\1\141\1\120\1\160\1\101\1\141\1\101\1\141\1\uffff\1"+
		"\116\1\156\1\101\1\141\1\105\1\145\1\105\1\145\3\uffff\1\117\1\157\1\122"+
		"\1\162\1\uffff\1\56\5\uffff\1\114\1\101\1\154\1\141\1\117\1\122\1\157"+
		"\1\162\1\111\1\117\1\151\1\157\1\105\1\145\4\uffff\1\113\1\153\1\60\1"+
		"\104\1\60\1\144\1\117\1\124\1\157\1\164\2\60\1\114\1\154\1\116\1\105\1"+
		"\101\1\156\1\145\1\141\1\105\1\124\1\104\1\60\1\145\1\164\1\144\1\60\1"+
		"\116\1\130\1\156\1\170\1\104\1\144\1\103\1\124\1\117\1\123\1\143\1\164"+
		"\1\157\1\163\1\114\1\154\1\uffff\2\60\1\102\1\142\1\131\1\171\1\106\1"+
		"\146\1\114\1\124\1\154\1\164\1\111\1\151\1\uffff\1\105\1\60\1\122\1\120"+
		"\1\145\1\60\1\162\1\160\1\115\1\60\1\155\1\60\2\116\2\156\1\122\1\162"+
		"\1\105\1\124\1\145\1\164\1\uffff\3\105\3\145\1\125\1\60\1\165\1\60\1\uffff"+
		"\2\60\1\116\1\123\1\101\1\122\1\156\1\163\1\141\1\162\1\122\1\105\1\60"+
		"\1\uffff\1\162\1\145\5\60\1\101\1\141\1\105\1\111\1\101\2\120\1\145\1"+
		"\151\1\141\2\160\1\125\1\103\1\165\1\143\1\uffff\1\114\1\154\2\60\1\105"+
		"\1\145\1\114\1\60\1\154\1\60\1\115\1\155\1\103\1\uffff\1\124\1\125\1\60"+
		"\1\143\1\164\1\165\2\60\1\111\1\uffff\1\60\1\151\4\60\1\105\1\145\4\60"+
		"\1\122\1\60\1\107\1\130\1\162\1\60\1\147\1\170\1\120\1\uffff\1\160\1\uffff"+
		"\3\124\1\60\3\164\1\60\1\101\1\122\1\uffff\1\141\1\162\2\uffff\1\124\1"+
		"\164\1\124\1\115\1\102\1\124\1\60\1\114\1\164\1\155\1\142\1\164\1\60\1"+
		"\154\1\105\1\110\1\145\1\150\1\105\1\145\1\uffff\1\122\1\162\1\60\1\uffff"+
		"\1\60\1\101\1\141\1\124\1\60\1\123\1\uffff\1\164\1\60\1\163\1\uffff\1"+
		"\107\1\147\2\uffff\2\60\2\uffff\1\124\1\uffff\1\105\1\60\1\164\1\145\4"+
		"\60\1\122\1\105\1\uffff\1\60\1\162\1\145\1\107\1\60\1\147\1\60\1\105\1"+
		"\145\1\105\2\101\1\111\1\uffff\1\101\1\145\2\141\1\151\1\141\1\123\1\101"+
		"\1\163\1\141\2\60\1\105\1\145\1\uffff\1\122\1\162\1\60\1\uffff\3\60\1"+
		"\116\1\156\1\uffff\1\60\1\122\1\uffff\1\60\1\162\2\uffff\1\101\1\60\1"+
		"\141\1\60\1\105\1\uffff\1\145\3\60\1\114\1\123\1\115\1\131\1\60\1\154"+
		"\1\163\1\155\1\171\1\60\1\122\1\60\1\162\1\uffff\1\116\1\156\1\131\1\171"+
		"\2\uffff\2\60\1\uffff\2\60\1\111\1\uffff\1\151\2\60\2\uffff\1\60\2\105"+
		"\2\60\2\145\1\60\1\uffff\2\60\1\103\1\143\2\60\2\uffff\1\116\1\156\2\uffff"+
		"\2\60\1\uffff\2\60\1\uffff\1\105\1\145\1\uffff\1\124\1\164\1\60\2\uffff"+
		"\1\60\1\123\1\163\2\60\1\uffff\2\60\2\uffff";
	static final String DFA69_maxS =
		"\1\172\1\124\1\164\1\uffff\1\122\1\162\1\123\1\163\1\110\1\150\2\75\1"+
		"\uffff\1\111\1\151\1\123\1\163\1\122\1\162\1\131\1\171\1\115\1\155\1\122"+
		"\1\162\1\126\1\166\1\111\1\151\1\120\1\160\1\122\1\162\1\101\1\141\1\uffff"+
		"\1\116\1\156\1\101\1\141\1\105\1\145\1\105\1\145\3\uffff\1\125\1\165\1"+
		"\122\1\162\1\uffff\1\145\5\uffff\1\124\1\117\1\164\1\157\1\117\1\122\1"+
		"\157\1\162\1\111\1\117\1\151\1\157\1\105\1\145\4\uffff\1\123\1\163\1\172"+
		"\1\124\1\172\1\164\1\117\1\124\1\157\1\164\2\172\1\114\1\154\1\125\1\105"+
		"\1\101\1\165\1\145\1\141\1\105\1\124\1\104\1\172\1\145\1\164\1\144\1\172"+
		"\1\116\1\130\1\156\1\170\1\104\1\144\1\114\1\124\1\117\1\123\1\154\1\164"+
		"\1\157\1\163\1\122\1\162\1\uffff\2\172\1\102\1\142\1\131\1\171\1\106\1"+
		"\146\1\114\1\124\1\154\1\164\1\111\1\151\1\uffff\1\105\1\172\1\124\1\120"+
		"\1\145\1\172\1\164\1\160\1\115\1\172\1\155\1\172\2\116\2\156\1\122\1\162"+
		"\1\105\1\124\1\145\1\164\1\uffff\1\105\1\117\1\105\1\145\1\157\1\145\1"+
		"\125\1\172\1\165\1\172\1\uffff\2\172\1\116\1\123\1\101\1\122\1\156\1\163"+
		"\1\141\1\162\1\122\1\105\1\172\1\uffff\1\162\1\145\5\172\1\101\1\141\1"+
		"\105\1\111\1\105\2\120\1\145\1\151\1\145\2\160\1\125\1\103\1\165\1\143"+
		"\1\uffff\1\114\1\154\2\172\1\105\1\145\1\114\1\172\1\154\1\172\1\115\1"+
		"\155\1\103\1\uffff\1\124\1\125\1\172\1\143\1\164\1\165\2\172\1\111\1\uffff"+
		"\1\172\1\151\4\172\1\105\1\145\4\172\1\122\1\172\1\107\1\130\1\162\1\172"+
		"\1\147\1\170\1\120\1\uffff\1\160\1\uffff\3\124\1\172\3\164\1\172\1\101"+
		"\1\122\1\uffff\1\141\1\162\2\uffff\1\124\1\164\1\124\1\115\1\102\1\124"+
		"\1\172\1\114\1\164\1\155\1\142\1\164\1\172\1\154\1\105\1\110\1\145\1\150"+
		"\1\105\1\145\1\uffff\1\122\1\162\1\172\1\uffff\1\172\1\101\1\141\1\124"+
		"\1\172\1\123\1\uffff\1\164\1\172\1\163\1\uffff\1\107\1\147\2\uffff\2\172"+
		"\2\uffff\1\124\1\uffff\1\105\1\172\1\164\1\145\4\172\1\122\1\105\1\uffff"+
		"\1\172\1\162\1\145\1\107\1\172\1\147\1\172\1\105\1\145\1\105\2\101\1\111"+
		"\1\uffff\1\101\1\145\2\141\1\151\1\141\1\123\1\101\1\163\1\141\2\172\1"+
		"\105\1\145\1\uffff\1\122\1\162\1\172\1\uffff\3\172\1\116\1\156\1\uffff"+
		"\1\172\1\122\1\uffff\1\172\1\162\2\uffff\1\101\1\172\1\141\1\172\1\105"+
		"\1\uffff\1\145\3\172\1\114\1\123\1\115\1\131\1\172\1\154\1\163\1\155\1"+
		"\171\1\172\1\122\1\172\1\162\1\uffff\1\116\1\156\1\131\1\171\2\uffff\2"+
		"\172\1\uffff\2\172\1\111\1\uffff\1\151\2\172\2\uffff\1\172\2\105\2\172"+
		"\2\145\1\172\1\uffff\2\172\1\103\1\143\2\172\2\uffff\1\116\1\156\2\uffff"+
		"\2\172\1\uffff\2\172\1\uffff\1\105\1\145\1\uffff\1\124\1\164\1\172\2\uffff"+
		"\1\172\1\123\1\163\2\172\1\uffff\2\172\2\uffff";
	static final String DFA69_acceptS =
		"\3\uffff\1\2\10\uffff\1\12\26\uffff\1\45\10\uffff\1\63\1\64\1\65\4\uffff"+
		"\1\74\1\uffff\1\76\1\77\1\100\1\101\1\102\16\uffff\1\7\1\6\1\11\1\10\54"+
		"\uffff\1\45\16\uffff\1\75\26\uffff\1\14\12\uffff\1\16\15\uffff\1\60\27"+
		"\uffff\1\50\15\uffff\1\46\11\uffff\1\17\25\uffff\1\41\1\uffff\1\21\12"+
		"\uffff\1\53\2\uffff\1\24\1\25\24\uffff\1\56\3\uffff\1\72\6\uffff\1\43"+
		"\3\uffff\1\3\2\uffff\1\4\1\20\2\uffff\1\13\1\36\1\uffff\1\31\12\uffff"+
		"\1\66\15\uffff\1\35\16\uffff\1\71\3\uffff\1\40\5\uffff\1\5\2\uffff\1\47"+
		"\2\uffff\1\15\1\22\5\uffff\1\52\21\uffff\1\51\4\uffff\1\1\1\42\2\uffff"+
		"\1\30\3\uffff\1\33\3\uffff\1\26\1\27\10\uffff\1\32\6\uffff\1\55\1\61\2"+
		"\uffff\1\23\1\62\2\uffff\1\44\2\uffff\1\67\2\uffff\1\73\3\uffff\1\34\1"+
		"\70\5\uffff\1\37\2\uffff\1\54\1\57";
	static final String DFA69_specialS =
		"\u01cd\uffff}>";
	static final String[] DFA69_transitionS = {
			"\1\67\1\43\2\uffff\1\67\22\uffff\1\67\1\uffff\1\70\4\uffff\1\71\1\54"+
			"\1\56\1\3\1\uffff\1\55\1\uffff\1\65\1\66\12\64\2\uffff\1\13\1\14\1\12"+
			"\2\uffff\1\31\1\23\1\27\1\37\1\63\1\4\1\21\1\63\1\17\1\6\1\50\1\15\1"+
			"\33\1\57\1\44\1\61\1\63\1\52\1\1\1\46\1\35\1\41\1\10\1\25\2\63\4\uffff"+
			"\1\63\1\uffff\1\32\1\24\1\30\1\40\1\63\1\5\1\22\1\63\1\20\1\7\1\51\1"+
			"\16\1\34\1\60\1\45\1\62\1\63\1\53\1\2\1\47\1\36\1\42\1\11\1\26\2\63",
			"\1\72\16\uffff\1\73",
			"\1\74\16\uffff\1\75",
			"",
			"\1\77\2\uffff\1\76",
			"\1\101\2\uffff\1\100",
			"\1\102\3\uffff\1\103",
			"\1\104\3\uffff\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\112",
			"",
			"\1\114",
			"\1\115",
			"\1\117\4\uffff\1\116",
			"\1\121\4\uffff\1\120",
			"\1\123\14\uffff\1\122",
			"\1\125\14\uffff\1\124",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\134\6\uffff\1\132\2\uffff\1\133",
			"\1\137\6\uffff\1\135\2\uffff\1\136",
			"\1\142\7\uffff\1\141\6\uffff\1\143\2\uffff\1\140",
			"\1\146\7\uffff\1\145\6\uffff\1\147\2\uffff\1\144",
			"\1\151\7\uffff\1\150",
			"\1\153\7\uffff\1\152",
			"\1\154",
			"\1\155",
			"\1\157\3\uffff\1\156\3\uffff\1\161\10\uffff\1\160",
			"\1\163\3\uffff\1\162\3\uffff\1\165\10\uffff\1\164",
			"\1\166",
			"\1\167",
			"",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"",
			"",
			"",
			"\1\u0082\5\uffff\1\u0081",
			"\1\u0084\5\uffff\1\u0083",
			"\1\u0085",
			"\1\u0086",
			"",
			"\1\65\1\uffff\12\64\13\uffff\1\65\37\uffff\1\65",
			"",
			"",
			"",
			"",
			"",
			"\1\u0088\7\uffff\1\u0089",
			"\1\u008a\15\uffff\1\u008b",
			"\1\u008c\7\uffff\1\u008d",
			"\1\u008e\15\uffff\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"",
			"",
			"",
			"",
			"\1\u009a\7\uffff\1\u009b",
			"\1\u009c\7\uffff\1\u009d",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00a1\16\uffff\1\u009f\1\u00a0",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00a4\16\uffff\1\u00a2\1\u00a3",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ad\6\uffff\1\u00ac",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b1\6\uffff\1\u00b0",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\1\u00b6",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"\1\u00c2\10\uffff\1\u00c1",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"\1\u00c7\10\uffff\1\u00c6",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb\5\uffff\1\u00cc",
			"\1\u00cd\5\uffff\1\u00ce",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00d0",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"\1\u00db",
			"",
			"\1\u00dc",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00de\1\uffff\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00e2\1\uffff\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\12\63\7\uffff\4\63\1\u00e6\25\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00e8",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\4\63\1\u00e9\25\63",
			"\1\u00ea",
			"\1\u00eb",
			"\1\u00ec",
			"\1\u00ed",
			"\1\u00ee",
			"\1\u00ef",
			"\1\u00f0",
			"\1\u00f1",
			"\1\u00f2",
			"\1\u00f3",
			"",
			"\1\u00f4",
			"\1\u00f6\11\uffff\1\u00f5",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00fa\11\uffff\1\u00f9",
			"\1\u00fb",
			"\1\u00fc",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u00fe",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"\1\u0108",
			"\1\u0109",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\1\u010b",
			"\1\u010c",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113\3\uffff\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\u0119\3\uffff\1\u011a",
			"\1\u011b",
			"\1\u011c",
			"\1\u011d",
			"\1\u011e",
			"\1\u011f",
			"\1\u0120",
			"",
			"\1\u0121",
			"\1\u0122",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0124",
			"\1\u0125",
			"\1\u0126",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0128",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0129",
			"\1\u012a",
			"\1\u012b",
			"",
			"\1\u012c",
			"\1\u012d",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0133",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0134",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0137",
			"\1\u0138",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u013b",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u013d",
			"\1\u013e",
			"\1\u013f",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"",
			"\1\u0143",
			"",
			"\1\u0144",
			"\1\u0145",
			"\1\u0146",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0148",
			"\1\u0149",
			"\1\u014a",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u014b",
			"\1\u014c",
			"",
			"\1\u014d",
			"\1\u014e",
			"",
			"",
			"\1\u014f",
			"\1\u0150",
			"\1\u0151",
			"\1\u0152",
			"\1\u0153",
			"\1\u0154",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0156",
			"\1\u0157",
			"\1\u0158",
			"\1\u0159",
			"\1\u015a",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u015b",
			"\1\u015c",
			"\1\u015d",
			"\1\u015e",
			"\1\u015f",
			"\1\u0160",
			"\1\u0161",
			"",
			"\1\u0162",
			"\1\u0163",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0165",
			"\1\u0166",
			"\1\u0167",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0169",
			"",
			"\1\u016a",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u016b",
			"",
			"\1\u016c",
			"\1\u016d",
			"",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"",
			"\1\u016f",
			"",
			"\1\u0170",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0172",
			"\1\u0173",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0176",
			"\1\u0177",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0178",
			"\1\u0179",
			"\1\u017a",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u017c",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u017d",
			"\1\u017e",
			"\1\u017f",
			"\1\u0180",
			"\1\u0181",
			"\1\u0182",
			"",
			"\1\u0183",
			"\1\u0184",
			"\1\u0185",
			"\1\u0186",
			"\1\u0187",
			"\1\u0188",
			"\1\u0189",
			"\1\u018a",
			"\1\u018b",
			"\1\u018c",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u018e",
			"\1\u018f",
			"",
			"\1\u0190",
			"\1\u0191",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0194",
			"\1\u0195",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0197",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u0198",
			"",
			"",
			"\1\u0199",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u019b",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u019c",
			"",
			"\1\u019d",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01a0",
			"\1\u01a1",
			"\1\u01a2",
			"\1\u01a3",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01a4",
			"\1\u01a5",
			"\1\u01a6",
			"\1\u01a7",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01a9",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01aa",
			"",
			"\1\u01ab",
			"\1\u01ac",
			"\1\u01ad",
			"\1\u01ae",
			"",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01b1",
			"",
			"\1\u01b2",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01b5",
			"\1\u01b6",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01b8",
			"\1\u01b9",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01bb",
			"\1\u01bc",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"",
			"\1\u01be",
			"\1\u01bf",
			"",
			"",
			"\12\63\7\uffff\22\63\1\u01c0\7\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\22\63\1\u01c3\7\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\1\u01c4",
			"\1\u01c5",
			"",
			"\1\u01c6",
			"\1\u01c7",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\1\u01c9",
			"\1\u01ca",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
			"",
			""
	};

	static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
	static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
	static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
	static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
	static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
	static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
	static final short[][] DFA69_transition;

	static {
		int numStates = DFA69_transitionS.length;
		DFA69_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
		}
	}

	protected class DFA69 extends DFA {

		public DFA69(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 69;
			this.eot = DFA69_eot;
			this.eof = DFA69_eof;
			this.min = DFA69_min;
			this.max = DFA69_max;
			this.accept = DFA69_accept;
			this.special = DFA69_special;
			this.transition = DFA69_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( SELECT | ALL | FROM | JOIN | WHERE | GREATER_THAN | GREATER_EQUALS | LESS_THAN | LESS_EQUALS | EQUALS | LIKE | IS | GROUP | BY | FOR | JSON | XML | COUNT | AVERAGE | MIN | MAX | UPDATE | DELETE | INSERT | INTO | VALUES | CREATE | DATABASE | DROP | LIST | DATABASES | START | GET | STATUS | STOP | DISPLAY | NEWLINE | SET | INDEX | ON | TABLE | ALTER | ADD | CONSTRAINT | FOREIGN | KEY | REFERENCES | AS | INTEGER | DECIMAL | LEFT_PAR | COLON | RIGHT_PAR | CHARACTER | VARCHAR | DATETIME | NULL | NOT | PRIMARY | ID | INT | FLOAT | COMMENT | WS | STRING | CHAR );";
		}
	}

}
