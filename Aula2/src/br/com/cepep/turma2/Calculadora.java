package br.com.cepep.turma2;

import java.util.Scanner;

public class Calculadora {
	
	public static void main(String[] args) {
	
		int valor1 = 0;
		int valor2 = 0;
		int resultado = 0;
		char operacao = '+';

		Scanner leitor = new Scanner(System.in);

		System.out.println("Informe o primeiro valor:");
		valor1 = leitor.nextInt();

		System.out.println("Informe o segundo valor:");
		valor2 = leitor.nextInt();

		System.out.println("Informe a operação");
		operacao = leitor.next().charAt(0);

		if (operacao == '+') {
			resultado = valor1 + valor2;
		} else if (operacao == '-') {
			resultado = valor1 - valor2;
		} else if (operacao == '*') {
			resultado = valor1 * valor2;
		}

		System.out.println("O resultado da operação " + valor1 + operacao + valor2 + " = " + resultado);

	}
}
