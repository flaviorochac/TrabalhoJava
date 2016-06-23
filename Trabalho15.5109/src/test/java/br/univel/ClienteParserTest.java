package br.univel;

import static org.junit.Assert.*;
import br.univel.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteParserTest {

	ClienteReader AR = new ClienteReader();
	ArrayList<String> lista = (ArrayList<String>) AR.lerArquivoCliente();
	ClienteParser Cp = new ClienteParser();
	
	@Test
	public void testGetCliente() {
		List<Cliente> listateste = Cp.getCliente(lista);
		assertFalse(listateste.isEmpty());
	}

}
