package br.univel;

import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {

//		URLReader reader = new URLReader();
//		List<String> lista = reader.lerUrl();

		ArquivoReader reader = new ArquivoReader();
		List<String> lista = reader.lerArquivo();

		ProdutoParser parser = new ProdutoParser();
		List<Produto> listaPrd = parser.getProduto(lista);

		ClienteReader readerc = new ClienteReader();
		List<String> listac = readerc.lerArquivoCliente();

		ClienteParser parserc = new ClienteParser();
		List<Cliente> listaClt = parserc.getCliente(listac);

		listaPrd.forEach(e -> {
			System.out.println("Id: " + e.getId());
			System.out.println("Descrição: " + e.getDescricao());
			System.out.println("Preço: " + e.getPreco());
		});

		listaClt.forEach(e -> {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Endereço: " + e.getEndereco());
			System.out.println("Numero: " + e.getNumero());
			System.out.println("Complemento: " + e.getComplemento());
			System.out.println("Bairro: " + e.getBairro());
			System.out.println("Cidade: " + e.getCidade());
			System.out.println("Estado: " + e.getEstado());
			System.out.println("Cep: " + e.getCep());
			System.out.println("Telefone: " + e.getTelefone());
			System.out.println("Celular: " + e.getCelular());
		});

//		lista.forEach(e -> System.out.println(e));
//
//		lista.forEach(e -> {
//			System.out.print(e);
//		});
//
//		lista.forEach(System.out::println);
	}
}


