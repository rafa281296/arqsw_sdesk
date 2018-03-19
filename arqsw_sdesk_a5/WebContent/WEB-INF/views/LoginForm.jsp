<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navega��o -->
    <c:import url="Menu.jsp" />
    
   <div id="main" class = "container">
   	<h3 class = "page-header">Login</h3>
   	<form action = "efetua_login" method = post>
   	<div class="row">
   	<div class="form-group col-md-4">
   	<label for="login">Usuario:</label>
   	<input class = "form-control" type="text" name="username" id="username">
   	<label for= "senha">Senha:</label>
   	<input class = "form-control" type="text" name="password" id="password">
   	</div>
   	</div>
   	<div id="actions" class="row">
   	<div class="col-md-12">
   		<button type="submit" class="btn btn-primary" name="acao" valeu="efetua_login">Entrar</button>
   	</div>
   	</div>
   	</form>
   </div>

</body>
</html>