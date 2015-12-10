package br.com.cepep.agenda.servlets;

import java.io.IOException;
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

import br.com.cepep.agenda.logica.Logica;


@WebServlet(name = "contato", urlPatterns = { "/contatos" })
public class ContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String acao = req.getParameter("acao");
			String nomeDaClasse = "br.com.cepep.agenda.logica."+acao;
			Class classe = Class.forName(nomeDaClasse);
			Object objeto = classe.newInstance();
			Logica classeLogica = (Logica) objeto;
			classeLogica.executa(req, res);
			
		} catch (Exception e) {
			System.err.println("Ocorreu uma falha na execução da logica");
		}

	}
}
