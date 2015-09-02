package br.com.cepep.turma2.banco;

/**
 * Classe que representa uma agencia
 * 
 * @author Aristenio Monteiro
 *
 */
public class Agencia {
	String nome;
	String numero;
	Conta[] contas = new Conta[100];
	
	/**
	 * Método usado para adicionar uma nova conta na agencia
	 * @param conta Conta a ser adicionada
	 */
	public void cadastrarConta(Conta conta) {
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null) {
				conta.setNumero(gerarNumeroConta(i));
				contas[i] = conta;
				break;
			}
		}
		
	}

	/**
	 * Gera um numero de conta aletória
	 * 
	 * @param i numero que servirá para gerar o numeroaletaori
	 * @return
	 */
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
