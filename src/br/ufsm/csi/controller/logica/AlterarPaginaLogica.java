package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.dao.UsuarioDAO;

public class AlterarPaginaLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entro Inserir Pagina");
		String idUsuario = request.getParameter("id");
		
		request.setAttribute("usuarioAlterar", idUsuario);
		
		return "/WEB-INF/JSP/alterarUsuario.jsp";
	}
	
}
