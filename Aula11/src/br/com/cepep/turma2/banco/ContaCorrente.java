package br.com.cepep.turma2.banco;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected void atualiza() {
		float saldoAtualizado = super.consultarSaldo();
		saldoAtualizado += saldoAtualizado*0.1;
		super.setSaldo(saldoAtualizado);
	}
}
