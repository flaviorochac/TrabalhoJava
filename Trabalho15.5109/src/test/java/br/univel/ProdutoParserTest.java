package br.univel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProdutoParserTest {
	
	ArrayList<String> arrayList = (ArrayList<String>) new ArquivoReader().lerArquivo();
	
	
	@Test
	public void testGetProduto() {
		List<Produto> retorno = new ProdutoParser().getProduto(arrayList);
	}
}
