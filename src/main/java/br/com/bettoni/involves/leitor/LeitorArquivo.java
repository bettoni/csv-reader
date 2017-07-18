package br.com.bettoni.involves.leitor;

import java.io.IOException;
import java.util.List;

import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public interface LeitorArquivo {

	long count() throws IOException;

	long countDistinct(String propriedade) throws IOException, PropriedadeNaoEncontradaException;

	List<String[]> filterPropriedade(String propriedade, String valorFiltro) throws IOException, PropriedadeNaoEncontradaException;

}
