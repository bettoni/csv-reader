package br.com.bettoni.involves.comando.impl;

import java.io.IOException;

import br.com.bettoni.involves.comando.Comando;
import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;

public class ComandoCount implements Comando {

	@Override
	public String executar(LeitorArquivo leitorArquivo, String... parametros) throws IOException, PropriedadeNaoEncontradaException, ArgumentosDoComandoInvalidos {
		if(deveExecutarCount(parametros)) {
			return String.valueOf(leitorArquivo.count());
		}
		
		if(deveExecutarDistinct(parametros)) {
			return String.valueOf(leitorArquivo.countDistinct(parametros[1]));
		}
        
		throw new ArgumentosDoComandoInvalidos();
	}

	private boolean deveExecutarDistinct(String... parametros) {
		return parametros.length == 2 && "distinct".equalsIgnoreCase(parametros[0]);
	}

	private boolean deveExecutarCount(String... parametros) {
		return parametros.length == 1 && "*".equals(parametros[0]);
	}

	@Override
	public boolean isEncerramento() {
		return false;
	}

	@Override
	public String getNome() {
		return "count";
	}

}
