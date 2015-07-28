package br.com.cepep.turma2;

public class CondicionalTernario {
	public static void main(String[] args) {
		int numero = (int) ((Math.random() + 0.1) * 10);
		boolean par = (numero % 2 == 0);
		
		String parImpar = ( (numero % 2 == 0) ? "par" : "impar");
		
		if(par)
			parImpar = "Par";
		else
			parImpar = "Impar";
			
		int num = par ? 0 : 1;
		
		System.out.println("O numero " + numero + "é "+parImpar);
		
	}
}
