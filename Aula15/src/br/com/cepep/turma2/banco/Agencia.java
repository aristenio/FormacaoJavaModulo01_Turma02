package br.com.cepep.turma2.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.cepep.turma2.banco.exceptions.NenhumaAgenciaCadastradaException;
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

	/**
	 * Método usado para adicionar uma nova conta na agencia
	 * 
	 * @param conta
	 *            Conta a ser adicionada
	 */
	public Conta cadastrarConta(Conta conta) {
		conta.setNumero(this.gerarNumeroConta());
		conta.salvarConta(this);
		contas.add(conta);
		return conta;
	}

	/**
	 * Gera um numero de conta aletória
	 * 
	 * @param i
	 *            numero que servirá para gerar o numeroaletaori
	 * @return
	 */
	private String gerarNumeroConta() {
		return "" + new Random().nextInt(100);
	}

	public Conta consultarConta(String numeroConta) {
		this.contas = Conta.carregarContasAgencia(this.numero);
		Conta contaEncontrada = null;
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroConta)) {
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

	@Override
	public String toString() {
		return this.getNumero() + "|" + this.getNome();
	}

	public void salvarAgencia(Banco banco) {
		new ManipulaArquivos("agenciasBanco" + banco.getNumero()).salvar(this.toString());
	}

	public static List<Agencia> carregarAgenciasBanco(Banco banco) throws NenhumaAgenciaCadastradaException{
		List<Agencia> agencias = new ArrayList<>();
		List<String[]> leitura = new ManipulaArquivos("agenciasBanco"+banco.getNumero()).ler();
		if(leitura.isEmpty())
			throw new NenhumaAgenciaCadastradaException("Nenhuma agencia registrada para o banco: "+banco.toString());
		for (String[] linhaAgencia : leitura) {
			Agencia agencia = new Agencia();
			agencia.setNumero(linhaAgencia[0]);
			agencia.setNome(linhaAgencia[1]);
			agencias.add(agencia);
		}
		return agencias;
	}
}
