package br.com.cepep.turma2.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.cepep.turma2.banco.exceptions.SaldoInsuficienteException;
import br.com.cepep.turma2.banco.exceptions.ValorNegativoException;
import br.com.cepep.turma2.banco.util.ManipulaArquivos;

public abstract class Conta {
	private Cliente cliente;
	private String numero;
	private float saldo;
	private float limite;

	private static int totalContas;

	public Conta(Cliente cliente) {
		this.cliente = cliente;
		totalContas++;
	}

	protected abstract void atualiza();

	public void saque(float valor) throws SaldoInsuficienteException, ValorNegativoException {
		if (valor < 0)
			throw new ValorNegativoException();
		if ((saldo + limite) >= valor) {
			saldo -= valor;
		} else {
			throw new SaldoInsuficienteException();
		}
	}

	public void deposito(float valor) {
		saldo += valor;
	}

	public float consultarSaldo() {
		return saldo;
	}

	public void setLimite(float limite) {
		if (limite > 0)
			this.limite = limite;
	}

	public float getLimite() {
		return this.limite;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static int getTotalContas() {
		return Conta.totalContas;
	}

	protected void setSaldo(float novoSaldo) {
		this.saldo = novoSaldo;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		Conta outraConta = (Conta) obj;

		if (this.numero.equals(outraConta.numero))
			iguais = true;

		return iguais;
	}

	@Override
	public String toString() {
		return this.getNumero() + "|" + this.getCliente().getCpf() + "|" + this.consultarSaldo() + "|"
				+ this.getLimite();
	}

	public void salvarConta(Agencia agencia) {
		this.limite = 100;
		this.cliente.salvarCliente();
		new ManipulaArquivos("contasAgencia" + agencia.getNumero()).salvar(this.toString());
	}

	public static List<Conta> carregarContasAgencia(String numero) {
		List<Conta> contas = new ArrayList<>();
		try {
			List<String[]> leitura = new ManipulaArquivos("contasAgencia" + numero).ler();
			for (String[] linha : leitura) {
				Cliente cliente = new Cliente(linha[1]);
				Conta conta = new ContaCorrente(cliente);
				conta.setNumero(linha[0]);
				conta.setLimite(Float.parseFloat(linha[3]));
				conta.setSaldo(Float.parseFloat(linha[2]));
				contas.add(conta);
			}
		} catch (Exception e) {
			System.err.println("Falha ao carregar agencia."+e.getMessage());
		}
		return contas;
	}

}
