package br.com.cepep.turma2;

public class EstruturasRepeticao {
	public static void main(String[] args) {

		boolean condicao = false;

		while (condicao) {
			System.out.println("Teste");
		}

		int controle = 0;

//		while (controle <= 10) {
//			System.out.println(controle++);
//		}
		
//		controle = 0;
		
//		while(controle <= 10) {
//			System.out.println(controle);
//			 
//			if (controle == 7)
//				break;
//			
//			controle++;
//		}
		
		while(controle <= 10) {
			System.out.println(controle++);
			
			if (controle == 3)
				continue;
			
			System.out.println("Teste");
		}
	}
}
