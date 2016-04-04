package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.model.dao.UsuarioDAO;

public class AlterarUsuarioLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String idUsuario = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Alterar usuario: " +idUsuario);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		String pagina = "/WEB-INF/JSP/cadastrarUsuario.jsp";
		
		try {
			boolean retorno = uDAO.AlterarUsuario(idUsuario, login, senha);
		
			if(retorno)			
				request.setAttribute("statusAlterarUsuario", "USUARIO ALTERADO!");
			else
				request.setAttribute("statusAlterarUsuario", "ERRO! USUARIO NAO ALTERADO!");
		} catch (Exception e) {
			e.printStackTrace();
			
			return pagina;
		}
		request.setAttribute("usuarios", new UsuarioDAO().getUsuarios());
		
		return pagina;
	}

}
