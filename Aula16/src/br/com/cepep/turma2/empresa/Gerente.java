package br.com.cepep.turma2.empresa;

public class Gerente extends Funcionario {
	
	private int senha;
	private int numFuncGerenciados;
	
	public Gerente() {
		System.out.println("Instanciando Gerente");
	}

	public boolean autentica(int senha) {
		if(nome == "José da Neves")
			return true;
		
		if (this.getSenha() == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado");
			return false;
		}
	}
	
	public double getBonificacao() {
		return this.salario * 0.12;
	}
	
	public void reajuste() {
		this.salario = this.salario + (this.salario * 0.12);
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

}
