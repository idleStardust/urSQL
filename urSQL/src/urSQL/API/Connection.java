package urSQL.API;

public class Connection {
	private String current_schema; // Base actual
	private boolean closed; // Bandera de apertura de conexión
	
	public Connection() {
		this.current_schema = ""; // No hay base actual
		this.closed = true; // Aún no existe conexión
	}
	
	public Connection(String url) {
		String[] items = url.split("\\\\");
		this.current_schema = items[items.length - 1]; // Actualiza la base actual
		this.closed = true; // Aún no existe conexión
	}
	
	public String getSchema() {
		return this.current_schema; // Retorna la base actual
	}
	
	public boolean getClosed()
	{
		return this.closed; // Retorna el estado de la conexión
	}
	
	public Statement createStatement() {
		if (this.closed) { // Si está cerrado puede habilitar una conexión
			this.closed = false; // Abre una conexión
			Statement stmt = new Statement(this.current_schema); // Crea un objeto Statement
			return stmt;
		} else {
			System.out.println("Connection not closed"); // Si ya hay conexión no puede abrir otra
			return null;
		}
	}
	
	public boolean close() {
		this.closed = true; // Cierra la conexión actual
		return this.closed;
	}
}
