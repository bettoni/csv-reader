package br.com.bettoni.involves.comando.impl;

import org.junit.Assert;
import org.junit.Test;

import br.com.bettoni.involves.mock.LeitorArquivoMock;

public class ComandoExitTest {

	@Test public void
	deve_retornar_bye_ao_executar() {
		Assert.assertTrue("Bye!".equals(new ComandoExit().executar(new LeitorArquivoMock())));
	}
}
