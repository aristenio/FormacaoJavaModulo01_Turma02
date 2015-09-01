package br.com.cepep.turma2.banco;

import java.io.IOException;

import br.com.cepep.turma2.banco.exceptions.SaldoInsuficienteException;
import br.com.cepep.turma2.banco.exceptions.ValorNegativoException;

public abstract class Conta {
	private Cliente cliente;
	private String numero;
	private float saldo;
	private float limite;
	
	private static int totalContas;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		totalContas++;
	}
	
	protected abstract void atualiza();
	
	public void saque(float valor) throws SaldoInsuficienteException, ValorNegativoException{
		if(valor < 0)
			throw new ValorNegativoException();
		if((saldo + limite) >= valor){
			saldo -= valor;
		}else{
			throw new SaldoInsuficienteException();
		}
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
	
	protected void setSaldo(float novoSaldo){
		this.saldo = novoSaldo;
	}
}
