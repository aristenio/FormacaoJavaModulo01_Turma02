package br.com.cepep.turma2;

public class Sorteio {
	public static void main(String[] args) {
		int sorteio1 = (int) ((Math.random() + 0.1) * 10);
		int sorteio2 = (int) ((Math.random() + 0.1) * 10);
		System.out.println(sorteio1);
		System.out.println(sorteio2);

		if ((sorteio1 == 7 || sorteio2 == 7) || (sorteio1 == 9 || sorteio2 == 9))
			System.out.println("Marcelo ganhou!");
		else if ((sorteio1 == 5 || sorteio2 == 5) || (sorteio1 == 10 || sorteio2 == 10))
			System.out.println("Arthur ganhou!");
		else if ((sorteio1 == 8 || sorteio2 == 8) && (sorteio1 == 2 || sorteio2 == 2))
			System.out.println("Regis ganhou!");
		else if ((sorteio1 == 3 || sorteio2 == 3) && (sorteio1 == 4 || sorteio2 == 4))
			System.out.println("Nivardo ganhou!");
		else if ((sorteio1 == 1 || sorteio2 == 1) && (sorteio1 == 6 || sorteio2 == 6))
			System.out.println("Rafael ganhou!");
		else
			System.out.println("Ninguém ganhou!");
	}
}
