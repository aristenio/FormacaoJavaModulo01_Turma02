package br.com.cepep.turma2.exercicio;

public class Quadrado implements AreaCalculavel {

	private int lado;

	public Quadrado(int lado) {
		this.lado = lado;
	}

	@Override
	public int calcularArea() {
		return lado * 2;
	}

}
