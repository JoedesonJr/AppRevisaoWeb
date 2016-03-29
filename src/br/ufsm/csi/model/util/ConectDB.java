package br.ufsm.csi.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectDB {
	
	public static Connection getConexao() {

		Connection conn = null;
		
		String url = "jdbc:postgresql://localhost:5432/internetb";
		String user = "postgres";
		String password = "1234";

		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
