package br.com.cepep.agenda.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContato implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adicionar-contato.jsp");
		requestDispatcher.forward(req, res);
	}

}
