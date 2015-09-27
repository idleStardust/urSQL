package urSQL.API;

import java.io.IOException;

import urSQL.QueryProcessor.QueryProcessor;


public class Statement 
{
	private String schema; // Base de datos actual
	private boolean closed; // Bandera de apertura de conexión
	private QueryProcessor q_proc; // Parser
	
	public Statement() {
		this.schema = ""; // No hay base actual
		this.closed = true; // No hay sentencia abierta
		this.q_proc = new QueryProcessor(); // Inicializa el parser
	}
	
	public Statement(String schema) {		
		this.schema = schema; // Base actual
		this.closed = true; // No hay sentencia abierta
		this.q_proc = new QueryProcessor(); // Inicializa el parser
	}
	
	public String getSchema()
	{
		return this.schema; // Obtiene la base actual
	}
	
	public boolean getClosed()
	{
		return this.closed; // Obtiene el estado de la sentencia
	}
	
	public QueryProcessor getQ_Proc()
	{
		return this.q_proc; // Obtiene el parser
	}
	
	public ResultSet executeQuery(String sql) throws IOException {
		if (this.closed) {
			this.closed = false; // Abre la sentencia
			this.q_proc.setQuery(sql); // Actualiza la sentencia SQL
			this.q_proc.execute(); // Ejecuta la sentencia
			ResultSet rs = new ResultSet();
			return rs;
		} else {
			System.out.println("Statement not closed"); 
			return null;
		}
	}
	
	public int executeUpdate(String sql) throws IOException {
		if (this.closed) {
			this.closed = false; // Abre la sentencia
			this.q_proc.setQuery(sql); // Actualiza la sentencia SQL
			this.q_proc.execute(); // Ejecuta la sentencia
			return 0;
		} else {
			System.out.println("Statement not closed");
			return -1; // Retorna -1 si no se pudo ejecutar
		}
	}
	
	public boolean execute(String sql) throws IOException {
		if (this.closed) {
			this.closed = false; // Abre la sentencia
			this.q_proc.setQuery(sql); // Actualiza la sentencia SQL
			this.q_proc.execute(); // Ejecuta la sentencia
			return true;
		} else {
			System.out.println("Statement not closed");
			return false; // Retorna falso si no se pudo ejecutar
		}
	}
	
	public boolean close() {
		this.closed = true; // Cierra la sentencia
		return this.closed;
	}
}
