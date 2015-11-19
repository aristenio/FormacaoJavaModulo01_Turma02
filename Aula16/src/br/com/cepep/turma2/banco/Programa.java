package br.com.cepep.turma2.banco;

import java.util.Scanner;

import br.com.cepep.turma2.banco.exceptions.SaldoInsuficienteException;
import br.com.cepep.turma2.banco.exceptions.ValorNegativoException;

public class Programa {
	Scanner leitor = new Scanner(System.in);
	Banco banco;

	public static void main(String[] args) {
		try {
			Banco bancoCepep = Banco.getInstancia();
			Programa programa = new Programa();
			programa.menu(bancoCepep);
		} catch (Exception e) {
			System.out.println("Falha na inicialização do sistema. "+e.getMessage());
		}
	}

	void menu(Banco banco) {
		System.out.println("Bem vindo ao banco " + banco.getNome());
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
		try {
			System.out.println("CPF");
			Cliente cliente = new Cliente(leitor.nextLong()+"");
			leitor.nextLine();
			System.out.println("Informe o nome do cliente:");
			cliente.setNome(leitor.nextLine());
			leitor.nextLine();
			System.out.println("Informe a agência");
			String numeroAgencia = leitor.next();
			leitor.reset();
			Agencia agencia = banco.buscarAgencia(numeroAgencia);
			
			if (agencia == null) {
				System.out.println("Agencia não encontrada");
				menu(banco);
			}
			
			Conta conta = new ContaCorrente(cliente);
			
			conta = agencia.cadastrarConta(conta);
			System.out.println("Conta cadastrada com sucesso! O número da sua conta é: "+conta.getNumero());
			
		} catch (Exception e) {
			System.err.println("Falha ao cadastrar conta bancária."+e.getMessage());
		}finally {
			menu(banco);
		}
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
		System.out.println("Seu saldo atual é R$ "+conta.consultarSaldo());
	}

	private void telaDeposito(Conta conta) {
		System.out.println("Informe o valor");
		float valor = leitor.nextFloat();
		conta.deposito(valor);
	}

	private void telaSaque(Conta conta) {
		System.out.println("Informe o valor");
		float valor = leitor.nextFloat();
		try {
			conta.saque(valor);
			System.out.println("Saque realizado com sucesso");
		} catch (SaldoInsuficienteException e) {
			System.out.println("Não foi possível realizar o saque");
		} catch (ValorNegativoException e) {
			System.out.println("Valor Informado deve ser maior do que zero.");
			throw new RuntimeException();
		}finally{
			System.out.println("Try/Catch executado");
		}
	}
}
