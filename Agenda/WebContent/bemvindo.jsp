<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cepep.agenda.dao.PessoaDao,br.com.cepep.agenda.entidades.Pessoa,java.util.List,java.sql.SQLException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = "Bem vindo!";
PessoaDao dao = new PessoaDao();
List<Pessoa> listarPessoas = null;
try {
	listarPessoas = dao.listarPessoas();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
for (Pessoa pessoa : listarPessoas) {
%>
	<li>
	<%= pessoa.getNome() %>
	</li>
<%
}
%>
%>
<h1>
	<%
	out.println(msg);
	%>
</h1>

<b>
<%= msg %>
</b>
</body>
</html>