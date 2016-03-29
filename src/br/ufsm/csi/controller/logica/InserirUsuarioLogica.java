package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.model.dao.UsuarioDAO;

public class InserirUsuarioLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		String pagina = "/WEB-INF/JSP/cadastrarUsuario.jsp";
		
		try {
			boolean retorno = uDAO.inserirUsuario(usuario);
		
			if(retorno)			
				request.setAttribute("statusCadastroUsuario", "USUARIO CADASTRADO!");
			else
				request.setAttribute("statusCadastroUsuario", "ERRO! USUARIO NAO CADASTRADO!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return pagina;
		}
		
		return pagina;
	}

}
