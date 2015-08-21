package br.com.cepep.turma2.empresa;

public class Funcionario {
	
	protected String nome;
	protected String cpf;
	protected double salario;
	
	public Funcionario(){
		System.out.println("Instanciando Funcionario");
	}
		
	public Funcionario(String cpf) {
		this.setCpf(cpf);
	}

	public Funcionario(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
	}
	
	public void reajuste() {
		this.salario = this.salario + (this.salario * 0.10);
	}
	
	public double getBonificacao() {
		return this.salario * 0.10;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
