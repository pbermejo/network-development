package gal.mosquera.clases;

import java.net.MalformedURLException;
import java.net.URL;

public class _02URL {

	private static void visualizar(URL url) {
		System.out.println("\tURL completa: " + url.toString());
		System.out.println("\tgetProtocolol: " + url.getProtocol());
		System.out.println("\tgetHost: " + url.getHost());
		System.out.println("\tgetPort: " + url.getPort());
		System.out.println("\tgetFile: " + url.getFile());
		System.out.println("\tgetUserInfo: " + url.getUserInfo());
		System.out.println("\tgetPath: " + url.getPath());
		System.out.println("\tgetAuthority: " + url.getAuthority());
		System.out.println("\tgetQuery: " + url.getQuery());
		System.out.println("\tgetDefaultPort: " + url.getDefaultPort());
	}
	
	
	public static void main(String[] args) {
		
		URL url;		
		try {
			System.out.println("Constructor simple para URL");
			url = new URL("http://docs.oracle.com");		
			visualizar(url);
			System.out.println("Outro constructor simple para URL");
			url = new URL("http://localhost/PFC/gest/cli_gestion.php?s=3");		
			visualizar(url);
			System.out.println("Constructor complexo para URL");
			url = new URL("https", "as.com","/futbol");		
			visualizar(url);
			System.out.println("Constructor complexo para URL");
			url = new URL("https", "as.com", 8080, "/futbol/?id=3&n=7");		
			visualizar(url);
			System.out.println("Constructor complexo para URL");
			URL urlBase = new URL("https", "as.com","/futbol/");
			url = new URL(urlBase,"champions.html");
			visualizar(url);
			
		} catch (MalformedURLException e) {
		}

	}

}
