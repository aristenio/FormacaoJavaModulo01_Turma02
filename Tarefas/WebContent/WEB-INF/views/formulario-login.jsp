<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de tarefas</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div id="content" class="container_16 clearfix">
		<form action="efetuaLogin" method="post">
			<div class="grid_10">
				<p>
					<label for="title">Login:</label> <input type="text" name="login"/><br/>
					<label>Senha:</label> <input type="password" name="password"/><br/>
				</p>
			</div>
			<div class="grid_16">
				<p class="submit">
					<input type="submit" value="Entrar" />
				</p>
			</div>
		</form>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>