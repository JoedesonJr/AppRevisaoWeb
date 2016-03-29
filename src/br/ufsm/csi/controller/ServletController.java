package br.ufsm.csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.model.dao.UsuarioDAO;

@WebServlet("/servletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		
		RequestDispatcher dispatcher;
		
		if(opcao.equals("logar")){
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			UsuarioDAO uDAO = new UsuarioDAO();
			
			String pagina = "/index.jsp";
			
			try {
				boolean retorno = uDAO.autenticarUsuario(usuario);
			
				if(retorno){
					pagina = "/WEB-INF/JSP/principal.jsp";
					
					request.setAttribute("statusLogin", usuario);
				}else
					request.setAttribute("statusLogin", "Erro ao logar!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		else if(opcao.equals("principalCadastrarUSuario")){
			dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/cadastrarUsuario.jsp");
			dispatcher.forward(request, response);
		}
		else if(opcao.equals("cadastrarUsuario")){
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			System.out.println(login);
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			UsuarioDAO uDAO = new UsuarioDAO();
			
			try {
				boolean retorno = uDAO.inserirUsuario(usuario);
			
				if(retorno)			
					request.setAttribute("statusCadastroUsuario", "USUARIO CADASTRADO!");
				else
					request.setAttribute("statusCadastroUsuario", "ERRO! USUARIO NAO CADASTRADO!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/cadastrarUsuario.jsp");
			dispatcher.forward(request, response);
		}
		
		/* senha: 'or'1'='1 | '; DROP TABLE usuario; -- */
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
