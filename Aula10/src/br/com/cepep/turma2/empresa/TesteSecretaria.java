package br.com.cepep.turma2.empresa;

public class TesteSecretaria {
	public static void main(String[] args) {
		Secretaria secretaria = new Secretaria();
		Secretaria secretaria2 = new SecretariaBilingue();
		
		System.out.println(secretaria.atender());
		System.out.println(secretaria2.atender());
		
	}
}
