package br.com.cepep.turma2.banco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.cepep.turma2.banco.util.ManipulaArquivos;

public class Banco {
	String nome;
	String numero;
	List<Agencia> agencias = new ArrayList<>();
	ManipulaArquivos manipulaArquivos = new ManipulaArquivos("agencias");
	
	public Banco() {
		List<String[]> leitura = manipulaArquivos.ler();
		for (String[] linha : leitura) {
			Agencia agencia = new Agencia();
			agencia.setNumero(linha[0]);
			agencia.setNome(linha[1]);
			agencias.add(agencia);
		}
	}
	
	void cadastrarAgencia(Agencia agencia) {
		agencias.add(agencia);
		manipulaArquivos.salvar(agencia.getNumero()+"|"+agencia.getNome());
	}

	public Agencia buscarAgencia(String numeroAgencia) {
		Agencia agenciaEncontrada = null;
		
		for (Agencia agencia : agencias) {
			if (agencia.getNumero().equals(numeroAgencia)) {
				agenciaEncontrada = agencia; 
				break;
			}
		}
		
		return agenciaEncontrada;
	}
}
