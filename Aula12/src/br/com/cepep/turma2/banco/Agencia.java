package br.com.cepep.turma2.banco;

public class Agencia {
	String nome;
	String numero;
	Conta[] contas = new Conta[100];
	
	public void cadastrarConta(Conta conta) {
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null) {
				conta.setNumero(gerarNumeroConta(i));
				contas[i] = conta;
				break;
			}
		}
		
	}

	private String gerarNumeroConta(int i) {
		return "" + (i + Math.random());
	}

	public Conta consultarConta(String numeroConta) {
		Conta contaEncontrada = null;
		for (Conta conta : contas) {
			if(conta.getNumero().equals(numeroConta)){
				contaEncontrada = conta;
				break;
			}
		}
		return contaEncontrada;
	}
}
