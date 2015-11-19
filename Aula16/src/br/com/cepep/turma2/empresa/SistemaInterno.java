package br.com.cepep.turma2.empresa;

public class SistemaInterno {
	
	void login(Autenticavel funcionario) {
		funcionario.login(123);
	}
	
	public static void main(String[] args) {
		SistemaInterno sistemaInterno = new SistemaInterno();
		
		Autenticavel diretor = new Diretor();
		Autenticavel presidente = new Presidente();
		Autenticavel usuario = new Usuario();
		
		sistemaInterno.login(usuario);
		sistemaInterno.login(diretor);
		sistemaInterno.login(presidente);
	}
}
