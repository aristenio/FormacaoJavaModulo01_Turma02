package br.com.cepep.turma2.banco;

public class Cliente {
	private String nome;
	private String cpf;

	public Cliente(String cpf) {
		if (cpf.length() == 11)
			this.setCpf(cpf);
	}

	public Cliente(String nome, String cpf) {
		this(cpf);
		this.setNome(nome);
		
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
}
