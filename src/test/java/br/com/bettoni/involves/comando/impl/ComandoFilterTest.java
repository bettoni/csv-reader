package br.com.bettoni.involves.comando.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;
import br.com.bettoni.involves.mock.LeitorArquivoMock;

public class ComandoFilterTest {
	private static final String QUEBRA_LINHA = "\r\n";

	private static final String SEGUNDA_LINHA = "quarto, quinto, sexto";

	private static final String PRIMEIRA_LINHA = "primeira, segundo, terceiro";

	private static final String NENHUM_REGISTRO_ENCONTRADO = "Nenhum registro encontrado";

	private LeitorArquivoMock leitorArquivo;

	private ComandoFilter comando;

	@Before
	public void setUp() {
		leitorArquivo = new LeitorArquivoMock();
		comando = new ComandoFilter();
	}

	@Test(expected = ArgumentosDoComandoInvalidos.class) public void 
	deve_retornar_excecao_quando_receber_somente_um_argumento()
			throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo, "filter");
	}

	@Test(expected = ArgumentosDoComandoInvalidos.class) public void 
	deve_retornar_excecao_quando_receber_somente_tres_argumento()
			throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo, "filter", "arg1", "arg2");
	}

	@Test public void
	deve_retornar_mensagem_de_nenhum_registro_quando_lista_retorno_for_nula() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
 		Assert.assertTrue(NENHUM_REGISTRO_ENCONTRADO.equals(comando.executar(leitorArquivo, "find", "propriedade")));
	}
	
	@Test public void
	deve_retornar_mensagem_de_nenhum_registro_quando_lista_retorno_for_vazia() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
 		Assert.assertTrue(NENHUM_REGISTRO_ENCONTRADO.equals(comando.executar(leitorArquivo, "find", "propriedade")));
	}
	
	@Test public void
	deve_retornar_mensagem_tratada_com_campos_filtrados() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		leitorArquivo.setResultadoComandoFIlter(criarListaFiltrada());
 		Assert.assertEquals(getAssertDadosFiltrados(), comando.executar(leitorArquivo, "find", "propriedade"));
	}

	private List<String[]> criarListaFiltrada() {
		List<String[]> dadosFiltrados = new ArrayList<>();
		dadosFiltrados.add(PRIMEIRA_LINHA.split(","));
		dadosFiltrados.add(SEGUNDA_LINHA.split(","));
		return dadosFiltrados;
	}
	
	private String getAssertDadosFiltrados() {
		StringBuilder mensagemAssert = new StringBuilder();
		mensagemAssert.append(PRIMEIRA_LINHA).append(QUEBRA_LINHA).append(SEGUNDA_LINHA).append(QUEBRA_LINHA);
		return mensagemAssert.toString();
	}
}

