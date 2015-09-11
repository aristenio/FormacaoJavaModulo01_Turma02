package br.com.cepep.turma2.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.cepep.turma2.banco.exceptions.BancoPadraoNaoCadastradoException;
import br.com.cepep.turma2.banco.exceptions.NenhumaAgenciaCadastradaException;
import br.com.cepep.turma2.banco.util.ManipulaArquivos;

public class Banco {

	private String nome;
	private String numero;
	private List<Agencia> agencias = new ArrayList<>();

	public static Banco getInstancia() throws BancoPadraoNaoCadastradoException, NenhumaAgenciaCadastradaException {
		List<String[]> linhaBanco = new ManipulaArquivos("bancos").ler();
		if (linhaBanco.isEmpty())
			throw new BancoPadraoNaoCadastradoException("Nenhum banco registrado");
		Banco banco = new Banco();
		banco.setNumero(linhaBanco.get(0)[0]);
		banco.setNome(linhaBanco.get(0)[1]);
		banco.carregarAgencias();
		return banco;
	}

	private void carregarAgencias() throws NenhumaAgenciaCadastradaException {
		this.agencias = Agencia.carregarAgenciasBanco(this);
	}

	void cadastrarAgencia(Agencia agencia) {
		agencia.salvarAgencia(this);
		agencias.add(agencia);
	}

	public Agencia buscarAgencia(String numeroAgencia) {
		Agencia agenciaEncontrada = null;
		try {
			this.carregarAgencias();
			for (Agencia agencia : agencias) {
				if (agencia.getNumero().equals(numeroAgencia)) {
					agenciaEncontrada = agencia;
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Falha ao localizar agencia: " + numeroAgencia);
		}

		return agenciaEncontrada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return this.numero + "|" + this.nome;
	}
}
