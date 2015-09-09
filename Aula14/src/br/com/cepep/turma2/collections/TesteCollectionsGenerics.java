package br.com.cepep.turma2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cepep.turma2.banco.Cliente;
import br.com.cepep.turma2.banco.ContaCorrente;

public class TesteCollectionsGenerics {
	public static void main(String[] args) {
		List<ContaCorrente> listaConta = new ArrayList<>();
		
		Cliente cliente = new Cliente("Aristenio", "765876");
		ContaCorrente c1 = new ContaCorrente(cliente);
		c1.deposito(506);
		ContaCorrente c2 = new ContaCorrente(cliente);
		c2.deposito(825);
		ContaCorrente c3 = new ContaCorrente(cliente);
		c3.deposito(154);
		ContaCorrente c4 = new ContaCorrente(cliente);
		c4.deposito(69);
		
		listaConta.add(c1);
		listaConta.add(c2);
		listaConta.add(c3);
		listaConta.add(c4);
		
		Collections.sort(listaConta);
		
		for (ContaCorrente conta : listaConta) {
			System.out.println(conta.consultarSaldo());
		}
		
		ContaCorrente max = Collections.max(listaConta);
		ContaCorrente min = Collections.min(listaConta);
		
		
	}
}
