// $ANTLR 3.5 /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g 2015-09-28 09:48:22

	package urSQL.QueryProcessor;
	import java.io.*;
	import java.util.Vector;
	import java.util.Collections;
import java.util.LinkedList;

import urSQL.API.ResultSet;
import urSQL.RuntimeDatabaseProcessor.Rutine.*;
import urSQL.SystemCatalog.SystemCatalog;
import urSQL.RuntimeDatabaseProcessor.Components.*;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ALL", "ALTER", "AS", "AVERAGE", 
		"BY", "CHAR", "CHARACTER", "COLON", "COMMENT", "CONSTRAINT", "COUNT", 
		"CREATE", "DATABASE", "DATABASES", "DATETIME", "DECIMAL", "DELETE", "DISPLAY", 
		"DROP", "EQUALS", "ESC_SEQ", "EXPONENT", "FLOAT", "FOR", "FOREIGN", "FROM", 
		"GET", "GREATER_EQUALS", "GREATER_THAN", "GROUP", "HEX_DIGIT", "ID", "INDEX", 
		"INSERT", "INT", "INTEGER", "INTO", "IS", "JOIN", "JSON", "KEY", "LEFT_PAR", 
		"LESS_EQUALS", "LESS_THAN", "LIKE", "LIST", "MAX", "MIN", "NEWLINE", "NOT", 
		"NULL", "OCTAL_ESC", "ON", "PRIMARY", "REFERENCES", "RIGHT_PAR", "SELECT", 
		"SET", "START", "STATUS", "STOP", "STRING", "TABLE", "UNICODE_ESC", "UPDATE", 
		"VALUES", "VARCHAR", "WHERE", "WS", "XML"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public urSQLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public urSQLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return urSQLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g"; }


		private ResultSet rs;
		private boolean executed = true;
		private Routine routine;
		
		public Routine getRoutine() 
		{
			return this.routine;
		}
		
		public ResultSet getResultSet()
		{
			return this.rs;
		}
		
		public boolean getStatus()
		{
			return this.executed;
		}

		public void displayRecognitionError(String[] tokenNames, RecognitionException e) 
		{
			this.executed = false;
			String hdr = getErrorHeader(e);
			String[] splt = hdr.split("\\s");
			String tmp = splt[1];
			char c = tmp.charAt(0);
			String lineNumber = "";
			lineNumber += Character.toString(c);
			c = tmp.charAt(1);
			if (!Character.toString(c).equals(":")) 
			{
				lineNumber += Character.toString(c);
			}
			System.out.println("Error 42000: Syntax error or access rule violation in line " + lineNumber);
		}
		
		public void delete(String tableName, Vector<String> condition) 
		{
			ComponentFrom from = new ComponentFrom(tableName, (new LinkedList<String>()));
			ComponentWhere where = null;
			if (!condition.isEmpty()) {
				where = new ComponentWhere(condition.get(2), condition.get(0), condition.get(1));
			} else {
				where = new ComponentWhere("", "*", "");
			}
			this.routine = new RoutineDML("DELETE");
			this.routine.getComponents().add(from); 
			this.routine.getComponents().add(where);
		}
		
		public void update(String tableName, String columna, String value, Vector<String> condition) 
		{
			ComponentFrom from = new ComponentFrom(tableName, (new LinkedList<String>()));
			ComponentWhere where = null;
			if (!condition.isEmpty()) {
				where = new ComponentWhere(condition.get(2), condition.get(0), condition.get(1));
			} else {
				where = new ComponentWhere("", "*", "");
			}
			ComponentSet set = new ComponentSet(columna, value);
			this.routine = new RoutineDML("SET");
			this.routine.getComponents().add(from); 
			this.routine.getComponents().add(where);
			this.routine.getComponents().add(set);
		}
		
		public void insert(String tableName, Vector<String> columnas, Vector<String> valores) 
		{
			ComponentFrom from = new ComponentFrom(tableName, (new LinkedList<String>()));
			LinkedList<String> cols = new LinkedList<String>();
			LinkedList<String> vals = new LinkedList<String>();
			for (int i = 0; i < columnas.size(); i++) 
			{
				cols.add(columnas.get(i));
				vals.add(valores.get(i));
			}
			ComponentInsert ins = new ComponentInsert(cols, vals);
			this.routine = new RoutineDML("INSERT");
			this.routine.getComponents().add(from); 
			this.routine.getComponents().add(ins);
		}
		
		public void select(Vector<String> columnas, Vector<String> tablas, Vector<String> cond, Vector<String> group, String xml) 
		{
			ComponentFrom from = null;
			if (tablas.size() > 1) 
			{
				LinkedList<String> tabs = new LinkedList<String>();
				for (int i = 1; i < tablas.size(); i++) 
				{
					tabs.add(tablas.get(i));
				}
				from = new ComponentFrom(tablas.get(0), tabs);
			} 
			else 
			{
				from = new ComponentFrom(tablas.get(0), (new LinkedList<String>()));
			}
			this.routine = new RoutineDML("SELECT");
			this.routine.getComponents().add(from);
			ComponentWhere where = null;
			if (!cond.isEmpty()) {
				where = new ComponentWhere(cond.get(2), cond.get(0), cond.get(1));
			} else {
				where = new ComponentWhere("", "*", "");
			}
			this.routine.getComponents().add(where);
			if (!group.isEmpty()) {
				LinkedList<String> cols = new LinkedList<String>();
				for (int i = 0; i < group.size(); i++) 
				{
					cols.add(group.get(i));
				}
				ComponentGroup g = new ComponentGroup(cols);
				this.routine.getComponents().add(g);
			}
			ComponentFor f = new ComponentFor(xml);
			this.routine.getComponents().add(f);
			for (int i = 0; i < columnas.size(); i+=2) 
			{
				//ComponentAggregateFunction ag = new ComponentAggregateFunction(columnas.get(i), columnas.get(i + 1));
				//this.routine.getComponents().add(ag);
			}
		}
		
		public void dropTable(String tableName) {
			ComponentDropTable dt = new ComponentDropTable(tableName);
			this.routine = new RoutineDLL("DROP_TABLE");
			this.routine.getComponents().add(dt);
		}
		
		public void createTable(String table, Vector<Vector<String>> col, String pk) {
			ComponentCreateTable ct = new ComponentCreateTable(table, col, pk);
			this.routine = new RoutineDLL("CREATE_TABLE");
			this.routine.getComponents().add(ct);
		}
		
		public void dropDB(String name) {
			ComponentDropDatabase dd = new ComponentDropDatabase(name);
			this.routine = new RoutineDLL("DROP_DATABASE");
			this.routine.getComponents().add(dd);
		}

		public void createDB(String name) 
		{
			ComponentNewDatabase cd = new ComponentNewDatabase(name);
			this.routine = new RoutineDLL("NEW_DATABASE");
			this.routine.getComponents().add(cd);
		}
		
		public void setDB(String name) {
			ComponentSetDatabase sd = new ComponentSetDatabase(name);
			this.routine = new RoutineDLL("SET_DATABASE");
			this.routine.getComponents().add(sd);
		}
		
		public void listDB() {
			ComponentListDatabases ld = new ComponentListDatabases();
			this.routine = new RoutineDLL("LIST_DATABASES");
			this.routine.getComponents().add(ld);
		}


	protected static class programa_scope {
		Vector<String> type_null;
		Vector<String> column;
		Vector<String> values;
		Vector<String> condition;
		Vector<String> select_columns;
		Vector<String> select_tables;
		Vector<String> select_group;
		Vector<Vector<String>> columns;
		String tmp;
		PrintWriter writer;
	}
	protected Stack<programa_scope> programa_stack = new Stack<programa_scope>();


	// $ANTLR start "programa"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:188:1: programa : ( clp_commands | ddl_commands | dml_commands );
	public final void programa()   {
		programa_stack.push(new programa_scope());

			programa_stack.peek().type_null = new Vector<String>();
			programa_stack.peek().column = new Vector<String>();
			programa_stack.peek().values = new Vector<String>();
			programa_stack.peek().condition = new Vector<String>();
			programa_stack.peek().select_columns = new Vector<String>();
			programa_stack.peek().select_tables = new Vector<String>();
			programa_stack.peek().select_group = new Vector<String>();
			programa_stack.peek().columns = new Vector<Vector<String>>();
			programa_stack.peek().tmp = "";
			try
			{
				programa_stack.peek().writer = new PrintWriter("plan_ejecucion.txt", "UTF-8");
			} catch (IOException e) 
			{
			};

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:223:2: ( clp_commands | ddl_commands | dml_commands )
			int alt1=3;
			switch ( input.LA(1) ) {
			case CREATE:
				{
				int LA1_1 = input.LA(2);
				if ( (LA1_1==DATABASE) ) {
					alt1=1;
				}
				else if ( (LA1_1==INDEX||LA1_1==TABLE) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DROP:
				{
				int LA1_2 = input.LA(2);
				if ( (LA1_2==DATABASE) ) {
					alt1=1;
				}
				else if ( (LA1_2==TABLE) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DISPLAY:
			case GET:
			case LIST:
			case START:
			case STOP:
				{
				alt1=1;
				}
				break;
			case EOF:
				{
				alt1=1;
				}
				break;
			case ALTER:
			case SET:
				{
				alt1=2;
				}
				break;
			case DELETE:
			case INSERT:
			case SELECT:
			case UPDATE:
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
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:223:4: clp_commands
					{
					pushFollow(FOLLOW_clp_commands_in_programa66);
					clp_commands();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:224:4: ddl_commands
					{
					pushFollow(FOLLOW_ddl_commands_in_programa71);
					ddl_commands();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:225:4: dml_commands
					{
					pushFollow(FOLLOW_dml_commands_in_programa76);
					dml_commands();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			programa_stack.pop();
		}
	}
	// $ANTLR end "programa"



	// $ANTLR start "dml_commands"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:229:1: dml_commands : ( ( select | update | delete | insert ) ( clp_commands | ddl_commands | dml_commands ) |);
	public final void dml_commands()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:230:2: ( ( select | update | delete | insert ) ( clp_commands | ddl_commands | dml_commands ) |)
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==DELETE||LA4_0==INSERT||LA4_0==SELECT||LA4_0==UPDATE) ) {
				alt4=1;
			}
			else if ( (LA4_0==EOF) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:230:4: ( select | update | delete | insert ) ( clp_commands | ddl_commands | dml_commands )
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:230:4: ( select | update | delete | insert )
					int alt2=4;
					switch ( input.LA(1) ) {
					case SELECT:
						{
						alt2=1;
						}
						break;
					case UPDATE:
						{
						alt2=2;
						}
						break;
					case DELETE:
						{
						alt2=3;
						}
						break;
					case INSERT:
						{
						alt2=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}
					switch (alt2) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:230:6: select
							{
							pushFollow(FOLLOW_select_in_dml_commands93);
							select();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:231:4: update
							{
							pushFollow(FOLLOW_update_in_dml_commands98);
							update();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:232:4: delete
							{
							pushFollow(FOLLOW_delete_in_dml_commands103);
							delete();
							state._fsp--;

							}
							break;
						case 4 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:233:4: insert
							{
							pushFollow(FOLLOW_insert_in_dml_commands108);
							insert();
							state._fsp--;

							}
							break;

					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:233:13: ( clp_commands | ddl_commands | dml_commands )
					int alt3=3;
					switch ( input.LA(1) ) {
					case CREATE:
						{
						int LA3_1 = input.LA(2);
						if ( (LA3_1==DATABASE) ) {
							alt3=1;
						}
						else if ( (LA3_1==INDEX||LA3_1==TABLE) ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 3, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DROP:
						{
						int LA3_2 = input.LA(2);
						if ( (LA3_2==DATABASE) ) {
							alt3=1;
						}
						else if ( (LA3_2==TABLE) ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 3, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DISPLAY:
					case GET:
					case LIST:
					case START:
					case STOP:
						{
						alt3=1;
						}
						break;
					case EOF:
						{
						alt3=1;
						}
						break;
					case ALTER:
					case SET:
						{
						alt3=2;
						}
						break;
					case DELETE:
					case INSERT:
					case SELECT:
					case UPDATE:
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
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:233:15: clp_commands
							{
							pushFollow(FOLLOW_clp_commands_in_dml_commands114);
							clp_commands();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:234:4: ddl_commands
							{
							pushFollow(FOLLOW_ddl_commands_in_dml_commands119);
							ddl_commands();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:235:4: dml_commands
							{
							pushFollow(FOLLOW_dml_commands_in_dml_commands124);
							dml_commands();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:237:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dml_commands"



	// $ANTLR start "select"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:239:1: select : SELECT ( ALL | col_list ) ( NEWLINE )? from ( NEWLINE )* ;
	public final void select()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:240:2: ( SELECT ( ALL | col_list ) ( NEWLINE )? from ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:240:4: SELECT ( ALL | col_list ) ( NEWLINE )? from ( NEWLINE )*
			{
			match(input,SELECT,FOLLOW_SELECT_in_select141); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:240:11: ( ALL | col_list )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ALL) ) {
				alt5=1;
			}
			else if ( (LA5_0==AVERAGE||LA5_0==COUNT||LA5_0==FROM||LA5_0==ID||(LA5_0 >= MAX && LA5_0 <= NEWLINE)) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:240:13: ALL
					{
					match(input,ALL,FOLLOW_ALL_in_select145); 
					 programa_stack.peek().select_columns.add("69"); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:241:4: col_list
					{
					pushFollow(FOLLOW_col_list_in_select152);
					col_list();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:241:15: ( NEWLINE )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==NEWLINE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:241:15: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_select156); 
					}
					break;

			}

			pushFollow(FOLLOW_from_in_select159);
			from();
			state._fsp--;

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:241:29: ( NEWLINE )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==NEWLINE) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:241:29: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_select161); 
					}
					break;

				default :
					break loop7;
				}
			}


					if (!programa_stack.peek().tmp.equals("JSON") && !programa_stack.peek().tmp.equals("XML")) {
						programa_stack.peek().tmp = "-1";
					}
					System.out.println("Select query...");
					System.out.print("Columns: ");
					System.out.println(programa_stack.peek().select_columns);
					System.out.print("Tables: ");
					System.out.println(programa_stack.peek().select_tables);
					System.out.print("Condition: ");
					System.out.println(programa_stack.peek().condition);
					System.out.print("Grouping by: ");
					System.out.println(programa_stack.peek().column);
					System.out.print("XML/JSON: ");
					System.out.println(programa_stack.peek().tmp);
					
			this.select(programa_stack.peek().select_columns, programa_stack.peek().select_tables, programa_stack.peek().condition, programa_stack.peek().column, programa_stack.peek().tmp);
					
					if (programa_stack.peek().select_tables.size() > 1) {
						programa_stack.peek().writer.print("Obtain tables ");
						for (int i = 0; i < programa_stack.peek().select_tables.size(); i++) {
							if (i == programa_stack.peek().select_tables.size() - 1) {
								programa_stack.peek().writer.print(programa_stack.peek().select_tables.get(i));
							} else {
								programa_stack.peek().writer.print(programa_stack.peek().select_tables.get(i) + ", ");
							}
							
						}
						programa_stack.peek().writer.println("\nCreate joins");
					} else  {
						programa_stack.peek().writer.println("Obtain table " + programa_stack.peek().select_tables.get(0));
					}
					
					if (!programa_stack.peek().condition.isEmpty()) {
						programa_stack.peek().writer.println("Apply where condition");
					}
					
					if (!programa_stack.peek().column.isEmpty()) {
						if (programa_stack.peek().column.size() > 1) {
							programa_stack.peek().writer.print("Group by ");
							for (int i = 0; i < programa_stack.peek().column.size(); i++) {
								if (i == programa_stack.peek().column.size() - 1) {
									programa_stack.peek().writer.print(programa_stack.peek().column.get(i));
								} else {
									programa_stack.peek().writer.print(programa_stack.peek().column.get(i) + ", ");
								}
							
							}
							programa_stack.peek().writer.println("");
						} else  {
							programa_stack.peek().writer.println("Group by " + programa_stack.peek().column.get(0));
						}	
					}
					
					if (programa_stack.peek().select_columns.size() > 1) {
						programa_stack.peek().writer.print("Display columns ");
						for (int i = 1; i < programa_stack.peek().select_columns.size(); i += 2) {
							programa_stack.peek().writer.print(programa_stack.peek().select_columns.get(i));
						}
					} else {
						programa_stack.peek().writer.println("Display all columns");
					}
					
					if (programa_stack.peek().tmp.equals("0")) {
						programa_stack.peek().writer.println("Return in JSON");
					} else if (programa_stack.peek().tmp.equals("1")) {
						programa_stack.peek().writer.println("Return in XML");
					} else {
						programa_stack.peek().writer.println("");
					}
					programa_stack.peek().writer.close();
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "select"



	// $ANTLR start "col_list"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:316:1: col_list : ( ( ID | agg_funct ) col_list |);
	public final void col_list()   {
		Token ID1=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:317:2: ( ( ID | agg_funct ) col_list |)
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==AVERAGE||LA9_0==COUNT||LA9_0==ID||(LA9_0 >= MAX && LA9_0 <= MIN)) ) {
				alt9=1;
			}
			else if ( (LA9_0==FROM||LA9_0==NEWLINE) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:317:4: ( ID | agg_funct ) col_list
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:317:4: ( ID | agg_funct )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==ID) ) {
						alt8=1;
					}
					else if ( (LA8_0==AVERAGE||LA8_0==COUNT||(LA8_0 >= MAX && LA8_0 <= MIN)) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:317:6: ID
							{
							ID1=(Token)match(input,ID,FOLLOW_ID_in_col_list179); 
							 
								 	programa_stack.peek().select_columns.add("-1"); 
								 	programa_stack.peek().select_columns.add((ID1!=null?ID1.getText():null));
								 
							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:322:4: agg_funct
							{
							pushFollow(FOLLOW_agg_funct_in_col_list190);
							agg_funct();
							state._fsp--;

							}
							break;

					}

					pushFollow(FOLLOW_col_list_in_col_list194);
					col_list();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:324:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "col_list"



	// $ANTLR start "from"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:326:1: from : FROM ( ID | join_st ) ( NEWLINE )? ( where )? ( NEWLINE )? ( group )? ( NEWLINE )? ( for_JSON_XML )? ;
	public final void from()   {
		Token ID2=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:327:2: ( FROM ( ID | join_st ) ( NEWLINE )? ( where )? ( NEWLINE )? ( group )? ( NEWLINE )? ( for_JSON_XML )? )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:327:4: FROM ( ID | join_st ) ( NEWLINE )? ( where )? ( NEWLINE )? ( group )? ( NEWLINE )? ( for_JSON_XML )?
			{
			match(input,FROM,FOLLOW_FROM_in_from211); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:327:9: ( ID | join_st )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ID) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==JOIN) ) {
					alt10=2;
				}
				else if ( (LA10_1==EOF||LA10_1==ALTER||LA10_1==CREATE||(LA10_1 >= DELETE && LA10_1 <= DROP)||LA10_1==FOR||LA10_1==GET||LA10_1==GROUP||LA10_1==INSERT||LA10_1==LIST||LA10_1==NEWLINE||(LA10_1 >= SELECT && LA10_1 <= START)||LA10_1==STOP||LA10_1==UPDATE||LA10_1==WHERE) ) {
					alt10=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:327:11: ID
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_from215); 
					 programa_stack.peek().select_tables.add((ID2!=null?ID2.getText():null)); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:4: join_st
					{
					pushFollow(FOLLOW_join_st_in_from222);
					join_st();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:14: ( NEWLINE )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==NEWLINE) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:14: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_from226); 
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:23: ( where )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==WHERE) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:23: where
					{
					pushFollow(FOLLOW_where_in_from229);
					where();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:30: ( NEWLINE )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==NEWLINE) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:30: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_from232); 
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:39: ( group )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==GROUP) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:39: group
					{
					pushFollow(FOLLOW_group_in_from235);
					group();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:46: ( NEWLINE )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==NEWLINE) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:46: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_from238); 
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:55: ( for_JSON_XML )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FOR) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:328:55: for_JSON_XML
					{
					pushFollow(FOLLOW_for_JSON_XML_in_from241);
					for_JSON_XML();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "from"



	// $ANTLR start "join_st"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:331:1: join_st : table1= ID JOIN table2= ID join_st_aux ;
	public final void join_st()   {
		Token table1=null;
		Token table2=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:332:2: (table1= ID JOIN table2= ID join_st_aux )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:332:4: table1= ID JOIN table2= ID join_st_aux
			{
			table1=(Token)match(input,ID,FOLLOW_ID_in_join_st258); 
			match(input,JOIN,FOLLOW_JOIN_in_join_st260); 
			table2=(Token)match(input,ID,FOLLOW_ID_in_join_st266); 
			pushFollow(FOLLOW_join_st_aux_in_join_st268);
			join_st_aux();
			state._fsp--;


				 	programa_stack.peek().select_tables.add((table1!=null?table1.getText():null));
				 	programa_stack.peek().select_tables.add((table2!=null?table2.getText():null));
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "join_st"



	// $ANTLR start "join_st_aux"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:339:1: join_st_aux : ( JOIN ID join_st_aux |);
	public final void join_st_aux()   {
		Token ID3=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:340:2: ( JOIN ID join_st_aux |)
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==JOIN) ) {
				alt17=1;
			}
			else if ( (LA17_0==EOF||LA17_0==ALTER||LA17_0==CREATE||(LA17_0 >= DELETE && LA17_0 <= DROP)||LA17_0==FOR||LA17_0==GET||LA17_0==GROUP||LA17_0==INSERT||LA17_0==LIST||LA17_0==NEWLINE||(LA17_0 >= SELECT && LA17_0 <= START)||LA17_0==STOP||LA17_0==UPDATE||LA17_0==WHERE) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:340:4: JOIN ID join_st_aux
					{
					match(input,JOIN,FOLLOW_JOIN_in_join_st_aux284); 
					ID3=(Token)match(input,ID,FOLLOW_ID_in_join_st_aux286); 
					pushFollow(FOLLOW_join_st_aux_in_join_st_aux288);
					join_st_aux();
					state._fsp--;

					 programa_stack.peek().select_tables.add((ID3!=null?ID3.getText():null)); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:342:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "join_st_aux"



	// $ANTLR start "where"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:344:1: where : WHERE where_st ;
	public final void where()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:345:2: ( WHERE where_st )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:345:4: WHERE where_st
			{
			match(input,WHERE,FOLLOW_WHERE_in_where307); 
			pushFollow(FOLLOW_where_st_in_where309);
			where_st();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "where"



	// $ANTLR start "where_st"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:348:1: where_st : ( ID comp_op value[\"1\"] | ID null_op );
	public final void where_st()   {
		Token ID4=null;
		Token ID5=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:349:2: ( ID comp_op value[\"1\"] | ID null_op )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==ID) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==EQUALS||(LA18_1 >= GREATER_EQUALS && LA18_1 <= GREATER_THAN)||(LA18_1 >= LESS_EQUALS && LA18_1 <= LIKE)||LA18_1==NOT) ) {
					alt18=1;
				}
				else if ( (LA18_1==IS) ) {
					alt18=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:349:4: ID comp_op value[\"1\"]
					{
					ID4=(Token)match(input,ID,FOLLOW_ID_in_where_st321); 
					pushFollow(FOLLOW_comp_op_in_where_st323);
					comp_op();
					state._fsp--;

					pushFollow(FOLLOW_value_in_where_st325);
					value("1");
					state._fsp--;

					 programa_stack.peek().condition.add((ID4!=null?ID4.getText():null)); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:350:4: ID null_op
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_where_st333); 
					pushFollow(FOLLOW_null_op_in_where_st335);
					null_op();
					state._fsp--;

					 programa_stack.peek().condition.add((ID5!=null?ID5.getText():null)); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "where_st"



	// $ANTLR start "comp_op"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:353:1: comp_op : ( GREATER_THAN | GREATER_EQUALS | LESS_THAN | LESS_EQUALS | EQUALS | LIKE | NOT );
	public final void comp_op()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:354:2: ( GREATER_THAN | GREATER_EQUALS | LESS_THAN | LESS_EQUALS | EQUALS | LIKE | NOT )
			int alt19=7;
			switch ( input.LA(1) ) {
			case GREATER_THAN:
				{
				alt19=1;
				}
				break;
			case GREATER_EQUALS:
				{
				alt19=2;
				}
				break;
			case LESS_THAN:
				{
				alt19=3;
				}
				break;
			case LESS_EQUALS:
				{
				alt19=4;
				}
				break;
			case EQUALS:
				{
				alt19=5;
				}
				break;
			case LIKE:
				{
				alt19=6;
				}
				break;
			case NOT:
				{
				alt19=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:354:4: GREATER_THAN
					{
					match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_comp_op349); 
					 programa_stack.peek().condition.add(">"); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:355:4: GREATER_EQUALS
					{
					match(input,GREATER_EQUALS,FOLLOW_GREATER_EQUALS_in_comp_op356); 
					 programa_stack.peek().condition.add(">"); 
					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:356:4: LESS_THAN
					{
					match(input,LESS_THAN,FOLLOW_LESS_THAN_in_comp_op363); 
					 programa_stack.peek().condition.add("<"); 
					}
					break;
				case 4 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:357:4: LESS_EQUALS
					{
					match(input,LESS_EQUALS,FOLLOW_LESS_EQUALS_in_comp_op370); 
					 programa_stack.peek().condition.add("<"); 
					}
					break;
				case 5 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:358:4: EQUALS
					{
					match(input,EQUALS,FOLLOW_EQUALS_in_comp_op377); 
					 programa_stack.peek().condition.add("="); 
					}
					break;
				case 6 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:359:4: LIKE
					{
					match(input,LIKE,FOLLOW_LIKE_in_comp_op384); 
					 programa_stack.peek().condition.add("LIKE"); 
					}
					break;
				case 7 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:360:4: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_comp_op391); 
					 programa_stack.peek().condition.add("NOT"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "comp_op"



	// $ANTLR start "null_op"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:363:1: null_op : IS ( NULL | NOT NULL ) ;
	public final void null_op()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:364:2: ( IS ( NULL | NOT NULL ) )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:364:4: IS ( NULL | NOT NULL )
			{
			match(input,IS,FOLLOW_IS_in_null_op405); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:364:7: ( NULL | NOT NULL )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==NULL) ) {
				alt20=1;
			}
			else if ( (LA20_0==NOT) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:364:9: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_null_op409); 
					 
						 	programa_stack.peek().condition.add("IS NULL");
						 	programa_stack.peek().condition.add("-1");
						 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:369:4: NOT NULL
					{
					match(input,NOT,FOLLOW_NOT_in_null_op420); 
					match(input,NULL,FOLLOW_NULL_in_null_op422); 
					 
						 	programa_stack.peek().condition.add("IS NOT NULL");
						 	programa_stack.peek().condition.add("-1");
						 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "null_op"



	// $ANTLR start "group"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:376:1: group : GROUP BY cols ;
	public final void group()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:377:2: ( GROUP BY cols )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:377:4: GROUP BY cols
			{
			match(input,GROUP,FOLLOW_GROUP_in_group442); 
			match(input,BY,FOLLOW_BY_in_group444); 
			pushFollow(FOLLOW_cols_in_group446);
			cols();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "group"



	// $ANTLR start "cols"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:380:1: cols : ( ID cols |);
	public final void cols()   {
		Token ID6=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:381:2: ( ID cols |)
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==ID) ) {
				alt21=1;
			}
			else if ( (LA21_0==EOF||LA21_0==ALTER||LA21_0==CREATE||(LA21_0 >= DELETE && LA21_0 <= DROP)||LA21_0==FOR||LA21_0==GET||LA21_0==INSERT||LA21_0==LIST||LA21_0==NEWLINE||(LA21_0 >= RIGHT_PAR && LA21_0 <= START)||LA21_0==STOP||LA21_0==UPDATE) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:381:4: ID cols
					{
					ID6=(Token)match(input,ID,FOLLOW_ID_in_cols458); 
					pushFollow(FOLLOW_cols_in_cols460);
					cols();
					state._fsp--;

					 programa_stack.peek().column.add((ID6!=null?ID6.getText():null)); 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:383:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cols"



	// $ANTLR start "for_JSON_XML"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:385:1: for_JSON_XML : FOR ( JSON | XML ) ;
	public final void for_JSON_XML()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:386:2: ( FOR ( JSON | XML ) )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:386:4: FOR ( JSON | XML )
			{
			match(input,FOR,FOLLOW_FOR_in_for_JSON_XML477); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:386:8: ( JSON | XML )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==JSON) ) {
				alt22=1;
			}
			else if ( (LA22_0==XML) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:386:10: JSON
					{
					match(input,JSON,FOLLOW_JSON_in_for_JSON_XML481); 
					 programa_stack.peek().tmp = "JSON"; 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:387:4: XML
					{
					match(input,XML,FOLLOW_XML_in_for_JSON_XML488); 
					 programa_stack.peek().tmp = "XML"; 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "for_JSON_XML"



	// $ANTLR start "agg_funct"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:390:1: agg_funct : ( COUNT | AVERAGE | MIN | MAX ) LEFT_PAR ID RIGHT_PAR ;
	public final void agg_funct()   {
		Token ID7=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:391:2: ( ( COUNT | AVERAGE | MIN | MAX ) LEFT_PAR ID RIGHT_PAR )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:391:4: ( COUNT | AVERAGE | MIN | MAX ) LEFT_PAR ID RIGHT_PAR
			{
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:391:4: ( COUNT | AVERAGE | MIN | MAX )
			int alt23=4;
			switch ( input.LA(1) ) {
			case COUNT:
				{
				alt23=1;
				}
				break;
			case AVERAGE:
				{
				alt23=2;
				}
				break;
			case MIN:
				{
				alt23=3;
				}
				break;
			case MAX:
				{
				alt23=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:391:6: COUNT
					{
					match(input,COUNT,FOLLOW_COUNT_in_agg_funct506); 
					 programa_stack.peek().select_columns.add("0");  
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:392:4: AVERAGE
					{
					match(input,AVERAGE,FOLLOW_AVERAGE_in_agg_funct513); 
					 programa_stack.peek().select_columns.add("1");  
					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:393:4: MIN
					{
					match(input,MIN,FOLLOW_MIN_in_agg_funct520); 
					 programa_stack.peek().select_columns.add("2");  
					}
					break;
				case 4 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:394:4: MAX
					{
					match(input,MAX,FOLLOW_MAX_in_agg_funct527); 
					 programa_stack.peek().select_columns.add("3");  
					}
					break;

			}

			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_agg_funct535); 
			ID7=(Token)match(input,ID,FOLLOW_ID_in_agg_funct537); 
			 programa_stack.peek().select_columns.add((ID7!=null?ID7.getText():null));  
			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_agg_funct541); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "agg_funct"



	// $ANTLR start "update"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:398:1: update : UPDATE table= ID ( NEWLINE )? SET column= ID EQUALS value[\"2\"] ( NEWLINE )? ( where )? ( NEWLINE )* ;
	public final void update()   {
		Token table=null;
		Token column=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:2: ( UPDATE table= ID ( NEWLINE )? SET column= ID EQUALS value[\"2\"] ( NEWLINE )? ( where )? ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:4: UPDATE table= ID ( NEWLINE )? SET column= ID EQUALS value[\"2\"] ( NEWLINE )? ( where )? ( NEWLINE )*
			{
			match(input,UPDATE,FOLLOW_UPDATE_in_update553); 
			table=(Token)match(input,ID,FOLLOW_ID_in_update559); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:22: ( NEWLINE )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==NEWLINE) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:22: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_update561); 
					}
					break;

			}

			match(input,SET,FOLLOW_SET_in_update564); 
			column=(Token)match(input,ID,FOLLOW_ID_in_update570); 
			match(input,EQUALS,FOLLOW_EQUALS_in_update572); 
			pushFollow(FOLLOW_value_in_update574);
			value("2");
			state._fsp--;

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:65: ( NEWLINE )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==NEWLINE) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:65: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_update577); 
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:74: ( where )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==WHERE) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:74: where
					{
					pushFollow(FOLLOW_where_in_update580);
					where();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:81: ( NEWLINE )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==NEWLINE) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:399:81: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_update583); 
					}
					break;

				default :
					break loop27;
				}
			}


				 	System.out.println("Updating column " + (column!=null?column.getText():null) + " from table " + (table!=null?table.getText():null) + "...");
				 	System.out.println("New value: " + programa_stack.peek().tmp);
				 	System.out.println("Condition:");
				 	System.out.println(programa_stack.peek().condition);
				 	
				 	this.update((table!=null?table.getText():null), (column!=null?column.getText():null), programa_stack.peek().tmp, programa_stack.peek().condition);
				 	
				 	programa_stack.peek().writer.println("Obtain table " + (table!=null?table.getText():null));
				 	programa_stack.peek().writer.println("Iterate table on column " + (column!=null?column.getText():null));
				 	programa_stack.peek().writer.print("If condition is true, update column value with " + programa_stack.peek().tmp);
				 	programa_stack.peek().writer.close();
				 	
				 	programa_stack.peek().condition.clear();
				 	programa_stack.peek().values.clear();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "update"



	// $ANTLR start "delete"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:418:1: delete : DELETE ( NEWLINE )? FROM ID ( NEWLINE )? ( where )? ( NEWLINE )* ;
	public final void delete()   {
		Token ID8=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:2: ( DELETE ( NEWLINE )? FROM ID ( NEWLINE )? ( where )? ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:4: DELETE ( NEWLINE )? FROM ID ( NEWLINE )? ( where )? ( NEWLINE )*
			{
			match(input,DELETE,FOLLOW_DELETE_in_delete600); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:11: ( NEWLINE )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==NEWLINE) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:11: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_delete602); 
					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_delete605); 
			ID8=(Token)match(input,ID,FOLLOW_ID_in_delete607); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:28: ( NEWLINE )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==NEWLINE) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:28: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_delete609); 
					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:37: ( where )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==WHERE) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:37: where
					{
					pushFollow(FOLLOW_where_in_delete612);
					where();
					state._fsp--;

					}
					break;

			}

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:44: ( NEWLINE )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==NEWLINE) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:419:44: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_delete615); 
					}
					break;

				default :
					break loop31;
				}
			}


				 	System.out.println("Delete from table " + (ID8!=null?ID8.getText():null));
				 	System.out.print("Condition: ");
				 	System.out.println(programa_stack.peek().condition);
				 	
				 	this.delete((ID8!=null?ID8.getText():null), programa_stack.peek().condition);
				 	
				 	programa_stack.peek().condition.clear();
				 	programa_stack.peek().values.clear();
				 	
				 	programa_stack.peek().writer.println("Obtain table " + (ID8!=null?ID8.getText():null));
				 	programa_stack.peek().writer.println("Iterate table");
				 	programa_stack.peek().writer.println("If condition is true, delete row");
				 	programa_stack.peek().writer.close();
				 		 	
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "delete"



	// $ANTLR start "insert"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:438:1: insert : INSERT INTO ID LEFT_PAR cols RIGHT_PAR ( NEWLINE )? VALUES LEFT_PAR values RIGHT_PAR ( NEWLINE )* ;
	public final void insert()   {
		Token ID9=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:2: ( INSERT INTO ID LEFT_PAR cols RIGHT_PAR ( NEWLINE )? VALUES LEFT_PAR values RIGHT_PAR ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:4: INSERT INTO ID LEFT_PAR cols RIGHT_PAR ( NEWLINE )? VALUES LEFT_PAR values RIGHT_PAR ( NEWLINE )*
			{
			match(input,INSERT,FOLLOW_INSERT_in_insert632); 
			match(input,INTO,FOLLOW_INTO_in_insert634); 
			ID9=(Token)match(input,ID,FOLLOW_ID_in_insert636); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_insert638); 
			pushFollow(FOLLOW_cols_in_insert640);
			cols();
			state._fsp--;

			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_insert642); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:43: ( NEWLINE )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==NEWLINE) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:43: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_insert644); 
					}
					break;

			}

			match(input,VALUES,FOLLOW_VALUES_in_insert647); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_insert649); 
			pushFollow(FOLLOW_values_in_insert651);
			values();
			state._fsp--;

			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_insert653); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:85: ( NEWLINE )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==NEWLINE) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:439:85: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_insert655); 
					}
					break;

				default :
					break loop33;
				}
			}


				 	System.out.println("Insert into table " + (ID9!=null?ID9.getText():null));
				 	if (programa_stack.peek().column.size() != programa_stack.peek().values.size()) {
				 		System.out.println("Error: Mismatch between columns and values");
				 	} else {
				 		System.out.print("Columns: ");
				 		System.out.println(programa_stack.peek().column);
				 		System.out.print("Values: ");
				 		System.out.println(programa_stack.peek().values);
				 		Collections.reverse(programa_stack.peek().column);
				 		this.insert((ID9!=null?ID9.getText():null), programa_stack.peek().column, programa_stack.peek().values);
				 	}
				 	
				 	programa_stack.peek().writer.println("Obtain table " + (ID9!=null?ID9.getText():null));
				 	programa_stack.peek().writer.print("Insert into columns ");
				 	for (int i = 0; i < programa_stack.peek().column.size(); i++) {
				 		programa_stack.peek().writer.print(programa_stack.peek().column.get(i) + " ");
				 	}
				 	programa_stack.peek().writer.print("\nValues ");
				 	for (int i = 0; i < programa_stack.peek().values.size(); i++) {
				 		programa_stack.peek().writer.print(programa_stack.peek().values.get(i) + " ");
				 	}
				 	
				 	programa_stack.peek().column.clear();
				 	programa_stack.peek().values.clear();
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "insert"



	// $ANTLR start "values"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:469:1: values : ( value[\"0\"] values |);
	public final void values()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:470:2: ( value[\"0\"] values |)
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==FLOAT||LA34_0==ID||LA34_0==INT) ) {
				alt34=1;
			}
			else if ( (LA34_0==RIGHT_PAR) ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:470:4: value[\"0\"] values
					{
					pushFollow(FOLLOW_value_in_values672);
					value("0");
					state._fsp--;

					pushFollow(FOLLOW_values_in_values675);
					values();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:472:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "values"



	// $ANTLR start "value"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:474:1: value[String sel] : ( INT | FLOAT | ID );
	public final void value(String sel)   {
		Token INT10=null;
		Token FLOAT11=null;
		Token ID12=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:475:2: ( INT | FLOAT | ID )
			int alt35=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt35=1;
				}
				break;
			case FLOAT:
				{
				alt35=2;
				}
				break;
			case ID:
				{
				alt35=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:475:4: INT
					{
					INT10=(Token)match(input,INT,FOLLOW_INT_in_value692); 
					 
						 	if (sel.equals("0")) { programa_stack.peek().values.add((INT10!=null?INT10.getText():null)); }
						 	else if (sel.equals("1")) { programa_stack.peek().condition.add((INT10!=null?INT10.getText():null)); }
						 	else { programa_stack.peek().tmp = (INT10!=null?INT10.getText():null); }
						 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:481:4: FLOAT
					{
					FLOAT11=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_value702); 
					 
						 	if (sel.equals("0")) { programa_stack.peek().values.add((FLOAT11!=null?FLOAT11.getText():null)); }
						 	else if (sel.equals("1")) { programa_stack.peek().condition.add((FLOAT11!=null?FLOAT11.getText():null)); }
						 	else { programa_stack.peek().tmp = (FLOAT11!=null?FLOAT11.getText():null); }
						 
					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:487:4: ID
					{
					ID12=(Token)match(input,ID,FOLLOW_ID_in_value712); 
					 
						 	if (sel.equals("0")) { programa_stack.peek().values.add((ID12!=null?ID12.getText():null)); }
						 	else if (sel.equals("1")) { programa_stack.peek().condition.add((ID12!=null?ID12.getText():null)); }
						 	else { programa_stack.peek().tmp = (ID12!=null?ID12.getText():null); }
						 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "value"



	// $ANTLR start "ddl_commands"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:496:1: ddl_commands : ( ( set_db | create_index | drop_table | alter_table | create_table ) ( ddl_commands | dml_commands | clp_commands ) |);
	public final void ddl_commands()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:497:2: ( ( set_db | create_index | drop_table | alter_table | create_table ) ( ddl_commands | dml_commands | clp_commands ) |)
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==ALTER||LA38_0==CREATE||LA38_0==DROP||LA38_0==SET) ) {
				alt38=1;
			}
			else if ( (LA38_0==EOF) ) {
				alt38=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:497:4: ( set_db | create_index | drop_table | alter_table | create_table ) ( ddl_commands | dml_commands | clp_commands )
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:497:4: ( set_db | create_index | drop_table | alter_table | create_table )
					int alt36=5;
					switch ( input.LA(1) ) {
					case SET:
						{
						alt36=1;
						}
						break;
					case CREATE:
						{
						int LA36_2 = input.LA(2);
						if ( (LA36_2==INDEX) ) {
							alt36=2;
						}
						else if ( (LA36_2==TABLE) ) {
							alt36=5;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 36, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DROP:
						{
						alt36=3;
						}
						break;
					case ALTER:
						{
						alt36=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 36, 0, input);
						throw nvae;
					}
					switch (alt36) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:497:6: set_db
							{
							pushFollow(FOLLOW_set_db_in_ddl_commands734);
							set_db();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:498:4: create_index
							{
							pushFollow(FOLLOW_create_index_in_ddl_commands739);
							create_index();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:499:4: drop_table
							{
							pushFollow(FOLLOW_drop_table_in_ddl_commands744);
							drop_table();
							state._fsp--;

							}
							break;
						case 4 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:500:4: alter_table
							{
							pushFollow(FOLLOW_alter_table_in_ddl_commands749);
							alter_table();
							state._fsp--;

							}
							break;
						case 5 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:501:4: create_table
							{
							pushFollow(FOLLOW_create_table_in_ddl_commands754);
							create_table();
							state._fsp--;

							}
							break;

					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:501:19: ( ddl_commands | dml_commands | clp_commands )
					int alt37=3;
					switch ( input.LA(1) ) {
					case ALTER:
					case SET:
						{
						alt37=1;
						}
						break;
					case CREATE:
						{
						int LA37_2 = input.LA(2);
						if ( (LA37_2==INDEX||LA37_2==TABLE) ) {
							alt37=1;
						}
						else if ( (LA37_2==DATABASE) ) {
							alt37=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 37, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DROP:
						{
						int LA37_3 = input.LA(2);
						if ( (LA37_3==TABLE) ) {
							alt37=1;
						}
						else if ( (LA37_3==DATABASE) ) {
							alt37=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 37, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case EOF:
						{
						alt37=1;
						}
						break;
					case DELETE:
					case INSERT:
					case SELECT:
					case UPDATE:
						{
						alt37=2;
						}
						break;
					case DISPLAY:
					case GET:
					case LIST:
					case START:
					case STOP:
						{
						alt37=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 37, 0, input);
						throw nvae;
					}
					switch (alt37) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:501:21: ddl_commands
							{
							pushFollow(FOLLOW_ddl_commands_in_ddl_commands760);
							ddl_commands();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:502:4: dml_commands
							{
							pushFollow(FOLLOW_dml_commands_in_ddl_commands765);
							dml_commands();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:503:4: clp_commands
							{
							pushFollow(FOLLOW_clp_commands_in_ddl_commands770);
							clp_commands();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:505:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ddl_commands"



	// $ANTLR start "set_db"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:508:1: set_db : SET DATABASE ID ( NEWLINE )* ;
	public final void set_db()   {
		Token ID13=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:509:2: ( SET DATABASE ID ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:509:4: SET DATABASE ID ( NEWLINE )*
			{
			match(input,SET,FOLLOW_SET_in_set_db792); 
			match(input,DATABASE,FOLLOW_DATABASE_in_set_db794); 
			ID13=(Token)match(input,ID,FOLLOW_ID_in_set_db796); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:509:20: ( NEWLINE )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==NEWLINE) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:509:20: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_set_db798); 
					}
					break;

				default :
					break loop39;
				}
			}

			System.out.println("Setting " + (ID13!=null?ID13.getText():null) + " as current database...");

				 	programa_stack.peek().writer.println("Obtain database " + (ID13!=null?ID13.getText():null));
				 	programa_stack.peek().writer.println("Set it to be the current schema");
				 	programa_stack.peek().writer.close();
				 	
				 	this.setDB((ID13!=null?ID13.getText():null));
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "set_db"



	// $ANTLR start "create_index"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:520:1: create_index : CREATE INDEX index= ID ON ( NEWLINE )? table= ID LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )* ;
	public final void create_index()   {
		Token index=null;
		Token table=null;
		Token column=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:2: ( CREATE INDEX index= ID ON ( NEWLINE )? table= ID LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:4: CREATE INDEX index= ID ON ( NEWLINE )? table= ID LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )*
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_index819); 
			match(input,INDEX,FOLLOW_INDEX_in_create_index821); 
			index=(Token)match(input,ID,FOLLOW_ID_in_create_index827); 
			match(input,ON,FOLLOW_ON_in_create_index829); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:31: ( NEWLINE )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==NEWLINE) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:31: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_create_index831); 
					}
					break;

			}

			table=(Token)match(input,ID,FOLLOW_ID_in_create_index838); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_create_index840); 
			column=(Token)match(input,ID,FOLLOW_ID_in_create_index846); 
			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_create_index848); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:82: ( NEWLINE )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==NEWLINE) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:521:82: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_create_index850); 
					}
					break;

				default :
					break loop41;
				}
			}


				 	System.out.println("Creating index " + (index!=null?index.getText():null) + " on column " + (column!=null?column.getText():null) + " from table " + (table!=null?table.getText():null) 
				 	+ "...");
				 	
				 	programa_stack.peek().writer.println("Obtain table " + (table!=null?table.getText():null));
				 	programa_stack.peek().writer.println("Obtain column " + (column!=null?column.getText():null));
				 	programa_stack.peek().writer.println("Create index " + (index!=null?index.getText():null));
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "create_index"



	// $ANTLR start "drop_table"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:534:1: drop_table : DROP TABLE ID ( NEWLINE )* ;
	public final void drop_table()   {
		Token ID14=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:535:2: ( DROP TABLE ID ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:535:4: DROP TABLE ID ( NEWLINE )*
			{
			match(input,DROP,FOLLOW_DROP_in_drop_table870); 
			match(input,TABLE,FOLLOW_TABLE_in_drop_table872); 
			ID14=(Token)match(input,ID,FOLLOW_ID_in_drop_table874); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:535:18: ( NEWLINE )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==NEWLINE) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:535:18: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_drop_table876); 
					}
					break;

				default :
					break loop42;
				}
			}

			System.out.println("Deleting table " + (ID14!=null?ID14.getText():null) + "...");

				 	programa_stack.peek().writer.println("Obtain table " + (ID14!=null?ID14.getText():null));
				 	programa_stack.peek().writer.println("Delete the table");
				 	programa_stack.peek().writer.close();
				 	this.dropTable((ID14!=null?ID14.getText():null));
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "drop_table"



	// $ANTLR start "alter_table"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:545:1: alter_table : ALTER TABLE ID ( NEWLINE )? ADD CONSTRAINT const_def[$ID.text] ( NEWLINE )* ;
	public final void alter_table()   {
		Token ID15=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:2: ( ALTER TABLE ID ( NEWLINE )? ADD CONSTRAINT const_def[$ID.text] ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:4: ALTER TABLE ID ( NEWLINE )? ADD CONSTRAINT const_def[$ID.text] ( NEWLINE )*
			{
			match(input,ALTER,FOLLOW_ALTER_in_alter_table898); 
			match(input,TABLE,FOLLOW_TABLE_in_alter_table900); 
			ID15=(Token)match(input,ID,FOLLOW_ID_in_alter_table902); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:19: ( NEWLINE )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==NEWLINE) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:19: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_alter_table904); 
					}
					break;

			}

			match(input,ADD,FOLLOW_ADD_in_alter_table907); 
			match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_alter_table909); 
			pushFollow(FOLLOW_const_def_in_alter_table911);
			const_def((ID15!=null?ID15.getText():null));
			state._fsp--;

			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:63: ( NEWLINE )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==NEWLINE) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:546:63: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_alter_table914); 
					}
					break;

				default :
					break loop44;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "alter_table"



	// $ANTLR start "const_def"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:549:1: const_def[String table] : FOREIGN KEY LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )? REFERENCES r_table= ID LEFT_PAR r_column= ID RIGHT_PAR ;
	public final void const_def(String table)   {
		Token column=null;
		Token r_table=null;
		Token r_column=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:550:2: ( FOREIGN KEY LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )? REFERENCES r_table= ID LEFT_PAR r_column= ID RIGHT_PAR )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:550:4: FOREIGN KEY LEFT_PAR column= ID RIGHT_PAR ( NEWLINE )? REFERENCES r_table= ID LEFT_PAR r_column= ID RIGHT_PAR
			{
			match(input,FOREIGN,FOLLOW_FOREIGN_in_const_def929); 
			match(input,KEY,FOLLOW_KEY_in_const_def931); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_const_def933); 
			column=(Token)match(input,ID,FOLLOW_ID_in_const_def939); 
			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_const_def941); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:550:47: ( NEWLINE )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==NEWLINE) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:550:47: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_const_def943); 
					}
					break;

			}

			match(input,REFERENCES,FOLLOW_REFERENCES_in_const_def946); 
			r_table=(Token)match(input,ID,FOLLOW_ID_in_const_def952); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_const_def954); 
			r_column=(Token)match(input,ID,FOLLOW_ID_in_const_def960); 
			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_const_def962); 

				 	System.out.println("Column " + (column!=null?column.getText():null) + " from table " + table + " references column " +
				 	(r_column!=null?r_column.getText():null) + " from table " + (r_table!=null?r_table.getText():null));
				 	
				 	programa_stack.peek().writer.println("Obtain both " + table + " and " + (r_table!=null?r_table.getText():null));
				 	programa_stack.peek().writer.println("Check that " + (r_column!=null?r_column.getText():null) + " is a primary key");
				 	programa_stack.peek().writer.println("Add reference from " + (column!=null?column.getText():null) + " to " + (r_column!=null?r_column.getText():null));
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "const_def"



	// $ANTLR start "create_table"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:563:1: create_table : CREATE TABLE ID AS LEFT_PAR ( NEWLINE )? col_def p_key RIGHT_PAR ( NEWLINE )* ;
	public final void create_table()   {
		Token ID16=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:2: ( CREATE TABLE ID AS LEFT_PAR ( NEWLINE )? col_def p_key RIGHT_PAR ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:4: CREATE TABLE ID AS LEFT_PAR ( NEWLINE )? col_def p_key RIGHT_PAR ( NEWLINE )*
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_table981); 
			match(input,TABLE,FOLLOW_TABLE_in_create_table983); 
			ID16=(Token)match(input,ID,FOLLOW_ID_in_create_table985); 
			match(input,AS,FOLLOW_AS_in_create_table987); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_create_table989); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:32: ( NEWLINE )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==NEWLINE) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:32: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_create_table991); 
					}
					break;

			}

			pushFollow(FOLLOW_col_def_in_create_table994);
			col_def();
			state._fsp--;

			pushFollow(FOLLOW_p_key_in_create_table996);
			p_key();
			state._fsp--;

			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_create_table998); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:65: ( NEWLINE )*
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( (LA47_0==NEWLINE) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:564:65: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_create_table1000); 
					}
					break;

				default :
					break loop47;
				}
			}


				 	Collections.reverse(programa_stack.peek().column);
				 	int j = 0;
				 	for (int k = 0; k < programa_stack.peek().type_null.size(); k += 4) {
				 		Vector<String> v = new Vector<String>();
				 		v.add(programa_stack.peek().column.get(j));
				 		v.add(programa_stack.peek().type_null.get(k));
				 		v.add(programa_stack.peek().type_null.get(k + 1));
				 		v.add(programa_stack.peek().type_null.get(k + 2));
				 		v.add(programa_stack.peek().type_null.get(k + 3));
				 		programa_stack.peek().columns.add(v);
				 		j++;
				 	}
					boolean pk = false;
					boolean pk_exists = false;
					for (int i = 0; i < programa_stack.peek().columns.size(); i++) {
						Vector<String> v = programa_stack.peek().columns.get(i);
						if (v.get(0).equals(programa_stack.peek().tmp)) {
							pk_exists = true;
							if (v.get(4).equals("1")) {
								pk = true;
							}
						}
					}
					if (!pk_exists) {
						System.out.println("Error: Primary key is not a valid column");
					} else if (pk) {
						System.out.println("Error: Primary key can't be null");
					} else {
				 		System.out.println("Table: " + (ID16!=null?ID16.getText():null));
				 		System.out.println("Columns:");
				 		for(int i = 0; i < programa_stack.peek().columns.size(); i++) {
				 			System.out.println(programa_stack.peek().columns.get(i));
				 		}
				 		System.out.println("Primary key: " + programa_stack.peek().tmp);
				 		this.createTable((ID16!=null?ID16.getText():null), programa_stack.peek().columns, programa_stack.peek().tmp);
				 	}
				 	
				 	programa_stack.peek().writer.println("Check that table " + (ID16!=null?ID16.getText():null) + " does not exists");
				 	programa_stack.peek().writer.print("Create new table with columns ");
				 	for (int i = 0; i < programa_stack.peek().columns.size(); i++) {
				 		programa_stack.peek().writer.print(programa_stack.peek().columns.get(i).get(0) + " ");
				 	}
				 	programa_stack.peek().writer.print(" and primary key " + programa_stack.peek().tmp);
				 	programa_stack.peek().writer.close();
				 	
				 	programa_stack.peek().column.clear();
				 	programa_stack.peek().type_null.clear();
				 	programa_stack.peek().columns.clear();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "create_table"



	// $ANTLR start "col_def"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:618:1: col_def : ( ID type null_cons ( NEWLINE )? col_def |);
	public final void col_def()   {
		Token ID17=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:619:2: ( ID type null_cons ( NEWLINE )? col_def |)
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==ID) ) {
				alt49=1;
			}
			else if ( (LA49_0==PRIMARY) ) {
				alt49=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:619:4: ID type null_cons ( NEWLINE )? col_def
					{
					ID17=(Token)match(input,ID,FOLLOW_ID_in_col_def1020); 
					pushFollow(FOLLOW_type_in_col_def1022);
					type();
					state._fsp--;

					pushFollow(FOLLOW_null_cons_in_col_def1024);
					null_cons();
					state._fsp--;

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:619:22: ( NEWLINE )?
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==NEWLINE) ) {
						alt48=1;
					}
					switch (alt48) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:619:22: NEWLINE
							{
							match(input,NEWLINE,FOLLOW_NEWLINE_in_col_def1026); 
							}
							break;

					}

					pushFollow(FOLLOW_col_def_in_col_def1029);
					col_def();
					state._fsp--;


						 	//programa_stack.peek().columns.add(programa_stack.peek().column);
						 	//programa_stack.peek().column.clear();
						 	//programa_stack.peek().column.add((ID17!=null?ID17.getText():null));
						 	//System.out.println((ID17!=null?ID17.getText():null));
						 	programa_stack.peek().column.add((ID17!=null?ID17.getText():null));
						 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:628:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "col_def"



	// $ANTLR start "type"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:631:1: type : ( INTEGER | DECIMAL LEFT_PAR digits= INT COLON decimals= INT RIGHT_PAR | CHARACTER LEFT_PAR INT RIGHT_PAR | VARCHAR | DATETIME );
	public final void type()   {
		Token digits=null;
		Token decimals=null;
		Token INTEGER18=null;
		Token DECIMAL19=null;
		Token INT20=null;
		Token CHARACTER21=null;
		Token VARCHAR22=null;
		Token DATETIME23=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:632:2: ( INTEGER | DECIMAL LEFT_PAR digits= INT COLON decimals= INT RIGHT_PAR | CHARACTER LEFT_PAR INT RIGHT_PAR | VARCHAR | DATETIME )
			int alt50=5;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt50=1;
				}
				break;
			case DECIMAL:
				{
				alt50=2;
				}
				break;
			case CHARACTER:
				{
				alt50=3;
				}
				break;
			case VARCHAR:
				{
				alt50=4;
				}
				break;
			case DATETIME:
				{
				alt50=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:632:4: INTEGER
					{
					INTEGER18=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_type1053); 
					 
						 	programa_stack.peek().type_null.add("INTEGER");
						 	programa_stack.peek().type_null.add("-1");
						 	programa_stack.peek().type_null.add("-1");
						 	//System.out.println((INTEGER18!=null?INTEGER18.getText():null));
						 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:639:4: DECIMAL LEFT_PAR digits= INT COLON decimals= INT RIGHT_PAR
					{
					DECIMAL19=(Token)match(input,DECIMAL,FOLLOW_DECIMAL_in_type1063); 
					match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_type1065); 
					digits=(Token)match(input,INT,FOLLOW_INT_in_type1071); 
					match(input,COLON,FOLLOW_COLON_in_type1073); 
					decimals=(Token)match(input,INT,FOLLOW_INT_in_type1079); 
					match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_type1081); 
					 
						 	programa_stack.peek().type_null.add("DECIMAL");
						 	programa_stack.peek().type_null.add((digits!=null?digits.getText():null));
						 	programa_stack.peek().type_null.add((decimals!=null?decimals.getText():null));
						 	//System.out.println((DECIMAL19!=null?DECIMAL19.getText():null));
						 
					}
					break;
				case 3 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:646:4: CHARACTER LEFT_PAR INT RIGHT_PAR
					{
					CHARACTER21=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_type1091); 
					match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_type1093); 
					INT20=(Token)match(input,INT,FOLLOW_INT_in_type1095); 
					match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_type1097); 
					 
						 	programa_stack.peek().type_null.add("CHAR");
						 	programa_stack.peek().type_null.add((INT20!=null?INT20.getText():null));
						 	programa_stack.peek().type_null.add("-1");
						 	//System.out.println((CHARACTER21!=null?CHARACTER21.getText():null));
						 
					}
					break;
				case 4 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:653:4: VARCHAR
					{
					VARCHAR22=(Token)match(input,VARCHAR,FOLLOW_VARCHAR_in_type1107); 
					 
						 	programa_stack.peek().type_null.add("VARCHAR");
						 	programa_stack.peek().type_null.add("-1");
						 	programa_stack.peek().type_null.add("-1");
						 	//System.out.println((VARCHAR22!=null?VARCHAR22.getText():null));
						 
					}
					break;
				case 5 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:660:4: DATETIME
					{
					DATETIME23=(Token)match(input,DATETIME,FOLLOW_DATETIME_in_type1117); 
					 
						 	programa_stack.peek().type_null.add("DATETIME"); 
						 	programa_stack.peek().type_null.add("-1");
						 	programa_stack.peek().type_null.add("-1");
						 	//System.out.println((DATETIME23!=null?DATETIME23.getText():null));
						 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "null_cons"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:670:1: null_cons : ( NULL | NOT NULL );
	public final void null_cons()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:671:2: ( NULL | NOT NULL )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==NULL) ) {
				alt51=1;
			}
			else if ( (LA51_0==NOT) ) {
				alt51=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}

			switch (alt51) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:671:4: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_null_cons1137); 
					 
						 	programa_stack.peek().type_null.add("1");
						 	//System.out.println("NULL");
						 
					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:676:4: NOT NULL
					{
					match(input,NOT,FOLLOW_NOT_in_null_cons1147); 
					match(input,NULL,FOLLOW_NULL_in_null_cons1149); 
					 
						 	programa_stack.peek().type_null.add("0");
						 	//System.out.println("NOT NULL");
						 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "null_cons"



	// $ANTLR start "p_key"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:684:1: p_key : PRIMARY KEY LEFT_PAR ID RIGHT_PAR ( NEWLINE )? ;
	public final void p_key()   {
		Token ID24=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:2: ( PRIMARY KEY LEFT_PAR ID RIGHT_PAR ( NEWLINE )? )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:4: PRIMARY KEY LEFT_PAR ID RIGHT_PAR ( NEWLINE )?
			{
			match(input,PRIMARY,FOLLOW_PRIMARY_in_p_key1169); 
			match(input,KEY,FOLLOW_KEY_in_p_key1171); 
			match(input,LEFT_PAR,FOLLOW_LEFT_PAR_in_p_key1173); 
			ID24=(Token)match(input,ID,FOLLOW_ID_in_p_key1175); 
			match(input,RIGHT_PAR,FOLLOW_RIGHT_PAR_in_p_key1177); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:38: ( NEWLINE )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==NEWLINE) ) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:685:38: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_p_key1179); 
					}
					break;

			}


				 	programa_stack.peek().tmp = (ID24!=null?ID24.getText():null);
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "p_key"



	// $ANTLR start "clp_commands"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:692:1: clp_commands : ( ( create_db | drop_db | list_db | start | get_status | stop | display_db ) ( clp_commands | dml_commands | ddl_commands ) |);
	public final void clp_commands()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:693:2: ( ( create_db | drop_db | list_db | start | get_status | stop | display_db ) ( clp_commands | dml_commands | ddl_commands ) |)
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==CREATE||(LA55_0 >= DISPLAY && LA55_0 <= DROP)||LA55_0==GET||LA55_0==LIST||LA55_0==START||LA55_0==STOP) ) {
				alt55=1;
			}
			else if ( (LA55_0==EOF) ) {
				alt55=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}

			switch (alt55) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:693:4: ( create_db | drop_db | list_db | start | get_status | stop | display_db ) ( clp_commands | dml_commands | ddl_commands )
					{
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:693:4: ( create_db | drop_db | list_db | start | get_status | stop | display_db )
					int alt53=7;
					switch ( input.LA(1) ) {
					case CREATE:
						{
						alt53=1;
						}
						break;
					case DROP:
						{
						alt53=2;
						}
						break;
					case LIST:
						{
						alt53=3;
						}
						break;
					case START:
						{
						alt53=4;
						}
						break;
					case GET:
						{
						alt53=5;
						}
						break;
					case STOP:
						{
						alt53=6;
						}
						break;
					case DISPLAY:
						{
						alt53=7;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
						throw nvae;
					}
					switch (alt53) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:693:6: create_db
							{
							pushFollow(FOLLOW_create_db_in_clp_commands1200);
							create_db();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:694:4: drop_db
							{
							pushFollow(FOLLOW_drop_db_in_clp_commands1205);
							drop_db();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:695:4: list_db
							{
							pushFollow(FOLLOW_list_db_in_clp_commands1210);
							list_db();
							state._fsp--;

							}
							break;
						case 4 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:696:4: start
							{
							pushFollow(FOLLOW_start_in_clp_commands1215);
							start();
							state._fsp--;

							}
							break;
						case 5 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:697:4: get_status
							{
							pushFollow(FOLLOW_get_status_in_clp_commands1220);
							get_status();
							state._fsp--;

							}
							break;
						case 6 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:698:4: stop
							{
							pushFollow(FOLLOW_stop_in_clp_commands1225);
							stop();
							state._fsp--;

							}
							break;
						case 7 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:699:4: display_db
							{
							pushFollow(FOLLOW_display_db_in_clp_commands1230);
							display_db();
							state._fsp--;

							}
							break;

					}

					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:699:17: ( clp_commands | dml_commands | ddl_commands )
					int alt54=3;
					switch ( input.LA(1) ) {
					case CREATE:
						{
						int LA54_1 = input.LA(2);
						if ( (LA54_1==DATABASE) ) {
							alt54=1;
						}
						else if ( (LA54_1==INDEX||LA54_1==TABLE) ) {
							alt54=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 54, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DROP:
						{
						int LA54_2 = input.LA(2);
						if ( (LA54_2==DATABASE) ) {
							alt54=1;
						}
						else if ( (LA54_2==TABLE) ) {
							alt54=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 54, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case DISPLAY:
					case GET:
					case LIST:
					case START:
					case STOP:
						{
						alt54=1;
						}
						break;
					case EOF:
						{
						alt54=1;
						}
						break;
					case DELETE:
					case INSERT:
					case SELECT:
					case UPDATE:
						{
						alt54=2;
						}
						break;
					case ALTER:
					case SET:
						{
						alt54=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 54, 0, input);
						throw nvae;
					}
					switch (alt54) {
						case 1 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:699:19: clp_commands
							{
							pushFollow(FOLLOW_clp_commands_in_clp_commands1236);
							clp_commands();
							state._fsp--;

							}
							break;
						case 2 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:700:4: dml_commands
							{
							pushFollow(FOLLOW_dml_commands_in_clp_commands1241);
							dml_commands();
							state._fsp--;

							}
							break;
						case 3 :
							// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:701:4: ddl_commands
							{
							pushFollow(FOLLOW_ddl_commands_in_clp_commands1246);
							ddl_commands();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 2 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:703:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "clp_commands"



	// $ANTLR start "create_db"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:706:1: create_db : CREATE DATABASE ID ( NEWLINE )* ;
	public final void create_db()   {
		Token ID25=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:707:2: ( CREATE DATABASE ID ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:707:4: CREATE DATABASE ID ( NEWLINE )*
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_db1267); 
			match(input,DATABASE,FOLLOW_DATABASE_in_create_db1269); 
			ID25=(Token)match(input,ID,FOLLOW_ID_in_create_db1271); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:707:23: ( NEWLINE )*
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==NEWLINE) ) {
					alt56=1;
				}

				switch (alt56) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:707:23: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_create_db1273); 
					}
					break;

				default :
					break loop56;
				}
			}

			System.out.println("Creating database " + (ID25!=null?ID25.getText():null) + "...\n");

				 	programa_stack.peek().writer.println("Check that database " + (ID25!=null?ID25.getText():null) + " does not exist");
				 	programa_stack.peek().writer.println("Create the database");
				 	programa_stack.peek().writer.close();
				 	
				 	this.createDB((ID25!=null?ID25.getText():null));
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "create_db"



	// $ANTLR start "drop_db"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:718:1: drop_db : DROP DATABASE ID ( NEWLINE )* ;
	public final void drop_db()   {
		Token ID26=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:719:2: ( DROP DATABASE ID ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:719:4: DROP DATABASE ID ( NEWLINE )*
			{
			match(input,DROP,FOLLOW_DROP_in_drop_db1294); 
			match(input,DATABASE,FOLLOW_DATABASE_in_drop_db1296); 
			ID26=(Token)match(input,ID,FOLLOW_ID_in_drop_db1298); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:719:21: ( NEWLINE )*
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==NEWLINE) ) {
					alt57=1;
				}

				switch (alt57) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:719:21: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_drop_db1300); 
					}
					break;

				default :
					break loop57;
				}
			}

			System.out.println("Deleting database " + (ID26!=null?ID26.getText():null) + "...\n");

				 	programa_stack.peek().writer.println("Obtain database " + (ID26!=null?ID26.getText():null));
				 	programa_stack.peek().writer.println("Delete the database");
				 	programa_stack.peek().writer.close();
				 	
				 	this.dropDB((ID26!=null?ID26.getText():null));
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "drop_db"



	// $ANTLR start "list_db"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:730:1: list_db : LIST DATABASES ( NEWLINE )* ;
	public final void list_db()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:731:2: ( LIST DATABASES ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:731:4: LIST DATABASES ( NEWLINE )*
			{
			match(input,LIST,FOLLOW_LIST_in_list_db1321); 
			match(input,DATABASES,FOLLOW_DATABASES_in_list_db1323); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:731:19: ( NEWLINE )*
			loop58:
			while (true) {
				int alt58=2;
				int LA58_0 = input.LA(1);
				if ( (LA58_0==NEWLINE) ) {
					alt58=1;
				}

				switch (alt58) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:731:19: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_list_db1325); 
					}
					break;

				default :
					break loop58;
				}
			}

			System.out.println("Listing databases...\n");

				 	programa_stack.peek().writer.println("Iterate and show the schemas");
				 	programa_stack.peek().writer.close();
				 	this.listDB();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "list_db"



	// $ANTLR start "start"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:740:1: start : START ( NEWLINE )* ;
	public final void start()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:741:2: ( START ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:741:4: START ( NEWLINE )*
			{
			match(input,START,FOLLOW_START_in_start1346); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:741:10: ( NEWLINE )*
			loop59:
			while (true) {
				int alt59=2;
				int LA59_0 = input.LA(1);
				if ( (LA59_0==NEWLINE) ) {
					alt59=1;
				}

				switch (alt59) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:741:10: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_start1348); 
					}
					break;

				default :
					break loop59;
				}
			}

			System.out.println("Starting processes...\n");

				 	programa_stack.peek().writer.println("Start the processes");
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start"



	// $ANTLR start "get_status"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:749:1: get_status : GET STATUS ( NEWLINE )* ;
	public final void get_status()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:2: ( GET STATUS ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:4: GET STATUS ( NEWLINE )*
			{
			match(input,GET,FOLLOW_GET_in_get_status1369); 
			match(input,STATUS,FOLLOW_STATUS_in_get_status1371); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:15: ( NEWLINE )*
			loop60:
			while (true) {
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==NEWLINE) ) {
					alt60=1;
				}

				switch (alt60) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:750:15: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_get_status1373); 
					}
					break;

				default :
					break loop60;
				}
			}

			System.out.println("Obtaining status...\n");

				 	programa_stack.peek().writer.println("Iterate the processes and return the status");
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "get_status"



	// $ANTLR start "stop"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:758:1: stop : STOP ( NEWLINE )* ;
	public final void stop()   {
		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:759:2: ( STOP ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:759:4: STOP ( NEWLINE )*
			{
			match(input,STOP,FOLLOW_STOP_in_stop1394); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:759:9: ( NEWLINE )*
			loop61:
			while (true) {
				int alt61=2;
				int LA61_0 = input.LA(1);
				if ( (LA61_0==NEWLINE) ) {
					alt61=1;
				}

				switch (alt61) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:759:9: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stop1396); 
					}
					break;

				default :
					break loop61;
				}
			}

			System.out.println("Stoping processes...\n");

				 	programa_stack.peek().writer.println("Stop the processes");
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stop"



	// $ANTLR start "display_db"
	// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:767:1: display_db : DISPLAY DATABASE ID ( NEWLINE )* ;
	public final void display_db()   {
		Token ID27=null;

		try {
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:768:2: ( DISPLAY DATABASE ID ( NEWLINE )* )
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:768:4: DISPLAY DATABASE ID ( NEWLINE )*
			{
			match(input,DISPLAY,FOLLOW_DISPLAY_in_display_db1417); 
			match(input,DATABASE,FOLLOW_DATABASE_in_display_db1419); 
			ID27=(Token)match(input,ID,FOLLOW_ID_in_display_db1421); 
			// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:768:24: ( NEWLINE )*
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( (LA62_0==NEWLINE) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// /home/hector/Dropbox/TEC/Bases de Datos/Proyecto 1/urSQL.g:768:24: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_display_db1423); 
					}
					break;

				default :
					break loop62;
				}
			}

			System.out.println("Displaying database " + (ID27!=null?ID27.getText():null) + "...\n");

				 	programa_stack.peek().writer.println("Obtain database " + (ID27!=null?ID27.getText():null));
				 	programa_stack.peek().writer.println("Display the database information");
				 	programa_stack.peek().writer.close();
				 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "display_db"

	// Delegated rules



	public static final BitSet FOLLOW_clp_commands_in_programa66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ddl_commands_in_programa71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dml_commands_in_programa76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_in_dml_commands93 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_update_in_dml_commands98 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_delete_in_dml_commands103 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_insert_in_dml_commands108 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_clp_commands_in_dml_commands114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ddl_commands_in_dml_commands119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dml_commands_in_dml_commands124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_select141 = new BitSet(new long[]{0x0038001040008120L});
	public static final BitSet FOLLOW_ALL_in_select145 = new BitSet(new long[]{0x0020000040000000L});
	public static final BitSet FOLLOW_col_list_in_select152 = new BitSet(new long[]{0x0020000040000000L});
	public static final BitSet FOLLOW_NEWLINE_in_select156 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_from_in_select159 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_select161 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_ID_in_col_list179 = new BitSet(new long[]{0x0018001000008100L});
	public static final BitSet FOLLOW_agg_funct_in_col_list190 = new BitSet(new long[]{0x0018001000008100L});
	public static final BitSet FOLLOW_col_list_in_col_list194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_from211 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_from215 = new BitSet(new long[]{0x0020000410000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_join_st_in_from222 = new BitSet(new long[]{0x0020000410000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_NEWLINE_in_from226 = new BitSet(new long[]{0x0020000410000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_where_in_from229 = new BitSet(new long[]{0x0020000410000002L});
	public static final BitSet FOLLOW_NEWLINE_in_from232 = new BitSet(new long[]{0x0020000410000002L});
	public static final BitSet FOLLOW_group_in_from235 = new BitSet(new long[]{0x0020000010000002L});
	public static final BitSet FOLLOW_NEWLINE_in_from238 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_for_JSON_XML_in_from241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_join_st258 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_st260 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_join_st266 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_join_st_aux_in_join_st268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JOIN_in_join_st_aux284 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_join_st_aux286 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_join_st_aux_in_join_st_aux288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where307 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_where_st_in_where309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_where_st321 = new BitSet(new long[]{0x0043800301000000L});
	public static final BitSet FOLLOW_comp_op_in_where_st323 = new BitSet(new long[]{0x0000009008000000L});
	public static final BitSet FOLLOW_value_in_where_st325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_where_st333 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_null_op_in_where_st335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_THAN_in_comp_op349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_EQUALS_in_comp_op356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_THAN_in_comp_op363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_EQUALS_in_comp_op370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUALS_in_comp_op377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIKE_in_comp_op384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_comp_op391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_null_op405 = new BitSet(new long[]{0x00C0000000000000L});
	public static final BitSet FOLLOW_NULL_in_null_op409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_null_op420 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_NULL_in_null_op422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_group442 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BY_in_group444 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_cols_in_group446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_cols458 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_cols_in_cols460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_JSON_XML477 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_JSON_in_for_JSON_XML481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_XML_in_for_JSON_XML488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COUNT_in_agg_funct506 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_AVERAGE_in_agg_funct513 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_MIN_in_agg_funct520 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_MAX_in_agg_funct527 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_agg_funct535 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_agg_funct537 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_agg_funct541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_update553 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_update559 = new BitSet(new long[]{0x4020000000000000L});
	public static final BitSet FOLLOW_NEWLINE_in_update561 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_SET_in_update564 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_update570 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EQUALS_in_update572 = new BitSet(new long[]{0x0000009008000000L});
	public static final BitSet FOLLOW_value_in_update574 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_NEWLINE_in_update577 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_where_in_update580 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_update583 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_DELETE_in_delete600 = new BitSet(new long[]{0x0020000040000000L});
	public static final BitSet FOLLOW_NEWLINE_in_delete602 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FROM_in_delete605 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_delete607 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_NEWLINE_in_delete609 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_where_in_delete612 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_delete615 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_INSERT_in_insert632 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_INTO_in_insert634 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_insert636 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_insert638 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_cols_in_insert640 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_insert642 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_insert644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_VALUES_in_insert647 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_insert649 = new BitSet(new long[]{0x1000009008000000L});
	public static final BitSet FOLLOW_values_in_insert651 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_insert653 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_insert655 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_value_in_values672 = new BitSet(new long[]{0x0000009008000000L});
	public static final BitSet FOLLOW_values_in_values675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_value692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_value702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_db_in_ddl_commands734 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_create_index_in_ddl_commands739 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_drop_table_in_ddl_commands744 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_alter_table_in_ddl_commands749 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_create_table_in_ddl_commands754 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_ddl_commands_in_ddl_commands760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dml_commands_in_ddl_commands765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_clp_commands_in_ddl_commands770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_set_db792 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DATABASE_in_set_db794 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_set_db796 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_set_db798 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_index819 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_INDEX_in_create_index821 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_create_index827 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_ON_in_create_index829 = new BitSet(new long[]{0x0020001000000000L});
	public static final BitSet FOLLOW_NEWLINE_in_create_index831 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_create_index838 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_create_index840 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_create_index846 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_create_index848 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_create_index850 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_table870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_TABLE_in_drop_table872 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_drop_table874 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_drop_table876 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_ALTER_in_alter_table898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_TABLE_in_alter_table900 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_alter_table902 = new BitSet(new long[]{0x0020000000000010L});
	public static final BitSet FOLLOW_NEWLINE_in_alter_table904 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADD_in_alter_table907 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CONSTRAINT_in_alter_table909 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_const_def_in_alter_table911 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_alter_table914 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_FOREIGN_in_const_def929 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_KEY_in_const_def931 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_const_def933 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_const_def939 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_const_def941 = new BitSet(new long[]{0x0820000000000000L});
	public static final BitSet FOLLOW_NEWLINE_in_const_def943 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_REFERENCES_in_const_def946 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_const_def952 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_const_def954 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_const_def960 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_const_def962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_table981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_TABLE_in_create_table983 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_create_table985 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_AS_in_create_table987 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_create_table989 = new BitSet(new long[]{0x0420001000000000L});
	public static final BitSet FOLLOW_NEWLINE_in_create_table991 = new BitSet(new long[]{0x0400001000000000L});
	public static final BitSet FOLLOW_col_def_in_create_table994 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_p_key_in_create_table996 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_create_table998 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_create_table1000 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_ID_in_col_def1020 = new BitSet(new long[]{0x0000010000180800L,0x0000000000000080L});
	public static final BitSet FOLLOW_type_in_col_def1022 = new BitSet(new long[]{0x00C0000000000000L});
	public static final BitSet FOLLOW_null_cons_in_col_def1024 = new BitSet(new long[]{0x0020001000000000L});
	public static final BitSet FOLLOW_NEWLINE_in_col_def1026 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_col_def_in_col_def1029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type1053 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECIMAL_in_type1063 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_type1065 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INT_in_type1071 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_COLON_in_type1073 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INT_in_type1079 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_type1081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_type1091 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_type1093 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_INT_in_type1095 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_type1097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARCHAR_in_type1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATETIME_in_type1117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_null_cons1137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_null_cons1147 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_NULL_in_null_cons1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRIMARY_in_p_key1169 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_KEY_in_p_key1171 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_LEFT_PAR_in_p_key1173 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_p_key1175 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_RIGHT_PAR_in_p_key1177 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_p_key1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_db_in_clp_commands1200 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_drop_db_in_clp_commands1205 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_list_db_in_clp_commands1210 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_start_in_clp_commands1215 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_get_status_in_clp_commands1220 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_stop_in_clp_commands1225 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_display_db_in_clp_commands1230 = new BitSet(new long[]{0xE004004080E10040L,0x0000000000000022L});
	public static final BitSet FOLLOW_clp_commands_in_clp_commands1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dml_commands_in_clp_commands1241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ddl_commands_in_clp_commands1246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_db1267 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DATABASE_in_create_db1269 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_create_db1271 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_create_db1273 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_db1294 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DATABASE_in_drop_db1296 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_drop_db1298 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_drop_db1300 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_LIST_in_list_db1321 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DATABASES_in_list_db1323 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_list_db1325 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_START_in_start1346 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_start1348 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_GET_in_get_status1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_STATUS_in_get_status1371 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_get_status1373 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_STOP_in_stop1394 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stop1396 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_DISPLAY_in_display_db1417 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DATABASE_in_display_db1419 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_ID_in_display_db1421 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_display_db1423 = new BitSet(new long[]{0x0020000000000002L});
}
