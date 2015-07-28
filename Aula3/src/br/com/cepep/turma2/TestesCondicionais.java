package br.com.cepep.turma2;

import java.util.Scanner;

public class TestesCondicionais {
	public static void main(String[] args) {
		String nome = "";
		boolean restricao = false;
		float salario = 0;
		float valorEmprestimo = 0;
		float IR;
		Scanner leitor = new Scanner(System.in);

		System.out.println("Informe o nome:");
		nome = leitor.nextLine();
		System.out.println("Informe o salário:");
		salario = leitor.nextFloat();
		System.out.println("Informe a porcentagem do IR");
		IR = leitor.nextFloat();
		System.out.println("Possui restrição? (S/N)");
		char rest = leitor.next().charAt(0);
		restricao = (rest == 'S');
		System.out.println("Informe o valor do empréstimo:");
		valorEmprestimo = leitor.nextFloat();

		float mediaEmprestimo = valorEmprestimo / 12;
		float salarioLiquido = salario - (salario * (IR / 100));

		if ((mediaEmprestimo < salarioLiquido) && !restricao)
			System.out.println("Parabéns Sr. "+nome+"! Emprestimo concedido.");
		else
			System.out.println("Emprestimo negado!");
		

	}
}
