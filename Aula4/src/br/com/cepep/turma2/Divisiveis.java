package br.com.cepep.turma2;

public class Divisiveis {
	public static void main(String[] args) {
		
		int controle = 0;

		while (controle <= 100) {

			if (controle > 0 && controle % 3 == 0)
				System.out.println(controle + " é divisivel por 3");

			controle++;
		}
	}
}
