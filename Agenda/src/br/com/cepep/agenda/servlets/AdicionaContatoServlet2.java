package br.com.cepep.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

public class AdicionaContatoServlet extends HttpServlet {
	
	private int contador = 0; //variavel de instância

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = new Pessoa();
		String nome = req.getParameter("nome");
		pessoa.setNome(nome);

		String dtNasc = req.getParameter("dataNascimento");
		try {
			Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dtNasc);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			dao.inserePessoa(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + pessoa.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		contador++; // a cada requisição a mesma variável é incrementada
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"adicionaContato\" method=\"POST\">");
		out.println("Nome: <input type=\"text\" name=\"nome\" /><br />");
		out.println("E-mail: <input type=\"text\" name=\"email\" /><br />");
		out.println("Endereço: <input type=\"text\" name=\"endereco\" /><br />");
		out.println("Data Nascimento: <input type=\"text\" name=\"dataNascimento\" /><br />");
		out.println("<input type=\"submit\" value=\"Gravar\" />");
		out.println("</form>");
		out.println("Contador agora é: " + contador);
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
