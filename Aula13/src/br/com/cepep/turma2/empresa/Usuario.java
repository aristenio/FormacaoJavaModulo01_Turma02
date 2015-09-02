package br.com.cepep.turma2.empresa;

public class Usuario implements Pessoa, Autenticavel{

	private String nome;
	
	@Override
	public void login(int senha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}
}
