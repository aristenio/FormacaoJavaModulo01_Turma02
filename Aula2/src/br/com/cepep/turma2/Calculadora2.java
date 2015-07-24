package br.com.cepep.turma2;

import java.util.Scanner;

public class Calculadora2 {

	public static void main(String[] args) {

		float valor1 = 0;
		float valor2 = 0;
		float resultado = 0;
		char operacao = '+';

		Scanner leitor = new Scanner(System.in);

		System.out.println("Informe o primeiro valor:");
		valor1 = leitor.nextFloat();

		System.out.println("Informe o segundo valor:");
		valor2 = leitor.nextFloat();

		System.out.println("Informe a operação");
		operacao = leitor.next().charAt(0);

		switch (operacao) {
		case '+':
			resultado = valor1 + valor2;
			break;
		case '-':
			resultado = valor1 - valor2;
			break;
		case '*':
			resultado = valor1 * valor2;
			break;
		case '/':
			resultado = valor1 / valor2;
			break;
		default:
			break;
		}

		System.out.println("O resultado da operação " + valor1 + operacao + valor2 + " = " + resultado);

	}
}
