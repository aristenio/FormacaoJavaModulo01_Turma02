package br.com.cepep.turma2.empresa;

public class Presidente extends Funcionario implements Autenticavel {

	@Override
	public double getBonificacao() {
		return this.salario * 0.15;
	}
	
	public void login(int senha){
		//implentação
	}
	
}
