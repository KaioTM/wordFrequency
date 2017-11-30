package br.com.uff.wordFrequency.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextoDAO {
	public static String lerArquivoRetornarString(String path) throws IOException {
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

	public static void gravaArquivo(String path, String conteudo) throws FileNotFoundException {
		try(  PrintWriter out = new PrintWriter("C:\\Users\\kaio.teixeira\\git\\wordFrequency\\src\\arquivo\\"+path +".txt")  ){
		    out.println( conteudo );
		}catch (Exception e2) {
			System.out.println("Não foi possível gravar o arquivo.");
		
			
		}

    }
	
	public static ArrayList<String> lerArquivoGravarArrayList(String path) throws IOException {
		ArrayList<String> blacklist = new ArrayList<>();
		BufferedReader br  = null;
		try {
		    br = new BufferedReader (new FileReader (path));
		    for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
		        blacklist.add(linha);
		    }
		} finally {
		    if (br != null) try { br.close(); } catch (IOException ex) { }    
		}
	return blacklist;
	}
}


