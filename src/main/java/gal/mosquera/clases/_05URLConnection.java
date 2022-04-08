package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class _05URLConnection {

	public static void main(String[] args) {
		BufferedReader br;
		String linha;
		PrintWriter output;
		
		try {
			URL url = new URL("http://www.agp.gal/resposta.php");
			URLConnection conexion = url.openConnection();
			conexion.setDoOutput(true);
			
			String cadena = "user=Pepe&password=abc123.";
			
			output = new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close();
			
			br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			br.close();
			
		} catch (MalformedURLException e) {			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
