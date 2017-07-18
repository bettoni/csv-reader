package br.com.bettoni.involves.comando.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import br.com.bettoni.involves.comando.Comando;
import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public class ComandoFilter implements Comando {

	private static final String NENHUM_REGISTRO_ENCONTRADO = "Nenhum registro encontrado";

	@Override
	public String executar(LeitorArquivo leitorArquivo, String... parametros)
			throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		if (numeroParametrosInvalido(parametros)) {
			throw new ArgumentosDoComandoInvalidos();
		}

		String propriedade = parametros[0];
		String valorFiltro = parametros[1];
		List<String[]> registrosFiltrados = leitorArquivo.filterPropriedade(propriedade, valorFiltro);

		StringBuilder builderMensagemRetorno = new StringBuilder();

		if (existemDadosFiltrados(registrosFiltrados)) {
			registrosFiltrados.forEach(tratarRetornoDados(builderMensagemRetorno));
		} else {
			builderMensagemRetorno.append(NENHUM_REGISTRO_ENCONTRADO);
		}

		return builderMensagemRetorno.toString();
	}

	private Consumer<? super String[]> tratarRetornoDados(StringBuilder builderMensagemRetorno) {
		return linha -> builderMensagemRetorno.append(Arrays.asList(linha).stream().collect(Collectors.joining(","))).append("\r\n");
	}

	private boolean existemDadosFiltrados(List<String[]> registrosFiltrados) {
		return registrosFiltrados != null && !registrosFiltrados.isEmpty();
	}

	private boolean numeroParametrosInvalido(String... parametros) {
		return parametros.length != 2;
	}

	@Override
	public boolean isEncerramento() {
		return false;
	}

	@Override
	public String getNome() {
		return "filter";
	}

}
