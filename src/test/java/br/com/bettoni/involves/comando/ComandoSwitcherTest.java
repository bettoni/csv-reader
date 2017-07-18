package br.com.bettoni.involves.comando;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bettoni.involves.comando.exception.ComandoInvalidoException;
import br.com.bettoni.involves.comando.impl.ComandoCount;
import br.com.bettoni.involves.comando.impl.ComandoExit;
import br.com.bettoni.involves.comando.impl.ComandoFilter;

public class ComandoSwitcherTest {
	private ComandoExit comandoProcurado = new ComandoExit();
	private ComandoSwitcher comandoSwitcher;

	@Before
	public void setUp() {
		Set<Comando> comandosDisponiveis = new LinkedHashSet<Comando>();
		comandosDisponiveis.add(comandoProcurado);
		comandosDisponiveis.add(new ComandoCount());
		comandosDisponiveis.add(new ComandoFilter());
		comandoSwitcher = new ComandoSwitcher(comandosDisponiveis);
		
	}

	@Test(expected=IllegalArgumentException.class) public void 
	deve_disparar_excecao_quando_comandos_disponiveis_nulo() {
		comandoSwitcher = new ComandoSwitcher(null);
	}
	
	@Test public void
	deve_retornar_string_com_comandos_disponiveis() {
		Assert.assertEquals("exit count filter ", comandoSwitcher.toString());
	}
	
	@Test(expected=ComandoInvalidoException.class) public void
	deve_disparar_excecao_quando_comandos_nao_existir() throws ComandoInvalidoException {
		comandoSwitcher.getComandoPeloNome("nao_existe");
	}
	
	@Test public void
	deve_retornar_comando_valido() throws ComandoInvalidoException {
		Assert.assertEquals(comandoProcurado, comandoSwitcher.getComandoPeloNome("exit"));
	}
	
}
