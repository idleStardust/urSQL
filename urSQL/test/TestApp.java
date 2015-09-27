package test;

import java.io.IOException;

import urSQL.API.*;

public class TestApp {
	static final String DB_URL = "\\home\\hector\\Descargas";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		conn = DriverManager.getConnection(DB_URL);
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT * FROM concha";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.close();
		sql = "LIST DATABASES";
		try {
			int x = stmt.executeUpdate(sql);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.close();
		conn.close();
		System.out.println(conn.getSchema());
	}

}
