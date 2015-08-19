package br.com.cepep.turma2.banco;

public class TesteModificadores {
	
	public static void main(String[] args) {
		String cpf = "66587698";
		Cliente cliente = new Cliente(cpf,"Aristenio");
		cliente.setNome("Teste");
		Conta c1 = new Conta(cliente);
		c1.setLimite(100);
		c1.deposito(100);
		
		System.out.println(Conta.getTotalContas());
		
		Conta c2 = new Conta(cliente);
		System.out.println(Conta.getTotalContas());
		
		Conta c3 = new Conta(cliente);
		System.out.println(Conta.getTotalContas());
		
		if (c1.saque(100))
			System.out.println("Sucesso");
		else
			System.out.println("Erro");
		
		System.out.println(c1.consultarSaldo());
	}
}
