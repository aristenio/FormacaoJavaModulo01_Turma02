package br.com.cepep.turma2.exercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TesteErroChecked {
	public static void main(String[] args) {
		try {
			metodo2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void metodo2() throws FileNotFoundException{
		metodo1();
	}
	
	private static void metodo1() throws FileNotFoundException {
		FileInputStream fii = new FileInputStream("arquivo.txt");
	}
}
