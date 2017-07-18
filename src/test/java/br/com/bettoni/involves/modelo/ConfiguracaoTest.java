package br.com.bettoni.involves.modelo;

import org.junit.Assert;
import org.junit.Test;

import br.com.bettoni.involves.leitor.exception.ConfiguracaoAplicativoInvalidaException;

public class ConfiguracaoTest {

	
	private Configuracao configuracao;
	
	@Test(expected=ConfiguracaoAplicativoInvalidaException.class) public void
	deve_retornar_excecao_quando_configuracao_vazia() throws ConfiguracaoAplicativoInvalidaException {
		configuracao = new Configuracao("", "");
		configuracao.validarConfiguracao();
	}
	
	@Test(expected=ConfiguracaoAplicativoInvalidaException.class) public void
	deve_retornar_excecao_quando_configuracao_nula() throws ConfiguracaoAplicativoInvalidaException {
		configuracao = new Configuracao(null, null);
		configuracao.validarConfiguracao();
	}	
	
	@Test public void
	deve_retornar_configuracao_valida() throws ConfiguracaoAplicativoInvalidaException {
		configuracao = new Configuracao("tipo", "caminho");
		Assert.assertTrue(configuracao.validarConfiguracao());
	}
	
}
