package br.com.bettoni.involves.leitor.exception;

public class ConfiguracaoAplicativoInvalidaException extends Exception {

	@Override
	public String getMessage() {
		return "Configurações inválidas. As propriedades 'FILE_LOCATION' e 'FILE_TYPE' não estão informadas corretamente";
	}
}
