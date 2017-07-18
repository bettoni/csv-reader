package br.com.bettoni.involves.leitor.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.com.bettoni.involves.leitor.InputStreamHelper;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public class LeitorCsv implements LeitorArquivo {

	private static final String SEPARADOR_PADRAO = ",";
	private String separador;
	private InputStreamHelper acessoStream;

	public LeitorCsv(InputStreamHelper acessoStream, String separador) {
		this.acessoStream = acessoStream;
		this.separador = separadorInvalido(separador) ? SEPARADOR_PADRAO : separador;
	}

	public long count() throws IOException {
		try (BufferedReader buffer = criarReaderArquivo()) {
			return buffer.lines().skip(1).count();
		}
	}

	public long countDistinct(String propriedade) throws IOException, PropriedadeNaoEncontradaException {
		int indice_coluna = getIndiceColuna(propriedade);
		try (BufferedReader buffer = criarReaderArquivo()) {
			return buffer.lines().skip(1).map(linha -> linha.split(separador)[indice_coluna]).distinct().count();
		}
	}

	public List<String[]> filterPropriedade(String propriedade, String valorFiltro) throws IOException, PropriedadeNaoEncontradaException {
		try (BufferedReader buffer = criarReaderArquivo()) {
			return buffer.lines().skip(1).map(linha -> linha.split(separador)).filter(funcaoFilter(valorFiltro, propriedade))
					.collect(Collectors.toList());
		}
	}

	private List<String> getColunas() throws IOException {
		try (BufferedReader reader = criarReaderArquivo()) {
			return reader.lines().findFirst().map(line -> Arrays.asList(line.split(separador))).get();
		}
	}
	
	private Predicate<? super String[]> funcaoFilter(String valorFiltro, String propriedade) throws IOException, PropriedadeNaoEncontradaException {
		int indice_coluna = getIndiceColuna(propriedade);
		return filtro -> filtro[indice_coluna].toUpperCase().contains(valorFiltro.toUpperCase());
	}

	private int getIndiceColuna(String propriedade) throws IOException, PropriedadeNaoEncontradaException {
		int indiceColuna = getColunas().indexOf(propriedade);
		if (indiceColuna == -1) {
			throw new PropriedadeNaoEncontradaException();
		}
		return indiceColuna;
	}

	private BufferedReader criarReaderArquivo() throws IOException{
		return new BufferedReader(new InputStreamReader(acessoStream.getStreamDadosOrigem(), "UTF-8"));
	}

	private boolean separadorInvalido(String separador) {
		return separador == null || "".equals(separador);
	}
}
