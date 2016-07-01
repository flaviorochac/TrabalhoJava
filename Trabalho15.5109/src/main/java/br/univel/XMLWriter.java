/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Tgamer
 */
public class XMLWriter {
    
    XStream xs = new XStream(new DomDriver());
    String xmlCliente,xmlProduto;
    
    public String getxmlCliente(){
        return xmlCliente;
    }
    public String getxmlProduto(){
        return xmlProduto;
    }
    
    public void GravarXMLCliente(List<Cliente> listaClt) throws FileNotFoundException{
        
        String clienteXML = xs.toXML(listaClt);
        this.xmlCliente = clienteXML;
        File file = new File("Clientes.xml");
        try (PrintWriter print = new PrintWriter(file)) {
            print.write(clienteXML);
            print.flush();
        }
        
        
    }
    
     public void GravarXMLProduto(List<Produto> listaPrd) throws FileNotFoundException, IOException{
        
        String produtoXML = xs.toXML(listaPrd);
        this.xmlProduto = produtoXML;
        File file = new File("Produtos.xml");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(produtoXML);
        out.close();
       // PrintWriter print = new PrintWriter(file);
       // print.write(produtoXML);
       // print.flush();
       // print.close();
       
       
        }
    
    
}
