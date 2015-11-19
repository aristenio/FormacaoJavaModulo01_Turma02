package br.com.cepep.turma2.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperacoes {
	public static void main(String[] args) {
		String url = "jdbc:mysql://33.33.33.1/ESCOLA?user=root&password=root";
		try {
			Connection conexao = DriverManager.getConnection(url);
			System.out.println("Conexão estabelecida com sucesso");
			
			String sql = "INSERT INTO ALUNO (nome, email, telefone, altura, aprovado) VALUES (?,?,?,?,?);";
			
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			
			prepareStatement.setString(1, "Jośe");
			prepareStatement.setString(2, "jose@gmail.com");
			prepareStatement.setString(3, "8769797");
			prepareStatement.setDouble(4, 1.63);
			prepareStatement.setBoolean(5, true);
			
			prepareStatement.execute();
			
			String sql2 = "select * from ALUNO;";
			
			PreparedStatement prepareStatement2 = conexao.prepareStatement(sql2);
			
			ResultSet resultSet = prepareStatement2.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("Matricula: "+resultSet.getInt("matricula"));
				System.out.println("Nome: "+resultSet.getString("nome"));
				System.out.println("Altura: "+ resultSet.getDouble("altura"));
				System.out.println("Aprovado? "+resultSet.getBoolean("aprovado"));
			}
			
				
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar com o BD");
			e.printStackTrace();
		}
	}
}
