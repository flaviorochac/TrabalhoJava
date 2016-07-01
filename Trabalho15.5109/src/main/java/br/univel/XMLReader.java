/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Tgamer
 */
public class XMLReader {
    
    private List<Cliente> listaClientes;
    private List<Produto> listaProdutos;
    XStream xs = new XStream(new DomDriver());
    
    public List<Cliente> lerClientes() throws FileNotFoundException{
        List<Cliente> listaClientes;
        File file = new File("Clientes.xml");
        FileReader fr = new FileReader(file);
        listaClientes = (List<Cliente>) xs.fromXML(fr);
         //TESTE DE IMPORTACAO DOS CLIENTES
        /*listaClientes.forEach(e -> {
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
		}); */
        return listaClientes;
    }  

   public List<Produto> lerProdutos() throws FileNotFoundException{
        List<Cliente> listaClientes;
        File file = new File("Produtos.xml");
        FileReader fr = new FileReader(file);
        listaProdutos = (List<Produto>) xs.fromXML(fr);
        /* System.out.println("TESTE DE IMPORTACAO DOS PRODUTOS");
        listaProdutos.forEach(e -> {
			System.out.println("Id: " + e.getId());
			System.out.println("Descrição: " + e.getDescricao());
			System.out.println("Preço: " + e.getPreco());
		});*/ 
        return listaProdutos;
    }  
    
}
