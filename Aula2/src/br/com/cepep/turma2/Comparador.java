package br.com.cepep.turma2;

import java.util.Scanner;

public class Comparador {
	public static void main(String[] args) {
		Scanner scaneador = new Scanner(System.in);
		float valor1 = 0;
		float valor2 = 0;

		System.out.println("Digite o primeiro valor:");
		valor1 = scaneador.nextFloat();

		System.out.println("Digite o segundo valor:");
		valor2 = scaneador.nextFloat();

		if (valor1 == valor2) {
			System.out.println("Os valores são iguais.");
		} else if (valor1 > valor2) {
			System.out.println("O primeiro valor é maior que o segundo valor.");

		} else if (valor1 < valor2) {
			System.out.println("O Segundo valor é maior que o primeiro valor.");
		}
	}
}
