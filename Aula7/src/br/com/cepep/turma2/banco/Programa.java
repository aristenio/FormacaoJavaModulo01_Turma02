package br.com.cepep.turma2.banco;

import java.util.Scanner;

public class Programa {
	Scanner leitor = new Scanner(System.in);
	Banco banco;

	public static void main(String[] args) {
		Banco bancoCepep;
		bancoCepep = new Banco();
		
		bancoCepep.nome = "Banco CEPEP";
		bancoCepep.numero = "0099";
		
		Agencia agenciaCentro = new Agencia();
		agenciaCentro.nome = "Unidade Centro";
		agenciaCentro.numero = "001";

		bancoCepep.cadastrarAgencia(agenciaCentro);
		
		Programa programa = new Programa();
		programa.menu(bancoCepep);
	}
	
	void menu(Banco banco) {
		System.out.println("Bem vindo ao banco "+banco.nome);
		System.out.println("Escolha uma opção:");
		System.out.println("Opção A - Acessar Conta Bancária");
		System.out.println("Opção C - Cadastrar Conta Bancária");
		System.out.println("Opção S - Sair");
		
		char opcao = leitor.next().charAt(0);
		
		switch (opcao) {
		case 'A':
			acessarContaBancaria();
			break;
		case 'C':
			cadastrarContaBancaria(banco);
			break;
		case 'S':
			System.exit(0);
			break;

		default:
			break;
		}
	}

	private void cadastrarContaBancaria(Banco banco) {
		Cliente cliente = new Cliente();
		System.out.println("Informe o nome do cliente:");
		cliente.nome = leitor.next();
		System.out.println("CPF");
		cliente.cpf = leitor.next();
		System.out.println("Informe a agência");
		String numeroAgencia = leitor.next();
		
		Agencia agencia = banco.buscarAgencia(numeroAgencia);
		
		Conta conta = new Conta();
		conta.cliente = cliente;
		
		agencia.cadastrarConta(conta);
	}

	private void acessarContaBancaria() {
		
	}
}
