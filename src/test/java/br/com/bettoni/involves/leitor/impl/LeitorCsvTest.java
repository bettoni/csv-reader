package br.com.bettoni.involves.leitor.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bettoni.involves.leitor.InputStreamHelper;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;
import br.com.bettoni.involves.mock.MockStreamHelper;

public class LeitorCsvTest {

	private InputStreamHelper streamHelper;
	private static final String SEPARADOR = ",";
	private LeitorArquivo leitorCsv;

	@Before
	public void setUp() throws FileNotFoundException {
		streamHelper = new MockStreamHelper();
		leitorCsv = new LeitorCsv(streamHelper, SEPARADOR);
	}
	
	@Test(expected=PropriedadeNaoEncontradaException.class) public void 
	deve_retornar_excecao_caso_propriedade_nao_existir_no_distinct() throws IOException, PropriedadeNaoEncontradaException {
		leitorCsv.countDistinct("nao_existe");
	}
	
	@Test(expected=PropriedadeNaoEncontradaException.class) public void 
	deve_retornar_excecao_caso_propriedade_nao_existir_no_filter() throws IOException, PropriedadeNaoEncontradaException {
		leitorCsv.filterPropriedade("nao_existe", "");
	}	

	@Test
	public void 
	deve_retornar_tamanho_total_do_arquivo_csv() throws IOException {
		Assert.assertEquals(4, leitorCsv.count());
	}

	@Test public void 
	deve_retornar_contagem_linha_sem_repeticao_quando_informar_propriedade() throws IOException, PropriedadeNaoEncontradaException {
		Assert.assertEquals(2, leitorCsv.countDistinct("uf"));
	}
	
	@Test public void 
	deve_retornar_linhas_filtradas_pela_propriedade_do_csv() throws IOException, PropriedadeNaoEncontradaException {
		List<String[]> linhasFiltradas = leitorCsv.filterPropriedade("uf", "ac");
		Assert.assertEquals(1, linhasFiltradas.size());
		Assert.assertEquals("1100049", linhasFiltradas.get(0)[0]);
		Assert.assertEquals("AC", linhasFiltradas.get(0)[1]);
		Assert.assertEquals("Cacoal", linhasFiltradas.get(0)[2]);
		Assert.assertEquals("", linhasFiltradas.get(0)[3]);
		Assert.assertEquals("-61.4429442118", linhasFiltradas.get(0)[4]);
		Assert.assertEquals("-11.4338650287", linhasFiltradas.get(0)[5]);
		Assert.assertEquals("Cacoal", linhasFiltradas.get(0)[6]);
		Assert.assertEquals("", linhasFiltradas.get(0)[7]);
		Assert.assertEquals("Cacoal", linhasFiltradas.get(0)[8]);
		Assert.assertEquals("Leste Rondoniense", linhasFiltradas.get(0)[9]);
	}
}
