package br.com.cepep.turma2.collections;

import java.util.HashMap;
import java.util.Map;

import br.com.cepep.turma2.banco.Cliente;
import br.com.cepep.turma2.banco.Conta;
import br.com.cepep.turma2.banco.ContaCorrente;

public class TestMap {
	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente("Aristenio", "765876");
		ContaCorrente c1 = new ContaCorrente(cliente);
		c1.deposito(506);
		ContaCorrente c2 = new ContaCorrente(cliente);
		c2.deposito(825);
		ContaCorrente c3 = new ContaCorrente(cliente);
		c3.deposito(154);
		ContaCorrente c4 = new ContaCorrente(cliente);
		c4.deposito(69);
		
		Map<String, Conta> mapContas = new HashMap<>();
		mapContas.put("c1", c1);
		mapContas.put("A", c2);
		mapContas.put("76", c3);
		
		mapContas.get("c1");
		
		for (String indice : mapContas.keySet()) {
			mapContas.get(indice);
		}
	}
}
