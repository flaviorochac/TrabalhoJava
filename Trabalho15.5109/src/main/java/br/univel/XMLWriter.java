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
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Tgamer
 */
public class XMLWriter {
    
    XStream xs = new XStream(new DomDriver());    
    
    public void GravarXMLCliente(List<Cliente> listaClt) throws FileNotFoundException{
        
        String clienteXML = xs.toXML(listaClt);
        File file = new File("Clientes.xml");
        PrintWriter print = new PrintWriter(file);
        print.write(clienteXML);
        print.flush();
        print.close(); 
        
    }
    
     public void GravarXMLProduto(List<Produto> listaPrd) throws FileNotFoundException{
        
        String produtoXML = xs.toXML(listaPrd);
        System.out.println(produtoXML);
        File file = new File("Produto.xml");
        PrintWriter print = new PrintWriter(file);
        print.write(produtoXML);
        print.flush();
        print.close();   
        }
    
    
}
