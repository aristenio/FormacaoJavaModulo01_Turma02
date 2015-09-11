package br.com.cepep.turma2.javaio;

import java.io.PrintStream;
import java.util.Scanner;

public class LeitorSimples {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			PrintStream ps = new PrintStream("arquivoleitura.txt"); 
			while(scanner.hasNextLine()){
				ps.println(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
