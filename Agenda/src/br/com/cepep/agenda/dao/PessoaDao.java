package br.com.cepep.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cepep.agenda.entidades.Pessoa;

public class PessoaDao {

	private Connection conexao;
	private String tabela = "pessoas";
	private String sqlListar = "select * from " + tabela;
	private String sqlConsultar = "select * from " + tabela + " where id=?";
	private String sqlInserir = "insert into " + tabela + " (nome,email,celular,fixo) values (?,?,?,?)";
	private String sqlEditar = "update " + tabela + " set nome = ?, email = ?, celular = ?, fixo = ? where id = ?";
	private String sqlDeletar = "delete from " + tabela + " where id=?";

	public PessoaDao() {
		String url = "jdbc:mysql://33.33.33.1/agenda?user=root&password=root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> getListaPessoas() throws SQLException {
		List<Pessoa> retorno = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sqlListar);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCelular(rs.getString("celular"));
			pessoa.setFixo(rs.getString("fixo"));
			pessoa.setEmail(rs.getString("email"));
			// String dat = rs.getDate("datanascimento").toString();
			// SimpleDateFormat DATE_FORMAT = new
			// SimpleDateFormat("yyyy-MM-dd");
			// DATE_FORMAT.format(new Dat)
			// java.util.Date dataNascimento = new java.util.Date();
			// dataNascimento.setYear(date.getYear());
			// dataNascimento.setMonth(date.getMonth());
			// dataNascimento.setDate(date.getDay());
			pessoa.setDataNascimento(new Date());
			retorno.add(pessoa);
		}

		return retorno;
	}

	public void inserePessoa(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlInserir);

		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getEmail());
		ps.setString(3, pessoa.getCelular());
		ps.setString(4, pessoa.getFixo());

		ps.execute();

		ps.close();
	}

	public void deletaPessoa(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlDeletar);

		ps.setInt(1, id);
		ps.execute();
		ps.close();
	}

	public Pessoa consultarPessoa(int id) throws SQLException {

		PreparedStatement ps = conexao.prepareStatement(sqlConsultar);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCelular(rs.getString("celular"));
			pessoa.setFixo(rs.getString("fixo"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setDataNascimento(new Date());
			return pessoa;
		}

		return null;

	}

	public void editaPessoa(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlEditar);

		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getEmail());
		ps.setString(3, pessoa.getCelular());
		ps.setString(4, pessoa.getFixo());
		ps.setInt(5, pessoa.getId());

		ps.execute();

		ps.close();

	}

}
