package urSQL.API;

public class DriverManager {
	public DriverManager() {
		
	}
	
	// Crea un objeto Connection para conectar con la base de datos
	public static Connection getConnection(String url) {
		Connection conn = new Connection(url);
		return conn;
	}
}