package br.com.cepep.tarefas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.tarefas.dao.TarefasDao;
import br.com.cepep.tarefas.model.Tarefa;

@Controller
public class TarefasController {
	
	private TarefasDao dao = new TarefasDao();
	
	@RequestMapping("/listar")
	public String listar(Model model) throws Exception{
		List<Tarefa> tarefas = dao.listarTarefas();
		model.addAttribute("tarefas", tarefas);
		return "tarefas/lista-tarefas";
	}
	
	@RequestMapping("/nova")
	public String nova() {
		return "tarefas/nova-tarefa";
	}
	
	@RequestMapping("/adicionar")
	public String adicionar(Tarefa tarefa) throws Exception {
		dao.inserirTarefa(tarefa);
		return "tarefas/adicionada-sucesso";
	}
}
