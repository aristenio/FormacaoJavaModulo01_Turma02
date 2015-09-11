package br.com.cepep.turma2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.cepep.turma2.banco.Cliente;
import br.com.cepep.turma2.banco.Conta;
import br.com.cepep.turma2.banco.ContaCorrente;

public class TesteList {
	public static void main(String[] args) {
		List listaContas = new ArrayList();
		
		Cliente cliente = new Cliente("Aristenio", "765876");
		Conta c1 = new ContaCorrente(cliente);
		Conta c2 = new ContaCorrente(cliente);
		Conta c3 = new ContaCorrente(cliente);
		
		listaContas.add(c1);
		listaContas.add(c2);
		listaContas.add(c3);
		listaContas.add(cliente);
		
		for (Object object : listaContas) {
			Conta temp = (Conta) object;
			System.out.println(temp);
		}
		
		Conta c4 = (Conta)listaContas.get(1);
		
		for (int i = 0; i < listaContas.size(); i++) {
			System.out.println(listaContas.get(i));
		}
		
		LinkedList listContas2 = new LinkedList();
		listContas2.addFirst(c4);
		listContas2.addLast(c2);
		
		List listStr = new ArrayList();
		listStr.add("Nivardo");
		listStr.add("Aristenio");
		listStr.add("Regis");
		
		for (int i = 0; i < listStr.size(); i++) {
			System.out.println(listStr.get(i));
		}
		
		Collections.sort(listStr);
		
		for (int i = 0; i < listStr.size(); i++) {
			System.out.println(listStr.get(i));
		}
	}
}
