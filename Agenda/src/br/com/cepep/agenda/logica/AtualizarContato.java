package br.com.cepep.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

public class AtualizarContato implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Integer.parseInt(req.getParameter("id")));
		pessoa.setNome(req.getParameter("nome"));
		pessoa.setCelular(req.getParameter("celular"));
		pessoa.setFixo(req.getParameter("fixo"));
		dao.editaPessoa(pessoa);
		new ListaContato().executa(req, res);
	}

}
