package br.com.cepep.turma2.exercicio;

public class Teste {
	public static void main(String[] args) {
		AreaCalculavel a1 = new Quadrado(2);
		AreaCalculavel a2 = new Retangulo(2,4);
		
		System.out.println("Area do quadrado: "+a1.calcularArea());
		System.out.println("Area do retangulo: "+a2.calcularArea());
		
	}
}
