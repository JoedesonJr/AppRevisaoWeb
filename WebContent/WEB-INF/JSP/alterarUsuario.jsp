<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Usuario</title>
</head>
<body>
	<h1>Alterar Usuario</h1>

	<section>
		<form action="/AppRevisaoWeb/mvc?logica=AlterarUsuarioLogica&&id=${usuarioAlterar}" method="post">
			<br/> <label for="login"> Login </label> <br/>
			<input type="text" id="Login" name="login" /> <br/>
			
			<br/> <label for="Senha"> Senha </label> <br/>
			<input type="text" id="Senha" name="senha" /> <br/><br/>
			
			<button type="submit" name="opcao" value="cadastrarUsuario"> Alterar </button>
		</form>
	</section>
</body>
</html>