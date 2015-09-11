package br.com.cepep.turma2.banco;

public class ContaCorrente extends Conta implements Comparable<ContaCorrente> {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected void atualiza() {
		float saldoAtualizado = super.consultarSaldo();
		saldoAtualizado += saldoAtualizado*0.1;
		super.setSaldo(saldoAtualizado);
	}
	
	@Override
	public int compareTo(ContaCorrente outra) {
		if(this.consultarSaldo() > outra.consultarSaldo())
			return 1;
		
		if(this.consultarSaldo() < outra.consultarSaldo())
			return -1;
		
		return 0;
	}
	
}
