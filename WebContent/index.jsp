<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Revis�o Web</title>
</head>
<body>
	
	<c:if test="${not empty statusLogin}">
		<h2> USUARIO OU SENHA INVALIDOS! </h2>
	</c:if>
	
	<form action="/AppRevisaoWeb/mvc?logica=LogarLogica" method="post">
		<br/> <label for="login"> Login </label> <br/>
		<input type="text" id="Login" name="login" /> <br/>
		
		<br/> <label for="Senha"> Senha </label> <br/>
		<input type="text" id="Senha" name="senha" /> <br/><br/>
		
		<button type="submit" name="opcao" value="logar"> Logar </button>
	</form>

</body>
</html>