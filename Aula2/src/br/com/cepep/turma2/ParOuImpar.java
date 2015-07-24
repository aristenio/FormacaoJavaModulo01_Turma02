package br.com.cepep.turma2;

import java.util.Scanner;

public class ParOuImpar {
	public static void main(String[] args) {
		
		int valor1 = 0;
		float resultado = 0;
		
		Scanner leitor = new Scanner(System.in);
				
		System.out.println("Digite o valor: ");
		valor1 = leitor.nextInt();
		
		resultado = valor1 % 2;
		
		if(resultado == 0){
			System.out.println("O número " + valor1 + " é par.");
		} else {
			System.out.println("O número " + valor1 + " é impar.");
		}
		
	}

}
