package br.com.bettoni.involves.leitor;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface InputStreamHelper {

	InputStream getStreamDadosOrigem() throws FileNotFoundException;

}