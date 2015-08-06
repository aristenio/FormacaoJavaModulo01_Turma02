package br.com.cepep.turma2;

import java.util.Scanner;

public class TabuadaArthur {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] tabuada = new int[10][10];
		int i = 0, j = 0;

		System.out.println("Informe a operacao (+,-,*)");
		char operacao = scan.nextLine().charAt(0);

		L1: while (tabuada[9][9] == 0) {
			if (j < 10) {
				S1: switch (operacao) {
				case '+':
					tabuada[i][j] = (i + 1) + (j + 1);
					break S1;
				case '-':
					if (j > i)
						break S1;
					tabuada[i][j] = (i + 1) - (j + 1);
					if (i == 9 && j == 9)
						break L1;
					break S1;
				case '*':
					tabuada[i][j] = (i + 1) * (j + 1);
					break S1;
				default:
					break S1;
				}
				j++;
			} else {
				j = 0;
				i++;
			}
		}

		i = 0;
		j = 0;

		while (i < 10 && j < 10) {
			if (i >= j)
				System.out.println((i + 1) + "" + operacao + "" + (j + 1) + "=" + tabuada[i][j]);

			if (j < 9) {
				j++;
			} else {
				j = 0;
				i++;
			}
		}
	}
}
