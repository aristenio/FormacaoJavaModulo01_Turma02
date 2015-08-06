package br.com.cepep.turma2;

public class Vetores {
	public static void main(String[] args) {
		int[] vetor = new int[5];
		
		vetor[0] = 5;
		vetor[1] = 3;
		vetor[2] = 1;
		vetor[3] = 8;
		vetor[4] = 7;
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
}
