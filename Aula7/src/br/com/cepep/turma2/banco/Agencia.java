package br.com.cepep.turma2.banco;

public class Agencia {
	String nome;
	String numero;
	Conta[] contas = new Conta[100];
	
	public void cadastrarConta(Conta conta) {
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null) {
				conta.numero = gerarNumeroConta(i);
				contas[i] = conta;
			}
		}
		
	}

	private String gerarNumeroConta(int i) {
		return "" + (i + Math.random());
	}
}
