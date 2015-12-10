package br.com.cepep.agenda.logica;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;
import br.com.cepep.agenda.logica.Logica;

public class EditaContato implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.consultarPessoa(Integer.parseInt(id));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/editar-contato.jsp");
		req.setAttribute("pessoa", pessoa);
		requestDispatcher.forward(req, res);
	}

}
