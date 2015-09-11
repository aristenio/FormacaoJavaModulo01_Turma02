package br.com.cepep.turma2.banco;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	protected void atualiza() {
		float saldoAtualizado = super.consultarSaldo();
		saldoAtualizado += saldoAtualizado*0.5;
		super.setSaldo(saldoAtualizado);
	}
}
