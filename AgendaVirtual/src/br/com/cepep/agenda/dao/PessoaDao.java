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
	private String sqlListar = "select * from "+tabela;
	private String sqlInserir = "insert into pessoa (nome,email,celular,fixo) values (?,?,?,?)";
	
	public PessoaDao() {
		String url = "jdbc:mysql://33.33.33.1/AGENDA?user=root&password=root";
		try {
			conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Pessoa> listarPessoas() throws SQLException{
		List<Pessoa> retorno = new ArrayList<>();
		
		PreparedStatement ps = conexao.prepareStatement(sqlListar);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCelular(rs.getString("celular"));
		}
		
		return retorno;
	}
	
	public void inserePessoa(Pessoa pessoa) throws SQLException{
		PreparedStatement ps = conexao.prepareStatement(sqlInserir);
		
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getEmail());
		ps.setString(3, pessoa.getCelular());
		ps.setString(4, pessoa.getFixo());
		
		ps.execute();
		
		ps.close();
	}
	
}
