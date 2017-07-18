package br.com.bettoni.involves.comando.exception;

public class ArgumentosDoComandoInvalidos extends Exception {

	@Override
	public String getMessage() {
		return "Os argumentos do comando são inválidos";
	}
	
}
