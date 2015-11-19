package br.com.cepep.turma2.bd;

public class Aluno {

	private int matricula;
	private String nome;
	private String email;
	private String telefone;
	private double altura;
	private boolean aprovado;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		return "Matricula=" + matricula + " Nome=" + nome + " Email=" + email + " Telefone=" + telefone + " Altura="
				+ altura + " Aprovado=" + aprovado;
	}
}
