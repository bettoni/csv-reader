package br.com.bettoni.involves.leitor;

import java.io.FileNotFoundException;

import br.com.bettoni.involves.leitor.impl.LeitorCsv;
import br.com.bettoni.involves.modelo.Configuracao;

public class LeitorArquivoFactory {

	private static final String TIPO_CSV = "CSV";

	public LeitorArquivo getLeitor(Configuracao configuracao) throws FileNotFoundException {

		switch (configuracao.getTipoArquivo().toUpperCase()) {
		case TIPO_CSV:
			return new LeitorCsv(new FileInputStreamHelper(configuracao.getCaminhoArquivo()),configuracao.getSeparadorCsv());

		default:
			throw new UnsupportedOperationException("Tipo de arquivo não implementado");
		}
	}

}
