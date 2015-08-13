package br.com.cepep.turma2.banco;

public class Banco {
	String nome;
	String numero;
	Agencia[] agencias = new Agencia[10];
	
	void cadastrarAgencia(Agencia agencia) {
		for (int i = 0; i < agencias.length; i++) {
			if(agencias[i] == null) {
				agencias[i] = agencia;
			}
		}
	}

	public Agencia buscarAgencia(String numeroAgencia) {
		Agencia agenciaEncontrada = null;
		
		for (Agencia agencia : agencias) {
			if (agencia.numero == numeroAgencia) {
				agenciaEncontrada = agencia; 
			}
		}
		
		return agenciaEncontrada;
	}
}
