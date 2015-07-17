package br.com.cepep.turma1;

import java.util.Scanner;

public class Soma {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Imprima o primeiro valor");
		a = leitor.nextInt();

		System.out.println("Imprima o segundo valor");
		b = leitor.nextInt();
		
		int resultado = a + b;
		System.out.println("Soma dos valores informados é: " + resultado);
	}
}
