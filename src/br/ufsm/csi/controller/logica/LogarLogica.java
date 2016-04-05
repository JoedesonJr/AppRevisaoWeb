package br.ufsm.csi.controller.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.model.dao.UsuarioDAO;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Entro executa no LogarLogica");
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		String pagina = "/index.jsp";
		
		request.setAttribute("statusLogin", "Erro ao logar!");
		
		try {
			boolean retorno = uDAO.autenticarUsuario(usuario);
		
			if(retorno){
				pagina = "/WEB-INF/JSP/principal.jsp";
				
				request.getSession().setAttribute("statusLogin", usuario);
				
				request.setAttribute("statusLogin", usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return pagina;
		}
		
		return pagina;
	}

}
