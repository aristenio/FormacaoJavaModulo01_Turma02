package br.com.cepep.turma2.banco;

import br.com.cepep.turma2.banco.exceptions.CpfInvalidoException;
import br.com.cepep.turma2.banco.util.ManipulaArquivos;

public class Cliente {
	
	private String nome;
	private String cpf;
	private ManipulaArquivos manipulaArquivos = new ManipulaArquivos("clientes");

	public Cliente(String cpf) throws CpfInvalidoException{
		if (cpf.length() == 11)
			this.setCpf(cpf);
		else
			throw new CpfInvalidoException("CPF informado inválido");
	}

	public Cliente(String nome, String cpf) throws CpfInvalidoException{
		this(cpf);
		this.setNome(nome);
	}
	
	public void salvarCliente(){
		manipulaArquivos.salvar(this.toString());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return this.cpf +"|"+this.nome;
	}
}
