package br.com.bettoni.involves.comando.impl;

import br.com.bettoni.involves.comando.Comando;
import br.com.bettoni.involves.leitor.LeitorArquivo;

public class ComandoExit implements Comando {

	@Override
	public String executar(LeitorArquivo leitorArquivo, String... parametros) {
		return "Bye!";
	}

	@Override
	public boolean isEncerramento() {
		return true;
	}

	@Override
	public String getNome() {
		return "exit";
	}
}
