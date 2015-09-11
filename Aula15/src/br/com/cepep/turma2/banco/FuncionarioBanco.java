package br.com.cepep.turma2.banco;

import br.com.cepep.turma2.empresa.*;

public class FuncionarioBanco extends Funcionario {
	public static void main(String[] args) {
		FuncionarioBanco funcionarioBanco= new FuncionarioBanco();
		funcionarioBanco.nome = "Aristenio";
		
		TestePrivate private1 = new TestePrivate();
	}

	@Override
	public double getBonificacao() {
		return this.salario * 0.10;
	}
}
