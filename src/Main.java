import java.io.IOException;

import br.com.uff.wordFrequency.model.ContaPalavras;

public class Main {

	public static void main(String[] args) throws IOException {
		//String texto = TextoDAO.processarArquivo("C:\\Users\\kaio.teixeira\\git\\wordFrequency\\src\\arquivo\\Comentarios.txt");
		ContaPalavras contar = new ContaPalavras();
		contar.frequenciaPalavras();
	}

}
