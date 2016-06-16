package br.univel;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class URLReader {



	private static final String URL = "http://www.oracle.com/";

public List<String> lerUrl(){
		List<String> lista = new ArrayList<String>();
	try{

		URL url = new URL(URL);
		try (BufferedReader in = new BufferedReader(new InputStreamReader (url.openStream()))) {
			String inputLine = null;

			while ((inputLine = in.readLine()) != null){
				//System.out.println(inputLine);
				lista.add(inputLine);
			}
		}
	} catch (IOException e){
		throw new RuntimeException("Deu ruim!",e);
	}

	return lista;
}
}
