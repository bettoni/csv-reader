package br.com.bettoni.involves.cliente;

public class LogClienteConsole {

	private void escrever(String string) {
		System.out.println(string);
	}

	public void escreverMensagemInicial(String caminhoArquivo, String comandoDisponiveis) {
		this.escrever("DESAFIO JAVA - INVOLVES ");
		this.escrever("Caminho do configurado do arquivo: " + caminhoArquivo.toUpperCase());
		this.escrever("Comandos dispon�veis: " + comandoDisponiveis.toUpperCase());
	}

	public void atencao(String mensagem) {
		this.escrever("Aten��o! " + mensagem);
	}
	
	public void erro(String mensagem) {
		this.escrever("[ERRO] " + mensagem + "\nO aplicativo ser� encerrado");
	}

	public void info(String mensagem) {
		this.escrever(mensagem);
	}
}
