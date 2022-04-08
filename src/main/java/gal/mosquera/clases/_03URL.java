package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class _03URL {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader br;
		String linha;
		
		try {
			//url = new URL("https://www.youtube.com/c/pildorasinformaticas");
			url = new URL("https://www.mclibre.org/");
		} catch (MalformedURLException e) {	
			e.printStackTrace();
		}
		
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
