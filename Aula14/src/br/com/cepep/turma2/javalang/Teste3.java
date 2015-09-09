package br.com.cepep.turma2.javalang;

public class Teste3 {
	public static void main(String[] args) {
		GuardadorDeObjetos go = new GuardadorDeObjetos();
		int inteiro = 2;
		
		Integer intObj = new Integer(inteiro);
		
		go.guardarObjeto(intObj);
		
		String s = "" +inteiro;
		
		System.out.println(s);
		
		String s1 = "101";
		int i2  = 2;
		
		int i3 = Integer.parseInt(s1);
		int i4 = i3 + i2;
		
		Integer x = 5;
		int y = x;
		
		Integer z = y;
		
		float zz = 4.3f;
		
		Integer aa = (int) zz;
		
	}
}
