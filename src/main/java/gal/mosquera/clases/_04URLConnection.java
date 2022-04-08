package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class _04URLConnection {

	public static void main(String[] args) {		
		URL url = null;
		BufferedReader br;
		String linha;
		URLConnection urlCon = null;
		
		try {
			url = new URL("https://www.mclibre.org/");
			urlCon = url.openConnection();
		
			br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
