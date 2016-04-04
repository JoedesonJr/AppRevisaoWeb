package br.ufsm.csi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
	
	public ArrayList <Usuario> getUsuarios(){
		
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		
		Connection conn = (Connection) ConectDB.getConexao();
		
		try{	
			PreparedStatement stmt =  conn.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Usuario u = new Usuario();
				
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));

				usuarios.add(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public boolean RemoverUsuario(String id) throws Exception {

		int remover = 0;

		Connection conn = (Connection) ConectDB.getConexao();
		
		String sql = "DELETE FROM usuario WHERE id = '"+id+"';";
		Statement stmt = conn.createStatement();

		try{
			remover = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(remover > 0)
			return true;
		else
			return false;
	}
	
	public boolean AlterarUsuario(String id, String login, String senha) throws Exception {

		int alterar = 0;

		Connection conn = (Connection) ConectDB.getConexao();
		
		String sql = "UPDATE usuario SET login = '"+login+"', senha = '"+senha+"' WHERE id = '"+id+"' ";
		
		Statement stmt = conn.createStatement();

		try{
			alterar = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(alterar > 0)
			return true;
		else
			return false;
	} 
}
