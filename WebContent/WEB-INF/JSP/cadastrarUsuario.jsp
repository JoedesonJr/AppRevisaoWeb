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
	
	<form action="/AppRevisaoWeb/servletController" method="post">
		<br/> <label for="login"> Login </label> <br/>
		<input type="text" id="Login" name="login" /> <br/>
		
		<br/> <label for="Senha"> Senha </label> <br/>
		<input type="text" id="Senha" name="senha" /> <br/><br/>
		
		<button type="submit" name="opcao" value="cadastrarUsuario"> Logar </button>
	</form>
	
	<c:if test="${not empty statusCadastroUsuario}">
		<h2> ${statusCadastroUsuario} </h2>
	</c:if>
</body>
</html>