package br.com.bettoni.involves.leitor.exception;

public class ConfiguracaoAplicativoInvalidaException extends Exception {

	@Override
	public String getMessage() {
		return "Configura��es inv�lidas. As propriedades 'FILE_LOCATION' e 'FILE_TYPE' n�o est�o informadas corretamente";
	}
}
