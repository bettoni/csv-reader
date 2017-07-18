package br.com.bettoni.involves.cliente;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import br.com.bettoni.involves.comando.Comando;
import br.com.bettoni.involves.comando.ComandoSwitcher;
import br.com.bettoni.involves.comando.exception.ArgumentosDoComandoInvalidos;
import br.com.bettoni.involves.comando.exception.ComandoInvalidoException;
import br.com.bettoni.involves.leitor.LeitorArquivo;
import br.com.bettoni.involves.leitor.LeitorArquivoFactory;
import br.com.bettoni.involves.leitor.exception.ConfiguracaoAplicativoInvalidaException;
import br.com.bettoni.involves.leitor.exception.PropriedadeNaoEncontradaException;
import br.com.bettoni.involves.modelo.Configuracao;

public class ClienteConsole {

	private LogClienteConsole logger;
	private ComandoSwitcher comandos;
	private Configuracao configuracoes;

	public ClienteConsole(ComandoSwitcher comandos, Configuracao configuracoes) {
		this.comandos = comandos;
		this.configuracoes = configuracoes; 
		this.logger = new LogClienteConsole();
	}
 
	public void executar() {
		try {
			configuracoes.validarConfiguracao();
			logger.escreverMensagemInicial(configuracoes.getCaminhoArquivo(), comandos.toString());

			LeitorArquivo leitor = new LeitorArquivoFactory().getLeitor(configuracoes);

			Scanner scanner = new Scanner(System.in);
			String entradaUsuario;

			do {
				entradaUsuario = scanner.nextLine();
			} while (!pararProcessarComandos(leitor, entradaUsuario));

			scanner.close();
		} catch (FileNotFoundException | ConfiguracaoAplicativoInvalidaException e) {
			logger.erro(e.getMessage());
		}
	}

	private boolean pararProcessarComandos(LeitorArquivo leitorArquivo, String entradaUsuario) {
		try {
			String[] comandosDoUsuario = entradaUsuario.split(" ");
			Comando comandoAtual = comandos.getComandoPeloNome(comandosDoUsuario[0]);
			logger.info(comandoAtual.executar(leitorArquivo, gerarArgumentosComando(comandosDoUsuario)));

			return comandoAtual.isEncerramento();

		} catch (ComandoInvalidoException | PropriedadeNaoEncontradaException | ArgumentosDoComandoInvalidos e) {
			logger.atencao(e.getMessage());
			return false;
		} catch (Exception e) {
			logger.erro(e.getMessage());
			return true;
		}
	}

	private String[] gerarArgumentosComando(String[] comandosDoUsuario) {
		return Arrays.copyOfRange(comandosDoUsuario, 1, comandosDoUsuario.length);
	}
}
