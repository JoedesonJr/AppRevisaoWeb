<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuário</title>
</head>
<body>
	<h1>Cadastrar Usuario</h1>
	
	<section>
		<form action="/AppRevisaoWeb/mvc?logica=InserirUsuarioLogica" method="post">
			<br/> <label for="login"> Login </label> <br/>
			<input type="text" id="Login" name="login" /> <br/>
			
			<br/> <label for="Senha"> Senha </label> <br/>
			<input type="text" id="Senha" name="senha" /> <br/><br/>
			
			<button type="submit" name="opcao" value="cadastrarUsuario"> Logar </button>
		</form>
	</section>
	
	<br/><c:if test="${not empty statusCadastroUsuario}">
		<h2> ${statusCadastroUsuario} </h2>
	</c:if>
	
	<c:if test="${not empty statusRemoverUsuario}">
		<h2> ${statusRemoverUsuario} </h2>
	</c:if>
	
	<c:if test="${not empty statusAlterarUsuario}">
		<h2> ${statusAlterarUsuario} </h2>
	</c:if>
	
	<section>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
				<tr>
					<th>Login</th>
					<th></th>
					<th>Senha</th>
					<th></th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.login}</td>
						<th></th>
						<td>${usuario.senha}</td>
						<th></th>
						<td>
							<a class="btn btn-danger" 
								href="/AppRevisaoWeb/mvc?logica=AlterarPaginaLogica&&id=${usuario.id}">Alterar</a>
							<a class="btn btn-danger"
								href="/AppRevisaoWeb/mvc?logica=RemoverUsuarioLogica&&id=${usuario.id}">Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
</body>
</html>