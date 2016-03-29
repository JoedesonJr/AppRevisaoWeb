package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		System.out.println("Entro executa no LogarLogica");
		
		return "/WEB-INF/JSP/principal.jsp";
	}

}
