package br.com.cepep.turma2;

public class LabeledLoops {
	public static void main(String[] args) {
		
		int i = 0;
		
		F1: for (byte a = 0; a <= 9; a++) {
			i = 2;
			int j =3;
			F2: for (byte b = 0; b <= 9; b++) {
				i = 1;
				j = 4;
				System.out.println(a + "" + b);
				
				if(a==5 && b==5)
					break F1;
			}
	
			if(i==3){
				i = 5;
				j = 7;
				int k = 7;
			}
			
		}
	}

}
