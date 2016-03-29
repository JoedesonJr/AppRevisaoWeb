package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirPaginaLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Entro Inserir Pagina");
		
		return "/WEB-INF/JSP/cadastrarUsuario.jsp";
	}

}
