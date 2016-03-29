package br.ufsm.csi.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectDB {
	
	public static Connection getConexao() {

		Connection conn = null;
		
		String url = "jdbc:postgresql://200.132.36.197:5432/internetb";
		String user = "postgres";
		String password = "cijkd";

		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
