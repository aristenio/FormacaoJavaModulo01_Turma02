package br.com.cepep.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cepep.agenda.entidades.Pessoa;

public class PessoaDao {

	private Connection conexao;
	private String tabela = "pessoas";
	private String sqlListar = "select * from " + tabela;
	private String sqlConsultar = "select * from " + tabela + " where id=?";
	private String sqlInserir = "insert into " + tabela + " (nome,celular) values (?,?)";
	private String sqlEditar = "update " + tabela + " set nome = ?, celular = ? where id = ?";
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
			retorno.add(pessoa);
		}

		return retorno;
	}

	public void inserePessoa(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlInserir);

		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getCelular());

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
			return pessoa;
		}

		return null;

	}

	public void editaPessoa(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlEditar);

		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getCelular());
		ps.setInt(3, pessoa.getId());

		ps.execute();

		ps.close();

	}

}
