package br.com.cepep.agenda.logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.logica.Logica;

public class DeletaContato implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		PessoaDao dao = new PessoaDao();
		dao.deletaPessoa(Integer.parseInt(id));
		new ListaContato().executa(req, res);
	}

}
