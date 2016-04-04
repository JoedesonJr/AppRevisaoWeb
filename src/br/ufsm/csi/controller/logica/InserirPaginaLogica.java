package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.dao.UsuarioDAO;

public class InserirPaginaLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entro Inserir Pagina");
		request.setAttribute("usuarios", new UsuarioDAO().getUsuarios());
		
		return "/WEB-INF/JSP/cadastrarUsuario.jsp";
	}

}
