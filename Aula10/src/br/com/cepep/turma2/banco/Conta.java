package br.com.cepep.turma2.banco;

public class Conta {
	private Cliente cliente;
	private String numero;
	private float saldo;
	private float limite;
	
	private static int totalContas;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		totalContas++;
	}
	
	public boolean saque(float valor) {
		if((saldo + limite) >= valor){
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
	
	public void setLimite(float limite){
		if(limite>0)
			this.limite = limite;
	}
	
	public float getLimite(){
		return this.limite;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public static int getTotalContas() {
		return Conta.totalContas;
	}
}
