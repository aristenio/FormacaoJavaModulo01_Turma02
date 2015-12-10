package br.com.cepep.agenda.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

public class ListaContato implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PessoaDao dao = new PessoaDao();
		List<Pessoa> pessoas = dao.getListaPessoas();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lista-contatos.jsp");
		req.setAttribute("listaPessoas", pessoas);
		requestDispatcher.forward(req, res);
	}

}
