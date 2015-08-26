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
		System.out.println("Bem vindo ao banco " + banco.nome);
		System.out.println("Escolha uma opção:");
		System.out.println("Opção A - Acessar Conta Bancária");
		System.out.println("Opção C - Cadastrar Conta Bancária");
		System.out.println("Opção S - Sair");

		char opcao = leitor.next().charAt(0);

		switch (opcao) {
		case 'A':
			acessarContaBancaria(banco);
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
		System.out.println("CPF");
		Cliente cliente = new Cliente(leitor.next());
		System.out.println("Informe o nome do cliente:");
		cliente.setNome(leitor.next());
		System.out.println("Informe a agência");
		String numeroAgencia = leitor.next();

		Agencia agencia = banco.buscarAgencia(numeroAgencia);
		
		if (agencia == null) {
			System.out.println("Agencia não encontrada");
			menu(banco);
		}

		Conta conta = new ContaCorrente(cliente);

		agencia.cadastrarConta(conta);
		menu(banco);
	}

	private void acessarContaBancaria(Banco banco) {
		System.out.println("Informe a agência");
		String numeroAgencia = leitor.next();
		Agencia agencia = banco.buscarAgencia(numeroAgencia);

		if (agencia == null) {
			System.out.println("Agencia não encontrada");
			menu(banco);
		}

		System.out.println("Informe o número da conta:");
		String numeroConta = leitor.next();
		Conta conta = agencia.consultarConta(numeroConta);

		if (conta == null) {
			System.out.println("Conta não encontrada");
			menu(banco);
		}

		menuContaBancaria(conta);
	}

	private void menuContaBancaria(Conta conta) {
		System.out.println("Bem vindo " + conta.getCliente().getNome());
		System.out.println("Escolha uma opção:");
		System.out.println("Opção S - Saque");
		System.out.println("Opção D - Deposito");
		System.out.println("Opção C - Consultar Saldo");
		System.out.println("Opção V - Voltar ao menu inicial ");

		char opcao = leitor.next().charAt(0);

		switch (opcao) {
		case 'S':
			telaSaque(conta);
			break;
		case 'D':
			telaDeposito(conta);
			break;
		case 'C':
			telaSaldo(conta);
			break;
		case 'V':
			menu(banco);
			break;
		default:
			break;
		}

	}

	private void telaSaldo(Conta conta) {
		System.out.println(conta.consultarSaldo());
	}

	private void telaDeposito(Conta conta) {
		System.out.println("Informe o valor");
		float valor = leitor.nextFloat();
		conta.deposito(valor);
	}

	private void telaSaque(Conta conta) {
		System.out.println("Informe o valor");
		float valor = leitor.nextFloat();
		boolean ok = conta.saque(valor);
		
		if(ok)
			System.out.println("Saque realizado com sucesso");
		else
			System.out.println("Não foi possível realizar o saque");
	}
}
