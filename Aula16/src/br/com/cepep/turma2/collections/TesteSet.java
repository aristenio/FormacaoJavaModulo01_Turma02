package br.com.cepep.turma2.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TesteSet {
	public static void main(String[] args) {
		Set<String> cargos = new HashSet<>();
		cargos.add("Gerente");
		cargos.add("Diretor");
		cargos.add("Supervisor");
		cargos.add("Secretaria");
		cargos.add("Diretor");
		cargos.add("Gerente");
		
		System.out.println(cargos.size());
		
		for (String string : cargos) {
			System.out.println(string);
		}
		
		System.out.println("----------------");
		
		Iterator<String> i = cargos.iterator();
		while(i.hasNext()){
			String next = i.next();
			System.out.println(next);
		}
	}
}
