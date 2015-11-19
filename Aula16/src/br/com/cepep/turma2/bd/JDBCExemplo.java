package br.com.cepep.turma2.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCExemplo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://33.33.33.1/ESCOLA?user=root&password=root";
		try {
			Connection conexao = DriverManager.getConnection(url);
			System.out.println("Conexão estabelecida com sucesso");
			
			String sql = "select * from ALUNO;";
			
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			List<Aluno> alunos = new ArrayList<>();
			
			while(resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(resultSet.getInt("matricula"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setEmail(resultSet.getString("email"));
				aluno.setTelefone(resultSet.getString("telefone"));
				aluno.setAltura(resultSet.getDouble("altura"));
				aluno.setAprovado(resultSet.getBoolean("aprovado"));
				alunos.add(aluno);
			}
			
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
				
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar com o BD");
			e.printStackTrace();
		}
		
	}
}
