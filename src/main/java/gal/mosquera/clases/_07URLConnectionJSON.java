package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;

public class _07URLConnectionJSON {

	//API tipo REST
	//https://www.youtube.com/watch?v=A_iCCKKlg4c
	private final static String URL_API = "https://jsonplaceholder.typicode.com/users/1";
	
	public static void main(String[] args) {
		BufferedReader br;
		URL url;
		URLConnection conexion;
		String linha;
		
		try {
			//url = new URL(URL_API);
			//conexion = url.openConnection();
			
			//Lectura resposta pero en formato JSON			
		    ReadJson reader = new ReadJson();       // To ReadJson in order to read from url.  
		    JSONObject json = reader.readJsonFromUrl(URL_API);  // calling method in order to read.
		    System.out.println(json.toString()); 
			
		}catch(Exception e) {
			//System.err.println("Erro lendo da fonte: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
