package br.com.cepep.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cepep.tarefas.model.Tarefa;

@Repository("jdbcTarefasDao")
public class JdbcTarefasDao implements TarefasDao{
	
	private Connection conexao;
	
	private String tabela = "tarefas";
	private String sqlListar = "select * from " + tabela;
	private String sqlConsultar = "select * from " + tabela + " where id = ?";
	private String sqlInserir = "insert into " + tabela + " (descricao,finalizado,datafinalizacao) values (?,?,?)";
	private String sqlEditar = "update " + tabela + " set descricao = ?, finalizado = ?, datafinalizacao = ? where id = ?";
	private String sqlDeletar = "delete from " + tabela + " where id = ?";
	
	@Autowired
	public JdbcTarefasDao(DataSource dataSource) {
		try {
			conexao = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tarefa> listarTarefas() throws Exception {
		List<Tarefa> retorno = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sqlListar);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			Calendar data = Calendar.getInstance();
			String d = rs.getString("dataFinalizacao");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if (d != null) {
				java.util.Date dt = format.parse(d);
				data.setTime(dt);
				tarefa.setDataFinalizacao(data);
			}
			retorno.add(tarefa);
		}

		return retorno;
	}
	
	public void inserirTarefa(Tarefa tarefa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlInserir);

		ps.setString(1, tarefa.getDescricao());
		ps.setBoolean(2, tarefa.isFinalizado());
		ps.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
		ps.execute();
		ps.close();
	}

	public void deletarTarefa(Long id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlDeletar);

		ps.setLong(1, id);
		ps.execute();
		ps.close();
	}

	public Tarefa consultarTarefa(Long id) throws SQLException {

		PreparedStatement ps = conexao.prepareStatement(sqlConsultar);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataFinalizacao"));
			tarefa.setDataFinalizacao(data);
			return tarefa;
		}

		return null;
	}

	public void editarTarefa(Tarefa tarefa) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement(sqlEditar);

		ps.setString(1, tarefa.getDescricao());
		ps.setBoolean(2, tarefa.isFinalizado());
		ps.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
		ps.setLong(4, tarefa.getId());
		ps.execute();
		ps.close();
	}
}
