package br.com.cepep.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

@WebServlet(name = "olaServlet", urlPatterns = {"/ola", "/oi"})
public class OlaServlet extends HttpServlet {

	private List<Pessoa> listarPessoas;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PessoaDao dao = new PessoaDao();
		try {
			listarPessoas = dao.getListaPessoas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Primeira servlet");
		for (Pessoa pessoa : listarPessoas) {
			out.println(pessoa.getNome());
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
