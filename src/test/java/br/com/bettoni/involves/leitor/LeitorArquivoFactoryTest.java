package br.com.bettoni.involves.leitor;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bettoni.involves.leitor.impl.LeitorCsv;
import br.com.bettoni.involves.modelo.Configuracao;

public class LeitorArquivoFactoryTest {

	private LeitorArquivoFactory leitorArquivoFactory;
	
	@Before
	public void setUp() {
		leitorArquivoFactory = new LeitorArquivoFactory();
	}

	@Test(expected=UnsupportedOperationException.class) public void
	deve_retornar_excecao_com_tipo_arquivo_nao_implementado() throws FileNotFoundException {
		leitorArquivoFactory.getLeitor(new Configuracao("",""));
	}
	
	@Test public void
	deve_retornar_nova_instancia_quanto_tipo_arquivo_csv() throws FileNotFoundException {
		LeitorArquivo leitor = leitorArquivoFactory.getLeitor(new Configuracao("CSV",""));
		Assert.assertNotNull(leitor);
		Assert.assertTrue(leitor instanceof LeitorCsv);
	}
}
