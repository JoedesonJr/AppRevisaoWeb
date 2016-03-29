package br.ufsm.csi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.model.util.ConectDB;

public class UsuarioDAO {

	public boolean autenticarUsuario(Usuario usuario) throws Exception {

		boolean autenticado = false;

		Connection conn = (Connection) ConectDB.getConexao();
		
		String sql = "SELECT * FROM usuario WHERE login =? AND senha =? ;";
		PreparedStatement stmtPre = conn.prepareStatement(sql);
		
		stmtPre.setString(1, usuario.getLogin());
		stmtPre.setString(2, usuario.getSenha());
		
		ResultSet rs = stmtPre.executeQuery();
		
		while(rs.next()){
			autenticado = true;
		}
		
		return autenticado;
	}
	
	public boolean inserirUsuario(Usuario usuario) throws Exception {

		int autenticado = 0;

		Connection conn = (Connection) ConectDB.getConexao();
		
		String sql = "INSERT INTO usuario VALUES (default,'"+usuario.getLogin()+"','"+usuario.getSenha()+"') ;";
		Statement stmt = conn.createStatement();

		try{
			autenticado = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(autenticado > 0)
			return true;
		else
			return false;
	}
}
