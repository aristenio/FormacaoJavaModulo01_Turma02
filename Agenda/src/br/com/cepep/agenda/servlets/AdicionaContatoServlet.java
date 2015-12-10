package br.com.cepep.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

@WebServlet(name = "adicionarContato", urlPatterns = {"/addContato"})
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
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/contato-adicionado.jsp?nome="+pessoa.getNome());
		requestDispatcher.forward(req, res);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		contador++; // a cada requisição a mesma variável é incrementada
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adicionar-contato.jsp");
		requestDispatcher.forward(req, res);
	}
	
}
