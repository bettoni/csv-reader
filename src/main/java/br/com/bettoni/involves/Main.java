package br.com.bettoni.involves;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import br.com.bettoni.involves.cliente.ClienteConsole;
import br.com.bettoni.involves.comando.Comando;
import br.com.bettoni.involves.comando.ComandoSwitcher;
import br.com.bettoni.involves.comando.impl.ComandoCount;
import br.com.bettoni.involves.comando.impl.ComandoExit;
import br.com.bettoni.involves.comando.impl.ComandoFilter;
import br.com.bettoni.involves.modelo.Configuracao;

public class Main {

	private static final String APP_CONFIG = "app.config";

	public static void main(String[] args) {
		Set<Comando> comandosDisponiveis = new HashSet<Comando>();
		comandosDisponiveis.add(new ComandoExit());
		comandosDisponiveis.add(new ComandoCount());
		comandosDisponiveis.add(new ComandoFilter());

		new ClienteConsole(new ComandoSwitcher(comandosDisponiveis), new Configuracao(carregarConfiguracao()))
				.executar();
	}

	private static Properties carregarConfiguracao() {
		InputStream streamConfiguracao = null;
		try {
			streamConfiguracao = Main.class.getClassLoader().getResourceAsStream(APP_CONFIG);
			if (streamConfiguracao == null) {
				throw new IllegalArgumentException("Não foi possível encontrar o arquivo: " + APP_CONFIG);
			}
			Properties configuracoes = new Properties();
			configuracoes.load(streamConfiguracao);
			return configuracoes;
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o arquivo: " + APP_CONFIG);
			System.out.println("O aplicativo será encerrado");
			System.exit(-1);
			return null;
		} finally {
			if (streamConfiguracao != null) {
				try {
					streamConfiguracao.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

}
