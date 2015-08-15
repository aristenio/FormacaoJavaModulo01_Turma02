package br.com.cepep.turma2.banco;

public class Conta {
	Cliente cliente;
	String numero;
	float saldo;
	
	public boolean saque(float valor) {
		if(saldo > valor){
			saldo -= valor;
			return true;
		}
		
		return false;
	}
	
	public void deposito(float valor) {
		saldo += valor;
	}
	
	public float consultarSaldo(){
		return saldo;
	}
}
