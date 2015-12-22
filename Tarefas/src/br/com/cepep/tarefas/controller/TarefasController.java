package br.com.cepep.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.tarefas.dao.TarefasDao;
import br.com.cepep.tarefas.model.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	@Qualifier("jpaTarefasDao")
	private TarefasDao tarefasDao;
	
	@RequestMapping("/listar")
	public String listar(Model model) throws Exception{
		List<Tarefa> tarefas = tarefasDao.listarTarefas();
		model.addAttribute("tarefas", tarefas);
		return "tarefas/lista-tarefas";
	}
	
	@RequestMapping("/nova")
	public String nova() {
		return "tarefas/nova-tarefa";
	}
	
	@RequestMapping("/adicionar")
	public String adicionar(Tarefa tarefa) throws Exception {
		tarefasDao.inserirTarefa(tarefa);
		return "tarefas/adicionada-sucesso";
	}
	
	@RequestMapping("/excluir")
	public String excluir(Tarefa tarefa) throws Exception {
		tarefasDao.deletarTarefa(tarefa.getId());
		return "forward:listar";
	}
	
	@RequestMapping("/editar")
	public String editar(Long id, Model model) throws Exception {
		Tarefa consultaTarefa = tarefasDao.consultarTarefa(id);
		model.addAttribute("tarefa", consultaTarefa);
		return "tarefas/editar-tarefa";
	}
	
	@RequestMapping("/alterar")
	public String alterar(Tarefa tarefa) throws Exception {
		tarefasDao.editarTarefa(tarefa);
		return "redirect:listar";
	}
	
	@RequestMapping("finalizarTarefa")
	public void finalizarTarefa(Long id, HttpServletResponse response) throws Exception {
		Tarefa tarefaFinalizada = tarefasDao.finalizarTarefa(id);
		response.getWriter().write(tarefaFinalizada.getDataFinalizacao().getTime().toString());
		response.setStatus(200);
	}
	
}
