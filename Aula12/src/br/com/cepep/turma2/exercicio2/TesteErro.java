package br.com.cepep.turma2.exercicio2;

import br.com.cepep.turma2.banco.Conta;

public class TesteErro {
	public static void main(String[] args) {
		System.out.println("Inicio main");
		metodo1();
		System.out.println("Fim main");
	}

	private static void metodo1() {
		System.out.println("Inicio metodo 1");
		metodo2();
		System.out.println("Fim metodo 1");
	}

	private static void metodo2() {
		System.out.println("Inicio metodo 2");

		int[] array = new int[10];

		try {
			for (int i = 0; i < 15; i++) {
				array[i] = i;
				System.out.println(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("erro: " + e);
		}
		
		try {
			int i = 5571;
			i = i / 0;
			System.out.println("resultado: "+i);
		} catch (ArithmeticException e) {
			System.out.println("erro: " + e);
		}
		
		try {
			Conta c = null;
			System.out.println(c.consultarSaldo());
		} catch (NullPointerException e) {
			System.out.println("erro: " + e);
		}

		System.out.println("Fim metodo 2");
	}
}
