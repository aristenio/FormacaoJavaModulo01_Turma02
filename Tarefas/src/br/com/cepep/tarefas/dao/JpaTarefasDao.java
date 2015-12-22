package br.com.cepep.tarefas.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cepep.tarefas.model.Tarefa;

@Repository("jpaTarefasDao")
public class JpaTarefasDao implements TarefasDao{
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Tarefa> listarTarefas() throws Exception {
		return manager.createQuery("select t from Tarefa t", Tarefa.class).getResultList();
	}
	
	public void inserirTarefa(Tarefa tarefa) throws SQLException {
		manager.persist(tarefa);
	}

	public void deletarTarefa(Long id) throws SQLException {
		Tarefa tarefa = consultarTarefa(id);
		manager.remove(tarefa);
	}

	public Tarefa consultarTarefa(Long id) throws SQLException {
		return manager.find(Tarefa.class, id);
	}

	public void editarTarefa(Tarefa tarefa) throws SQLException {
		manager.merge(tarefa);
	}
}
