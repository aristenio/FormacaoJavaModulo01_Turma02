package br.com.cepep.turma2.empresa;

public class TesteGerente {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setNome("João da Silva");
		gerente.setSenha(123);
		gerente.setSalario(1000);
		
		Secretaria secretaria = new Secretaria();
		secretaria.setNome("Maria Souza");
		secretaria.setSalario(400);
		secretaria.atender();
		
		gerente.reajuste();
		secretaria.reajuste();
		System.out.println(gerente.getSalario());
		System.out.println(secretaria.getSalario());
		
		Funcionario funcionario = gerente;
		Funcionario funcionario2 = secretaria;
		
		ControleDeBonificacoes bonificacoes = new ControleDeBonificacoes();
		bonificacoes.registra(gerente);
		bonificacoes.registra(secretaria);
		
		System.out.println(bonificacoes.getTotalBonificacoes());
		
		
	}
}
