package br.com.cepep.turma2.javaio;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscritorArquivos {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("textosaida.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bf = new BufferedWriter(osw);
			
			bf.write("JAVA");
			
			bf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
