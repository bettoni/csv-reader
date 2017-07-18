package br.com.bettoni.involves.leitor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamHelper implements InputStreamHelper {

	private String caminhoArquivo;

	public FileInputStreamHelper(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	@Override
	public InputStream getStreamDadosOrigem() throws FileNotFoundException {
		return new FileInputStream(caminhoArquivo);
	}

}
