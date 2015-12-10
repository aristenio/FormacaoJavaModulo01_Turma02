package br.com.cepep.agenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cepep.agenda.dao.PessoaDao;
import br.com.cepep.agenda.entidades.Pessoa;

@Controller
public class ContatoController {
	
	private PessoaDao dao = new PessoaDao();
	
	@RequestMapping("/novoContato")
	public String novoContato() {
		return "contato/adicionar-contato";
	}
	
	@RequestMapping("/adicionaContato")
	public String adicionaContato(@Valid Pessoa pessoa, BindingResult result) {
		try {
			if(result.hasErrors())
				return "contato/adicionar-contato";
			
			dao.inserePessoa(pessoa);
			return "contato/contato-adicionado-sucesso";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "contato/contato-adicionado-falha";
		}
	}
	
	@RequestMapping("/listarContatos")
	public String listarContatos(Model model) {
		try {
			List<Pessoa> listaPessoas = dao.getListaPessoas();
			model.addAttribute("listaPessoas", listaPessoas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contato/listar-contatos";
	}
	
	@RequestMapping("/deletaContato")
	public String deletaContato(Pessoa pessoa) {
		try {
			dao.deletaPessoa(pessoa.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listarContatos";
	}
}
