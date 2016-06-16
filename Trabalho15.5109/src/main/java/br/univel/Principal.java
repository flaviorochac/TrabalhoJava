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

		listaPrd.forEach(e -> {
			System.out.println("Id: " + e.getId());
			System.out.println("Descrição: " + e.getDescricao());
			System.out.println("Preço: " + e.getPreco());
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


