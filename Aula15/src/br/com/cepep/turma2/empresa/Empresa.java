package br.com.cepep.turma2.empresa;

public class Empresa {
	private String nome;
	private Funcionario[] funcionarios;
	
	public Empresa(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void adicionaFuncionario(Funcionario funcionario) {
		for (int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] == null)
				funcionarios[i] = funcionario;
		}
	}
	
	@Override
	public String toString() {
		return "Empresa:" + nome;
	}
}
