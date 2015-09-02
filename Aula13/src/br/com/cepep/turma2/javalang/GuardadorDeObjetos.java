package br.com.cepep.turma2.javalang;

public class GuardadorDeObjetos {
	private Object[] arrayDeObjetos = new Object[100];
	private int posicao = 0;
	
	public int guardarObjeto(Object objeto) {
		this.arrayDeObjetos[posicao] = objeto;
		return posicao++;
	}
	
	public Object recuperObjeto(int posicao) {
		return this.arrayDeObjetos[posicao];
	}
}
