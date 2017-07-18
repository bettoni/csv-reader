package br.com.bettoni.involves.comando;

import java.util.Set;

import br.com.bettoni.involves.comando.exception.ComandoInvalidoException;

public class ComandoSwitcher {

	private Set<Comando> comandosDisponiveis;

	public ComandoSwitcher(Set<Comando> comandosDisponiveis) {
		if (comandosDisponiveis == null) {
			throw new IllegalArgumentException();
		}
		this.comandosDisponiveis = comandosDisponiveis;
	}

	@Override
	public String toString() {
		StringBuilder comandos = new StringBuilder("");
		comandosDisponiveis.forEach(comando -> comandos.append(comando.getNome()).append(" "));
		return comandos.toString();
	}

	public Comando getComandoPeloNome(String entradaUsuario) throws ComandoInvalidoException {
		for (Comando comando : comandosDisponiveis) {
			if (entradaUsuario.equalsIgnoreCase(comando.getNome())) {
				return comando;
			}
		}

		throw new ComandoInvalidoException();
	}
}
