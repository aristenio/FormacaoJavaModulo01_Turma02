package br.com.cepep.turma2.javalang;

import br.com.cepep.turma2.banco.Cliente;
import br.com.cepep.turma2.banco.Conta;
import br.com.cepep.turma2.banco.ContaCorrente;
import br.com.cepep.turma2.empresa.Empresa;

public class Teste2 {
	public static void main(String[] args) throws Exception{
		GuardadorDeObjetos go = new GuardadorDeObjetos();
		
		Cliente cliente = new Cliente("Antonio","8658765");
		Conta conta = new ContaCorrente(cliente);
		Conta conta2 = new ContaCorrente(cliente);
		
		boolean iguais = conta.equals(conta2);
		System.out.println(iguais);
		
		int c1 = go.guardarObjeto(conta);
		
		Empresa empresa = new Empresa("Empres");
		
		int e1 = go.guardarObjeto(empresa);
		
		Conta objConta = (Conta) go.recuperObjeto(c1);
		ContaCorrente contaCorrente = (ContaCorrente) objConta;
		
		Empresa objEmpresa = (Empresa) go.recuperObjeto(e1);
		System.out.println(empresa);
	}
}
