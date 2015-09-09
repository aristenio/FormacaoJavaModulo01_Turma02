package br.com.cepep.turma2.empresa;

public class SecretariaBilingue extends Secretaria {

	@Override
	public String atender() {
		return "Hello";
	}

	@Override
	public double getBonificacao() {
		return this.salario * 0.10;
	}

	

}
