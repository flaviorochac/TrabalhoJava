package br.univel;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteParser {
	int cont = 1;
	public List<Cliente> getCliente(List<String> listaClienteStr) {
		List<Cliente> listaClientePrd = new ArrayList<>();

		Pattern p = Pattern.compile("[0-9]+.*");

		listaClienteStr.forEach(e -> {
					listaClientePrd.add(getCliente(e));
		});

		return listaClientePrd;
	}

	private Cliente getCliente(String str) {

		// CSV....
		String[] itens = str.split(",");
		int id = cont++;
		String nome = itens[0];
		String endereco = itens[1];
		int numero = Integer.parseInt(itens[2]);
		String complemento = itens[3];
		String bairro = itens[4];
		String cidade = itens[5];
		String estado = itens[6];
		String cep = itens[7];
		String telefone = itens[8];
		String celular = itens[9];


		Cliente c = new Cliente(id, nome, endereco, numero, complemento, bairro, cidade,estado,cep,telefone,celular);
		return c;
	}

}