package br.com.cepep.turma2.banco;

public class TesteBanco {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("765856");
		Conta c1 = new ContaCorrente(cliente);
		c1.deposito(100);
		try {
			c1.saque(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(c1.consultarSaldo());
	}
}
