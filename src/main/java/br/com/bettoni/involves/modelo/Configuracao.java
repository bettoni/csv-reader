package br.com.bettoni.involves.modelo;

import java.util.Properties;

import br.com.bettoni.involves.leitor.exception.ConfiguracaoAplicativoInvalidaException;

public class Configuracao {
	private static final String FILE_LOCATION = "FILE_LOCATION";
	private static final String FILE_TYPE = "FILE_TYPE";
	private static final String CSV_SEPARATOR = "CSV_SEPARATOR";
	private String tipoArquivo;
	private String caminhoArquivo;
	private String separadorCsv;

	public Configuracao(String tipoArquivo, String caminhoArquivo) {
		this.tipoArquivo = tipoArquivo;
		this.caminhoArquivo = caminhoArquivo;
	}
	
	public Configuracao(Properties configuracaoes) {
		this(configuracaoes.getProperty(FILE_TYPE), configuracaoes.getProperty(FILE_LOCATION));
		separadorCsv = configuracaoes.getProperty(CSV_SEPARATOR);
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public String getSeparadorCsv() {
		return separadorCsv;
	}
	
	public boolean validarConfiguracao() throws ConfiguracaoAplicativoInvalidaException{
		if (tipoArquivoInvalido(tipoArquivo) || caminhoArquivoInvalido(caminhoArquivo)) {
			throw new ConfiguracaoAplicativoInvalidaException();
		}
		return true;
	}

	private boolean caminhoArquivoInvalido(String caminhoArquivo) {
		return caminhoArquivo == null || "".equals(caminhoArquivo);
	}

	private boolean tipoArquivoInvalido(String tipoArquivo) {
		return tipoArquivo == null || "".equals(tipoArquivo);
	}

}
