package br.ufsm.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.dao.UsuarioDAO;

public class RemoverUsuarioLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String idUsuario = request.getParameter("id");
		
		System.out.println("Remover usuario: " +idUsuario);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		String pagina = "/WEB-INF/JSP/cadastrarUsuario.jsp";
		
		try {
			boolean retorno = uDAO.RemoverUsuario(idUsuario);
		
			if(retorno)			
				request.setAttribute("statusRemoverUsuario", "USUARIO REMOVIDO!");
			else
				request.setAttribute("statusRemoverUsuario", "ERRO! USUARIO NAO REMOVIDO!");
		} catch (Exception e) {
			e.printStackTrace();
			
			return pagina;
		}
		request.setAttribute("usuarios", new UsuarioDAO().getUsuarios());
		
		return pagina;
	}
}
