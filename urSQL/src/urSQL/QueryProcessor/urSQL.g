grammar urSQL;

options { language = Java; }

@lexer::header {
	package query_processor;
	import java.io.*;
}

@header {
	package query_processor;
	import java.io.*;
	import java.util.Vector;
	import java.util.Collections;
}

@members {
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		String hdr = getErrorHeader(e);
		String[] splt = hdr.split("\\s");
		String tmp = splt[1];
		char c = tmp.charAt(0);
		String lineNumber = "";
		lineNumber += Character.toString(c);
		c = tmp.charAt(1);
		if (!Character.toString(c).equals(":")) {
			lineNumber += Character.toString(c);
		}
		System.out.println("Error 42000: Syntax error or access rule violation in line " + lineNumber);
	}
}

/* Inicio del programa */
programa

scope {
	Vector<String> type_null;
	Vector<String> column;
	Vector<String> values;
	Vector<String> condition;
	Vector<String> select_columns;
	Vector<String> select_tables;
	Vector<String> select_group;
	Vector<Vector<String>> columns;
	String tmp;
}

@init {
	$programa::type_null = new Vector<String>();
	$programa::column = new Vector<String>();
	$programa::values = new Vector<String>();
	$programa::condition = new Vector<String>();
	$programa::select_columns = new Vector<String>();
	$programa::select_tables = new Vector<String>();
	$programa::select_group = new Vector<String>();
	$programa::columns = new Vector<Vector<String>>();
	$programa::tmp = "";
}
	: clp_commands
	| ddl_commands
	| dml_commands
	;
	
/* Comandos DML */ 
dml_commands
	: ( select
	| update
	| delete
	| insert ) ( clp_commands
	| ddl_commands
	| dml_commands )
	|
	;
	
select
	: SELECT ( ALL { $programa::select_columns.add("69"); }
	| col_list ) NEWLINE? from NEWLINE*
	{
		if (!$programa::tmp.equals("0") && !$programa::tmp.equals("1")) {
			$programa::tmp = "-1";
		}
		System.out.println("Select query...");
		System.out.print("Columns: ");
		System.out.println($programa::select_columns);
		System.out.print("Tables: ");
		System.out.println($programa::select_tables);
		System.out.print("Condition: ");
		System.out.println($programa::condition);
		System.out.print("Grouping by: ");
		System.out.println($programa::column);
		System.out.print("XML/JSON: ");
		System.out.println($programa::tmp);
	}
	;
	
col_list
	: ( ID 
	 { 
	 	$programa::select_columns.add("-1"); 
	 	$programa::select_columns.add($ID.text);
	 } 
	| agg_funct ) col_list
	| /* ε */
	;
	
from
	: FROM ( ID { $programa::select_tables.add($ID.text); }
	| join_st ) NEWLINE? where? NEWLINE? group? NEWLINE? for_JSON_XML?
	;
	
join_st
	: table1 = ID JOIN table2 = ID join_st_aux
	 {
	 	$programa::select_tables.add($table1.text);
	 	$programa::select_tables.add($table2.text);
	 }
	;
	
join_st_aux
	: JOIN ID join_st_aux { $programa::select_tables.add($ID.text); }
	| /* ε */
	;
	
where
	: WHERE where_st
	;
	
where_st
	: ID comp_op value["1"] { $programa::condition.add($ID.text); }
	| ID null_op { $programa::condition.add($ID.text); }
	;
	
comp_op
	: GREATER_THAN { $programa::condition.add("2"); }
	| GREATER_EQUALS { $programa::condition.add("3"); }
	| LESS_THAN { $programa::condition.add("4"); }
	| LESS_EQUALS { $programa::condition.add("5"); }
	| EQUALS { $programa::condition.add("6"); }
	| LIKE { $programa::condition.add("7"); }
	| NOT { $programa::condition.add("8"); }
	;
	
null_op
	: IS ( NULL 
	 { 
	 	$programa::condition.add("1");
	 	$programa::condition.add("-1");
	 } 
	| NOT NULL  
	 { 
	 	$programa::condition.add("0");
	 	$programa::condition.add("-1");
	 } )
	;
	
group
	: GROUP BY cols
	;
	
cols
	: ID cols { $programa::column.add($ID.text); }
	|
	;
	
for_JSON_XML
	: FOR ( JSON { $programa::tmp = "0"; }
	| XML { $programa::tmp = "1"; } )
	;
	
agg_funct
	: ( COUNT { $programa::select_columns.add("0");  }
	| AVERAGE { $programa::select_columns.add("1");  }
	| MIN { $programa::select_columns.add("2");  }
	| MAX { $programa::select_columns.add("3");  } ) 
	LEFT_PAR ID { $programa::select_columns.add($ID.text);  } RIGHT_PAR
	;
	
update
	: UPDATE table = ID NEWLINE? SET column = ID EQUALS value["2"] NEWLINE? where NEWLINE*
	 {
	 	System.out.println("Updating column " + $column.text + " from table " + $table.text + "...");
	 	System.out.println("New value: " + $programa::tmp);
	 	System.out.println("Condition:");
	 	System.out.println($programa::condition);
	 	$programa::condition.clear();
	 	$programa::values.clear();
	 }
	;
	
delete
	: DELETE NEWLINE? FROM ID NEWLINE? where NEWLINE*
	 {
	 	System.out.println("Delete from table " + $ID.text);
	 	System.out.print("Condition: ");
	 	System.out.println($programa::condition);
	 	$programa::condition.clear();
	 	$programa::values.clear();
	 }
	;
	
insert
	: INSERT INTO ID LEFT_PAR cols RIGHT_PAR NEWLINE? VALUES LEFT_PAR values RIGHT_PAR NEWLINE*
	 {
	 	System.out.println("Insert into table " + $ID.text);
	 	if ($programa::column.size() != $programa::values.size()) {
	 		System.out.println("Error: Mismatch between columns and values");
	 	} else {
	 		System.out.print("Columns: ");
	 		System.out.println($programa::column);
	 		System.out.print("Values: ");
	 		System.out.println($programa::values);
	 	}
	 	$programa::column.clear();
	 	$programa::values.clear();
	 }
	;
	
values
	: value["0"] values
	|
	;
	
value [String sel]
	: INT 
	 { 
	 	if (sel.equals("0")) { $programa::values.add($INT.text); }
	 	else if (sel.equals("1")) { $programa::condition.add($INT.text); }
	 	else { $programa::tmp = $INT.text; }
	 }
	| FLOAT 
	 { 
	 	if (sel.equals("0")) { $programa::values.add($FLOAT.text); }
	 	else if (sel.equals("1")) { $programa::condition.add($FLOAT.text); }
	 	else { $programa::tmp = $FLOAT.text; }
	 }
	| ID 
	 { 
	 	if (sel.equals("0")) { $programa::values.add($ID.text); }
	 	else if (sel.equals("1")) { $programa::condition.add($ID.text); }
	 	else { $programa::tmp = $ID.text; }
	 }
	;
	
/* Comandos DDL */ 
ddl_commands
	: ( set_db
	| create_index
	| drop_table
	| alter_table
	| create_table ) ( ddl_commands
	| dml_commands
	| clp_commands )
	| /* ε */
	;
	
/* Fija el esquema actual */	
set_db
	: SET DATABASE ID NEWLINE* {System.out.println("Setting " + $ID.text + " as current database...");}
	 {
	 	// Fijar el esquema actual
	 }
	;

/* Crea un índice sobre una columna distinta a la llave primaria */	
create_index
	: CREATE INDEX index = ID ON NEWLINE? table = ID LEFT_PAR column = ID RIGHT_PAR NEWLINE* 
	 {
	 	System.out.println("Creating index " + $index.text + " on column " + $column.text + " from table " + $table.text 
	 	+ "...");
	 	
	 	// Crear índice
	 }
	;

/* Elimina una tabla */	
drop_table
	: DROP TABLE ID NEWLINE* {System.out.println("Deleting table " + $ID.text + "...");}
	 {
	 	// Eliminar tabla
	 }
	;
	
/* Establece integridad referencial sobre una columna */	
alter_table
	: ALTER TABLE ID NEWLINE? ADD CONSTRAINT const_def[$ID.text] NEWLINE*
	;
	
const_def [String table]
	: FOREIGN KEY LEFT_PAR column = ID RIGHT_PAR NEWLINE? REFERENCES r_table = ID LEFT_PAR r_column = ID RIGHT_PAR
	 {
	 	System.out.println("Column " + $column.text + " from table " + table + " references column " +
	 	$r_column.text + " from table " + $r_table.text);
	 }
	;
	
/* Crea una tabla */	
create_table
	: CREATE TABLE ID AS LEFT_PAR NEWLINE? col_def p_key RIGHT_PAR NEWLINE*
	 {
	 	Collections.reverse($programa::column);
	 	int j = 0;
	 	for (int k = 0; k < $programa::type_null.size(); k += 4) {
	 		Vector<String> v = new Vector<String>();
	 		v.add($programa::column.get(j));
	 		v.add($programa::type_null.get(k));
	 		v.add($programa::type_null.get(k + 1));
	 		v.add($programa::type_null.get(k + 2));
	 		v.add($programa::type_null.get(k + 3));
	 		$programa::columns.add(v);
	 		j++;
	 	}
		boolean pk = false;
		boolean pk_exists = false;
		for (int i = 0; i < $programa::columns.size(); i++) {
			Vector<String> v = $programa::columns.get(i);
			if (v.get(0).equals($programa::tmp)) {
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
	 		System.out.println("Table: " + $ID.text);
	 		System.out.println("Columns:");
	 		for(int i = 0; i < $programa::columns.size(); i++) {
	 			System.out.println($programa::columns.get(i));
	 		}
	 		System.out.println("Primary key: " + $programa::tmp);
	 	}
	 	$programa::column.clear();
	 	$programa::type_null.clear();
	 	$programa::columns.clear();
	 }
	;
	
/* Definición de columnas */	
col_def
	: ID type null_cons NEWLINE? col_def
	 {
	 	//$programa::columns.add($programa::column);
	 	//$programa::column.clear();
	 	//$programa::column.add($ID.text);
	 	//System.out.println($ID.text);
	 	$programa::column.add($ID.text);
	 }
	| /* ε */
	;
	
/* Tipos de datos */	
type
	: INTEGER 
	 { 
	 	$programa::type_null.add("0");
	 	$programa::type_null.add("-1");
	 	$programa::type_null.add("-1");
	 	//System.out.println($INTEGER.text);
	 }
	| DECIMAL LEFT_PAR digits = INT COLON decimals = INT RIGHT_PAR 
	 { 
	 	$programa::type_null.add("1");
	 	$programa::type_null.add($digits.text);
	 	$programa::type_null.add($decimals.text);
	 	//System.out.println($DECIMAL.text);
	 }
	| CHARACTER LEFT_PAR INT RIGHT_PAR 
	 { 
	 	$programa::type_null.add("2");
	 	$programa::type_null.add($INT.text);
	 	$programa::type_null.add("-1");
	 	//System.out.println($CHARACTER.text);
	 }
	| VARCHAR 
	 { 
	 	$programa::type_null.add("3");
	 	$programa::type_null.add("-1");
	 	$programa::type_null.add("-1");
	 	//System.out.println($VARCHAR.text);
	 }
	| DATETIME 
	 { 
	 	$programa::type_null.add("4"); 
	 	$programa::type_null.add("-1");
	 	$programa::type_null.add("-1");
	 	//System.out.println($DATETIME.text);
	 }
	;
	
/* Restricción de NULL */	
null_cons
	: NULL 
	 { 
	 	$programa::type_null.add("1");
	 	//System.out.println("NULL");
	 }
	| NOT NULL 
	 { 
	 	$programa::type_null.add("0");
	 	//System.out.println("NOT NULL");
	 }
	;
	
/* Llave primaria */	
p_key
	: PRIMARY KEY LEFT_PAR ID RIGHT_PAR NEWLINE?
	 {
	 	$programa::tmp = $ID.text;
	 }
	;

/* Comandos CLP */ 
clp_commands
	: ( create_db
	| drop_db
	| list_db
	| start
	| get_status
	| stop
	| display_db ) ( clp_commands
	| dml_commands
	| ddl_commands )
	| /* ε */
	;

/* Crear un nuevo esquema */	
create_db
	: CREATE DATABASE ID NEWLINE* {System.out.println("Creating database " + $ID.text + "...\n");}
	 {
	 	// Crear base de datos
	 }
	;

/* Eliminar un esquema */	
drop_db
	: DROP DATABASE ID NEWLINE* {System.out.println("Deleting database " + $ID.text + "...\n");}
	 {
	 	// Eliminar base de datos
	 }
	;

/* Muestra los esquemas existentes */	
list_db
	: LIST DATABASES NEWLINE* {System.out.println("Listing databases...\n");}
	 {
	 	// Mostrar las bases de datos que hay
	 }
	;

/* Inicia los procesos */	
start
	: START NEWLINE* {System.out.println("Starting processes...\n");}
	 {
	 	// Iniciar los procesos
	 }
	;

/* Obtiene el estado del motor */	
get_status
	: GET STATUS NEWLINE* {System.out.println("Obtaining status...\n");}
	 {
	 	// Obtener el estado de los procesos
	 }
	;

/* Detiene los procesos */	
stop
	: STOP NEWLINE* {System.out.println("Stoping processes...\n");}
	 {
	 	// Detener los procesos
	 }
	;

/* Muestra el esquema seleccionado */	
display_db
	: DISPLAY DATABASE ID NEWLINE* {System.out.println("Displaying database " + $ID.text + "...\n");}
	 {
	 	// Mostrar la base de datos indicada
	 }
	;
	
SELECT
	: 'SELECT'
	| 'select'
	;
	
ALL
	: '*'
	;
	
FROM
	: 'FROM'
	| 'from'
	;
	
JOIN
	: 'JOIN'
	| 'join'
	;
	
WHERE
	: 'WHERE'
	| 'where'
	;
	
GREATER_THAN
	: '>'
	;
	
GREATER_EQUALS
	: '>='
	;
	
LESS_THAN
	: '<'
	;
	
LESS_EQUALS
	: '<='
	;
	
EQUALS
	: '='
	;
	
LIKE
	: 'LIKE'
	| 'like'
	;
	
IS
	: 'IS'
	| 'is'
	;
	
GROUP
	: 'GROUP'
	| 'group'
	;
	
BY
	: 'BY'
	| 'by'
	;
	
FOR
	: 'FOR'
	| 'for'
	;
	
JSON
	: 'JSON'
	| 'json'
	;
	
XML
	: 'XML'
	| 'xml'
	;
	
COUNT
	: 'COUNT'
	| 'count'
	;
	
AVERAGE
	: 'AVERAGE'
	| 'average'
	;
	
MIN
	: 'MIN'
	| 'min'
	;
	
MAX
	: 'MAX'
	| 'max'
	;
	
UPDATE
	: 'UPDATE'
	| 'update'
	;
	
DELETE
	: 'DELETE'
	| 'delete'
	;
	
INSERT
	: 'INSERT'
	| 'insert'
	;
	
INTO
	: 'INTO'
	| 'into'
	;
	
VALUES
	: 'VALUES'
	| 'values'
	;

CREATE
	: 'CREATE'
	| 'create'
	;
	
DATABASE
	: 'DATABASE'
	| 'database'
	;
	
DROP
	: 'DROP'
	| 'drop'
	;
	
LIST
	: 'LIST'
	| 'list'
	;
	
DATABASES
	: 'DATABASES'
	| 'databases'
	;
	
START
	: 'START'
	| 'start'
	;
	
GET
	: 'GET'
	| 'get'
	;
	
STATUS
	: 'STATUS'
	| 'status'
	;
	
STOP
	: 'STOP'
	| 'stop'
	;
	
DISPLAY
	: 'DISPLAY'
	| 'display'
	;
	
NEWLINE
	: '\n'
	;
	
SET
	: 'SET'
	| 'set'
	;
	
INDEX
	: 'INDEX'
	| 'index'
	;
	
ON
	: 'ON'
	| 'on'
	;
	
TABLE
	: 'TABLE'
	| 'table'
	;
	
ALTER
	: 'ALTER'
	| 'alter'
	;
	
ADD
	: 'ADD'
	| 'add'
	;
	
CONSTRAINT
	: 'CONSTRAINT'
	| 'constraint'
	;
	
FOREIGN
	: 'FOREIGN'
	| 'foreign'
	;
	
KEY
	: 'KEY'
	| 'key'
	;
	
REFERENCES
	: 'REFERENCES'
	| 'references'
	;
	
AS
	: 'AS'
	| 'as'
	;
	
INTEGER
	: 'INTEGER'
	| 'integer'
	;
	
DECIMAL
	: 'DECIMAL'
	| 'decimal'
	;
	
LEFT_PAR
	: '('
	;
	
COLON
	: ','
	;
	
RIGHT_PAR
	: ')'
	;
	
CHARACTER
	: 'CHAR'
	| 'char'
	;
	
VARCHAR
	: 'VARCHAR'
	| 'varchar'
	;
	
DATETIME
	: 'DATETIME'
	| 'datetime'
	;
	
NULL
	: 'NULL'
	| 'null'
	;
	
NOT
	: 'NOT'
	| 'not'
	;
	
PRIMARY
	: 'PRIMARY'
	| 'primary'
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
