package br.com.cepep.turma2.banco;

public class ControleRendimentos {
	
	public void registra(Conta conta){
		conta.atualiza();
	}
	
	public static void main(String[] args) throws Exception{
		ControleRendimentos cr = new ControleRendimentos();
		Cliente cliente = new Cliente("Zé", "123453333");
		Cliente cliente2 = new Cliente("Cazuza", "6576457");
		
		Conta cp = new ContaPoupanca(cliente);
		cp.deposito(100);
		Conta cc = new ContaCorrente(cliente2);
		cc.deposito(100);
		
		cr.registra(cc);
		cr.registra(cp);
		
		System.out.println(cc.consultarSaldo());
		System.out.println(cp.consultarSaldo());
	}

}
