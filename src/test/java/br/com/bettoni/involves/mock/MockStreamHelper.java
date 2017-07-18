package br.com.bettoni.involves.mock;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import br.com.bettoni.involves.leitor.InputStreamHelper;

public class MockStreamHelper implements InputStreamHelper {

	@Override
	public InputStream getStreamDadosOrigem() throws FileNotFoundException {
		StringBuilder csv = new StringBuilder();
		csv.append("ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion");
		csv.append("\r\n");
		csv.append("1100015,RO,Alta Floresta D'Oeste,,-61.9998238963,-11.9355403048,Alta Floresta D'Oeste,,Cacoal,Leste Rondoniense");
		csv.append("\r\n");
		csv.append("1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense");
		csv.append("\r\n");
		csv.append("1100031,RO,Cabixi,,-60.5443135812,-13.4997634597,Cabixi,,Colorado do Oeste,Leste Rondoniense");
		csv.append("\r\n");
		csv.append("1100049,AC,Cacoal,,-61.4429442118,-11.4338650287,Cacoal,,Cacoal,Leste Rondoniense");
		csv.append("\r\n");
		return new ByteArrayInputStream(csv.toString().getBytes());
	}

}
