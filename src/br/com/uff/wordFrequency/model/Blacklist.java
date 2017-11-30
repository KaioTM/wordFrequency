package br.com.uff.wordFrequency.model;

import java.io.IOException;
import java.util.ArrayList;

import br.com.uff.wordFrequency.DAO.TextoDAO;

public class Blacklist {
	public ArrayList<String> lista;

	public Blacklist() throws IOException{
		try {
			lista = TextoDAO.lerArquivoGravarArrayList("C:\\Users\\kaio.teixeira\\git\\wordFrequency\\src\\arquivo\\blacklist.txt");
		}catch (IOException e) {
			System.out.println("Não foi possível localizar a Blacklist");
		}
	}
	

}
