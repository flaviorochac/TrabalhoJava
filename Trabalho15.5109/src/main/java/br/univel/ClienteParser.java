package br.univel;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteParser {

	public List<Cliente> getCliente(List<String> listaClienteStr) {
		List<Cliente> listaClientePrd = new ArrayList<>();

		Pattern p = Pattern.compile("[0-9]+.*");

		listaClienteStr.forEach(e -> {
				Matcher m = p.matcher(e);
				if (m.matches()) {
					listaClientePrd.add(getCliente(e));
			}

		});

		return listaClientePrd;
	}

	private Cliente getCliente(String str) {

		// CSV....
		String[] itens = str.split(",");
		int id = Integer.parseInt(itens[0]);
		String nome = itens[1];
		String endereco = itens[2];
		int numero = Integer.parseInt(itens[3]);
		String complemento = itens[4];
		String bairro = itens[5];
		String cidade = itens[6];
		String estado = itens[7];
		String cep = itens[8];
		String telefone = itens[9];
		String celular = itens[10];


		Cliente c = new Cliente(id, nome, endereco, numero, complemento, bairro, cidade,estado,cep,telefone,celular);
		return c;
	}

}