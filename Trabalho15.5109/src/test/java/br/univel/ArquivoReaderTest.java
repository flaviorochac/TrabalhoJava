package br.univel;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

public class ArquivoReaderTest {

	ArquivoReader testeAR = new ArquivoReader();
	
	
	@Test
	public void testLerArquivo() {		
		ArrayList<String> lista = (ArrayList<String>) testeAR.lerArquivo();
		assertFalse(lista.isEmpty());
	}

}
