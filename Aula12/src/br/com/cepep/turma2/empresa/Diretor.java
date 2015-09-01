package br.com.cepep.turma2.empresa;

public class Diretor extends Funcionario implements Autenticavel {
	

	@Override
	public double getBonificacao() {
		// TODO Auto-generated method stub
		return this.salario * 0.15;
	}

	@Override
	public void login(int senha) {
		// TODO Auto-generated method stub
		
	}

}
