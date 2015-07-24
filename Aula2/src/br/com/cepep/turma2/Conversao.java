package br.com.cepep.turma2;

public class Conversao {
	public static void main(String[] args) {
		//conversão explicita
		double pi = 3.14;
		int piInteiro = (int) pi;
		System.out.println(piInteiro);
		
		long l = 922337203685477l;
		System.out.println(l);
		int i = (int) l;
		System.out.println(i);
		
		//conversão implicitas
		int x = 100000;
		long y = x;
		
		float z = 10.4f;
		double w = z;
		
		double d = 5.5;
		float f = 3.3f;
		
		float df = f + (float) d;
		System.out.println(df);
	}
}
