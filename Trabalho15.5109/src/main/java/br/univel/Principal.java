package br.univel;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {

		ArquivoReader reader = new ArquivoReader();
		List<String> lista = reader.lerArquivo();

		ProdutoParser parser = new ProdutoParser();
		List<Produto> listaPrd = parser.getProduto(lista);

		ClienteReader readerc = new ClienteReader();
		List<String> listac = readerc.lerArquivoCliente();

		ClienteParser parserc = new ClienteParser();
		List<Cliente> listaClt = parserc.getCliente(listac);

                //XMLWriter xw = new XMLWriter();
                //xw.GravarXMLCliente(listaClt);
                //xw.GravarXMLProduto(listaPrd);
                
                //XMLReader xr = new XMLReader();
                //xr.lerClientes();   
                //xr.lerProdutos();
                
                H2Con h2 = new H2Con();
                h2.abrirConexao();
                //h2.resetProduto();
                //h2.createProduto(listaPrd);
                //h2.readProduto();
                //h2.resetCliente();
                //h2.createCliente(listaClt);
                //h2.readCliente();
                List<Cliente> listaCltH2;
                List<Produto> listaPrdH2;
                listaCltH2 = h2.readClienteBanco();
                listaPrdH2 = h2.readProdutoBanco();
                LerRelatorio lr = new LerRelatorio();
                lr.imprimirProdutos();
                
                TelaPrincipal telaP = new TelaPrincipal(listaCltH2, listaPrdH2);
                telaP.setVisible(true);
	}
}



