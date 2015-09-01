package br.com.cepep.turma2.empresa;

public class ControleDeBonificacoes {
	
	private double totalBonificacoes = 0;
	
	public void registra(Funcionario funcioario) {
		this.totalBonificacoes += funcioario.getBonificacao();
	}
	
	public double getTotalBonificacoes() {
		return this.totalBonificacoes;
	}
}
