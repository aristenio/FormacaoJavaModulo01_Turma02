package br.com.cepep.agenda.logica;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;
import br.com.cepep.agenda.logica.Logica;

public class AdicionaContato implements Logica{
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
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
}
