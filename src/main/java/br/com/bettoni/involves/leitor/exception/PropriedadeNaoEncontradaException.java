package br.com.bettoni.involves.leitor.exception;

public class PropriedadeNaoEncontradaException extends Exception {

	@Override
	public String getMessage() {
		return "Propriedade informada não foi encontrada.";
	}

}
