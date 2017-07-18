package br.com.bettoni.involves.comando;

import java.io.IOException;

import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public interface Comando {

	String executar(LeitorArquivo leitorArquivo, String... parametros) throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos;

	boolean isEncerramento();

	String getNome();

}
