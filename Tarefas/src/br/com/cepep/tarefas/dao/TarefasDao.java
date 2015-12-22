package br.com.cepep.tarefas.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cepep.tarefas.model.Tarefa;

public interface TarefasDao {
	
	public List<Tarefa> listarTarefas() throws Exception;
	
	public void inserirTarefa(Tarefa tarefa) throws SQLException;
	
	public void deletarTarefa(Long id) throws SQLException;

	public Tarefa consultarTarefa(Long id) throws SQLException;

	public void editarTarefa(Tarefa tarefa) throws SQLException;
	
	public Tarefa finalizarTarefa(Long id) throws SQLException;
}
