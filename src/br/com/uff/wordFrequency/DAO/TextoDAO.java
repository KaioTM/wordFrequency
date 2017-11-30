package br.com.uff.wordFrequency.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextoDAO {
	public static String lerArquivoArmazenarTexto(String path) throws IOException {
		String texto ="";
		BufferedReader br  = null;
		try {
		    br = new BufferedReader (new FileReader (path));
		    for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
		        texto = texto + linha;
		    }
		} finally {
		    if (br != null) try { br.close(); } catch (IOException ex) { }    
		}
	return texto;
	}
	
	
}


