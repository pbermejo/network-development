package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class _07URLConnection {

	//API tipo REST
	//https://www.youtube.com/watch?v=A_iCCKKlg4c
	private final static String URL_API = "https://jsonplaceholder.typicode.com/users";
	
	public static void main(String[] args) {
		BufferedReader br;
		URL url;
		URLConnection conexion;
		String linha;
		
		try {
			url = new URL(URL_API);
			conexion = url.openConnection();
			
			//Lectura resposta
			br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			while((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			
		}catch(IOException e) {
			System.err.println("Erro lendo da fonte: " + e.getMessage());
		}

	}

}
