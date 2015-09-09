package br.com.cepep.turma2.banco;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma agencia
 * 
 * @author Aristenio Monteiro
 *
 */
public class Agencia {
	String nome;
	String numero;
	List<Conta> contas = new ArrayList<Conta>();
	
	/**
	 * Método usado para adicionar uma nova conta na agencia
	 * @param conta Conta a ser adicionada
	 */
	public void cadastrarConta(Conta conta) {
		contas.add(conta);
	}
	
	/**
	 * Método usado para adicionar uma nova conta na agencia
	 * @param conta Conta a ser adicionada
	 */
	public void apagarConta(Conta conta) {
		contas.remove(conta);
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
