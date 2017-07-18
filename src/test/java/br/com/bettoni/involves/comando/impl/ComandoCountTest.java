package br.com.bettoni.involves.comando.impl;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;
import br.com.bettoni.involves.mock.LeitorArquivoMock;

public class ComandoCountTest {

	private static final String COUNT_3 = "3";

	private LeitorArquivo leitorArquivo;

	private ComandoCount comando;

	@Before
	public void setUp() throws NumberFormatException, IOException, PropriedadeNaoEncontradaException {
		leitorArquivo = new LeitorArquivoMock();
		comando = new ComandoCount();
	}

	@Test public void
	deve_retornar_tres_com_comando_cout_total() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		Assert.assertTrue(COUNT_3.equals(comando.executar(leitorArquivo, "*")));
	}
	
	@Test public void
	deve_retornar_tres_com_comando_cout_distinct() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		Assert.assertTrue(COUNT_3.equals(comando.executar(leitorArquivo, "distinct", "propriedade")));
	}
	
	@Test(expected = ArgumentosDoComandoInvalidos.class) public void
	deve_retornar_excecao_quando_nao_receber_argumentos() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo);
	}
	
	@Test(expected = ArgumentosDoComandoInvalidos.class) public void
	deve_retornar_excecao_quando_recebe_um_argumento_desconhecido() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo, "#");
	}
	
	@Test(expected = ArgumentosDoComandoInvalidos.class) public void
	deve_retornar_excecao_quando_recebe_dois_argumentos_quando_deveria_receber_um() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo, "*", "1");
	}
	
	@Test(expected = ArgumentosDoComandoInvalidos.class) public void
	deve_retornar_excecao_quando_recebe_distinct_sem_argumento() throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		comando.executar(leitorArquivo, "distinct");
	}
	
}
