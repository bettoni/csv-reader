package br.com.bettoni.involves.mock;

import java.io.IOException;
import java.util.List;

import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public class LeitorArquivoMock implements LeitorArquivo {

	private List<String[]> retornoFilterPropriedade;

	@Override
	public long count() throws IOException {
		return 3;
	}

	@Override
	public long countDistinct(String propriedade) throws IOException, PropriedadeNaoEncontradaException {
		return 3;
	}

	@Override
	public List<String[]> filterPropriedade(String propriedade, String valorFiltro)
			throws IOException, PropriedadeNaoEncontradaException {
		return retornoFilterPropriedade;
	}
	

	public void setResultadoComandoFIlter(List<String[]> criarListaFiltrada) {
		this.retornoFilterPropriedade = criarListaFiltrada;
	}

}
