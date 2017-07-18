package br.com.bettoni.involves.comando.exception;

public class ComandoInvalidoException extends Exception {

	@Override
	public String getMessage() {
		return "Comando invalido";
	}
}
