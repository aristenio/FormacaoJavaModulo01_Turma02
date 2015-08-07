package br.com.cepep.turma2;

import java.util.Scanner;

public class MediaPeso {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		String[] nomes;
		int[] pesos;
		int quantidade;
		int pesado = 0;
		int leve = 0;
		float media = 0;

		System.out.println("Quantidade de alunos");
		quantidade = leitor.nextInt();

		nomes = new String[quantidade];
		pesos = new int[quantidade];

		for (int i = 0; i < quantidade; i++) {
			System.out.println("Nome do aluno:");
			nomes[i] = leitor.next();
			System.out.println("Peso do aluno:");
			pesos[i] = leitor.nextInt();

			if (pesos[i] >= pesos[pesado])
				pesado = i;

			if (pesos[i] <= pesos[leve])
				leve = i;
		}
		System.out.println("Lista de alunos");
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Nome: " + nomes[i] + " Peso: " + pesos[i]);
		}

		int somaPesos = 0;
		for (int i = 0; i < quantidade; i++) {
			somaPesos += pesos[i];
		}
		
		media = somaPesos/quantidade;

		System.out.println("Aluno mais pesado: " + nomes[pesado] + " - " + pesos[pesado]);
		System.out.println("Aluno mais leve: " + nomes[leve] + " - " + pesos[leve]);
		
		System.out.println("Média de peso da turma é: "+media);
	}
}
