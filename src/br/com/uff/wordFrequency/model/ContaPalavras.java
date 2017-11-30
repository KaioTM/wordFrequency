package br.com.uff.wordFrequency.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.uff.wordFrequency.DAO.TextoDAO;

/**
 * classe ContaPalavras - recebe como entrada um arquivo texto, identifica as
 * diferentes palavras e contabiliza as frequências.
 * 
 * uso: java ContaPalavras arquivo_texto
 * 
 * @author Eduardo Correa
 * 
 */
public class ContaPalavras {

	public Map<String, Integer> frequenciaPalavras() throws Exception {
		Blacklist listaNegra = new Blacklist();
		// -------------------------------------------------------
		// (0) declaração/inicialização de variáveis
		// -------------------------------------------------------

		String curLine; // recebe cada linha lida do arquivo texto

		Map<String, Integer> mapPalavras; // mapa: Palavra -> Frequencia
		// usado para contabilizar as
		// frequencias das palavras

		mapPalavras = new HashMap<String, Integer>();

		// -------------------------------------------------------
		// (1) abre o arquivo texto
		// -------------------------------------------------------

		/*
		 * //(1.1) testa se nome do arq. texto foi passado na chamada do programa if
		 * (args.length != 1) {
		 * System.err.println("ERRO: eh preciso especificar o nome do arquivo");
		 * System.err.println("Uso: java ContaPalavras arquivo_texto"); System.exit(1);
		 * }
		 */

		// (1.2) abre o arquivo
		FileReader txtFile = new FileReader(
				"C:\\Users\\kaio.teixeira\\git\\wordFrequency\\src\\arquivo\\Comentarios.txt");
		BufferedReader txtBuffer = new BufferedReader(txtFile);

		// -------------------------------------------------------
		// (2) loop que processa cada linha do arquivo texto
		// -------------------------------------------------------

		// (2.1) pega a primeira linha do arquivo
		curLine = txtBuffer.readLine();

		while (curLine != null) {

			// -------------------------------------------------------
			// (2.2) quebra a linha em tokens (palavras) utilizando
			// expressão regular.
			//
			// O programa usa uma forma simplificada p/ obter os tokens.
			// São considerados tokens:
			// - uma sequência de 1 a n números
			// - uma sequência de 1 a n letras
			// -------------------------------------------------------

			// primeiro converte tudo para minúsculo
			String minusculo = curLine.toLowerCase();

			// depois aplica a expressão regular
			Pattern p = Pattern.compile("(\\d+)|([a-záéíóúçãõôê]+)");
			Matcher m = p.matcher(minusculo);

			// -------------------------------------------------------
			// (2.3) IMPORTANTE: neste loop pegamos cada palavra
			// e atualizamos o mapa de frequências
			// -------------------------------------------------------
			if (listaNegra.lista.contains(minusculo)) {
				break;
			} else {
				while (m.find()) {
					String token = m.group(); // pega um token
					Integer freq = mapPalavras.get(token); // verifica se esse
					// token já está no mapa

					if (freq != null) { // se palavra existe, atualiza a frequencia
						mapPalavras.put(token, freq + 1);
					} else { // se palavra não existe, insiro com um novo id e freq=1.
						mapPalavras.put(token, 1);
					}
				}
			}
				// pega a próxima linha do arquivo
				curLine = txtBuffer.readLine();
			
		}
		txtBuffer.close();

		// -------------------------------------------------------
		// (3) imprime o mapa de frequencias
		// -------------------------------------------------------
		/*
		 * for (Map.Entry<String, Integer> entry : mapPalavras.entrySet()) {
		 * 
		 * //System.out.println(entry.getKey() + "," + entry.getValue()); }
		 */
		Set keyset = mapPalavras.keySet();
		Collection valores = mapPalavras.values();
		String resultadoFinal = (keyset.toString() + valores.toString());
		resultadoFinal = resultadoFinal.replaceAll("\\s", "").replaceAll("\n", "");
		resultadoFinal = resultadoFinal.replaceAll("\\s", "").replaceAll("\n", "");
		TextoDAO.gravaArquivo("frequencia", resultadoFinal);
		System.out.println(keyset.size() + "," + valores.size());

		/*
		 * Properties properties = new Properties(); for (Map.Entry<String, Integer>
		 * entry : mapPalavras.entrySet()) { properties.put(entry.getKey(),
		 * entry.getValue());
		 * 
		 * //System.out.println(entry.getKey() + "," + entry.getValue()); }
		 * properties.store(new FileOutputStream(
		 * "C:\\Users\\kaio.teixeira\\git\\wordFrequency\\src\\arquivo\\Frequencia.txt")
		 * , null);
		 */
		return mapPalavras;
	}

}
