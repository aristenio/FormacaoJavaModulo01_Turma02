package br.com.cepep.turma2;

import java.util.Scanner;

public class Tabuada {
	public static void main(String[] args) {
		int[][] tabuada = new int[10][10];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe a operacao (+,-,*)");
		char operacao = scan.nextLine().charAt(0);
				
		for (int i = 0; i < tabuada.length; i++) {
			L2: for (int j = 0; j < tabuada[i].length; j++) {
				switch (operacao) {
				case '+':
					tabuada[i][j] = (i+1) + (j+1);
					break;
				case '-':
					if(j>i)
						break L2;
					tabuada[i][j] = (i+1) - (j+1);
					break;
				case '*':
					tabuada[i][j] = (i+1) * (j+1);
					break;

				default:
					break;
				}
			}
		}
		
		for (int i = 0; i < tabuada.length; i++) {
			L2: for (int j = 0; j < tabuada[i].length; j++) {
				if(j > i && operacao == '-')
					break L2;
				System.out.println((i+1) + " " + operacao + " "+ (j+1) + " = "+ tabuada[i][j]);	
			}
		}
		
		
	}
}
