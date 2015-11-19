package br.com.cepep.turma2.banco.exceptions;

public class SaldoInsuficienteException extends Exception{

	@Override
	public String getMessage() {
		return "Saldo Insuficiente";
	}
	
}
