package br.com.cepep.turma2.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.cepep.turma2.banco.util.ManipulaArquivos;

/**
 * Classe que representa uma agencia
 * 
 * @author Aristenio Monteiro
 *
 */
public class Agencia {
	private String nome;
	private String numero;
	private List<Conta> contas = new ArrayList<Conta>();
	private ManipulaArquivos manipulaArquivos = new ManipulaArquivos("contas");
	
	public Agencia() {
		List<String[]> leitura = manipulaArquivos.ler();
		for (String[] linha : leitura) {
			Cliente cliente = new Cliente(linha[1]);
			Conta conta = new ContaCorrente(cliente);
			conta.setNumero(linha[0]);
			conta.setLimite(Float.parseFloat(linha[3]));
			conta.setSaldo(Float.parseFloat(linha[2]));
		}
	}
	
	/**
	 * Método usado para adicionar uma nova conta na agencia
	 * @param conta Conta a ser adicionada
	 */
	public void cadastrarConta(Conta conta) {
		contas.add(conta);
		manipulaArquivos.salvar(conta.getNumero()+"|"+conta.getCliente().getCpf()+"|"+conta.consultarSaldo()+"|"+conta.getLimite());
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

	public String getNumero() {
		return this.numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
