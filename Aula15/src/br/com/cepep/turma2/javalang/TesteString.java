package br.com.cepep.turma2.javalang;

public class TesteString {
	public static void main(String[] args) {
		String teste = "AAA";
		String teste2 = "AAA";
		
		String t1 = new String("AAA");
		String t2 = new String("AAA");
		
		System.out.println(t2 == t1);
		System.out.println(t2.equals(t1));
		
		String t4 = "Aristenio Monteiro";
		System.out.println(t4.indexOf("BC"));
		
		int i = t4.indexOf("Mo");
		System.out.println(i);
		System.out.println(t4.substring(i,12));
		
		String t5 = "Aristenio Monteiro Filho";
		String[] split = t5.split(" ");
		System.out.println(split[1].toUpperCase());
		
		System.out.println(t5.replace("o", "x"));
	}
}
