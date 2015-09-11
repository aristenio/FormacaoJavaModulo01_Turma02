package br.com.cepep.turma2.banco.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ManipulaArquivos {
	private String arquivo;
	
	public ManipulaArquivos(String arquivo) {
		this.arquivo = arquivo;
	}
	public boolean salvar(String string) {
		try {
			OutputStream os = new FileOutputStream(arquivo+".dat");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bf = new BufferedWriter(osw);
			bf.write(string);
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<String[]> ler() {
		try {
			InputStream is = new FileInputStream(arquivo+".dat");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String s = br.readLine();
			List<String[]> retorno = new ArrayList<>();
			
			while (s != null) {
				String[] split = s.split("|");
				retorno.add(split);
				s = br.readLine();
			}
			
			return retorno;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
