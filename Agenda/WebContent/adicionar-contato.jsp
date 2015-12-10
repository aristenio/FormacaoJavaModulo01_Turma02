<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Adicionar Contato</title>
	</head>
	<body>
		<form action="contatos" method="POST">
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="text" name="email" /><br />
			Endereço: <input type="text" name="endereco" /><br />
			Data Nascimento: <input type="text" name="dataNascimento" /><br />
			<input type="hidden" name="acao" value="AdicionaContato">
			<input type="submit" value="Gravar" />
		</form>
	</body>
</html>