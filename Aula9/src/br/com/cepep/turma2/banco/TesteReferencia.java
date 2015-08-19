package br.com.cepep.turma2.banco;

public class TesteReferencia {
	public static void main(String[] args) {
		int i = 9;
		int j = 9;
		
		System.out.println(i==j);
		
		Banco b1 = new Banco();
		b1.nome = "B1";
		
		System.out.println(b1.nome);
		Banco b2 = new Banco();
		System.out.println(b2.nome);
		
		b2.nome = "B1";
		System.out.println(b2.nome);
		System.out.println(b1.nome);
		
		System.out.println(b1==b2);
		
		System.out.println(b1.nome==b2.nome);
	}
}
