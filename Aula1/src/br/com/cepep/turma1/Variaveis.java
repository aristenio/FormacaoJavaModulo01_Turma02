package br.com.cepep.turma1;

public class Variaveis {

	public static void main(String[] args) {
		//1 byte
		byte varByte = 100;// variaveis byte podem comportar valores entre -128 e 127
		/* 	
		 * pela leis dos homens e
		 * pela lei de Deus
		 * daqui pra baixo 
		 * n�o altere esse c�digo
		 */
		// 2 bytes  -32.768 a 32.767
		short varShort = 20000;
		// 4 bytes  -2.147.483.648 a 2.147.483.647
		int varInt = 500000;
		//8 bytes
		long varLong = 50000000;
		
		
		// 4 bytes
		float varFloat = 10.6f;
		//8 bytes
		double varDouble = 15000000.5d;
		
		// variavel l�gica - 1 bit
		boolean varBoolean = true;
		boolean varBoolean2 = false; 
		
		//Caracter - 2 Bytes - Aspas Simples
		char varChar = 'B';
		

		int v1 = 0;
		System.out.println(v1);
	}
}
