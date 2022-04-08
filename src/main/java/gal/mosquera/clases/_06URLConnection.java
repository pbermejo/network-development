package gal.mosquera.clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class _06URLConnection {

	public static void main(String[] args) {
		 try {
	            URL url = new URL("https://www.mclibre.org");
	            URLConnection urlcon = url.openConnection();
	            	            
	            System.out.println(urlcon.getAllowUserInteraction());
	            System.out.println(urlcon.getContentType());
	            System.out.println(urlcon.getURL());
	            LocalDateTime data = LocalDateTime.ofEpochSecond(urlcon.getLastModified()/1000, 0, ZoneId.of("Europe/Berlin").getRules().getOffset(LocalDateTime.now()));            
	            System.out.println("Fecha de última modificación: " + data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy: HH:mm:ss")));
	             
	            System.out.println("\n\n");
	            //Executing the below line would 
	            // print the value of Do Input field.
	            // System.out.println(urlcon.getDoInput());
	              
	            //Executing the below line would 
	            // print the value of Do Output field.
	            // System.out.println(urlcon.getDoOutput());
	              
	            //Executing the below line would 
	            // print the value of Last Modified field.
	            // System.out.println(new Date(urlcon.getLastModified()));
	              
	            //Executing the below line would 
	            // print the value of Content Encoding field.
	            // System.out.println(urlcon.getContentEncoding());
	              
	            //To get a map of all the fields of http header
	            Map<String, List<String>> header = urlcon.getHeaderFields();
	              
	            //print all the fields along with their value.
	            for (Map.Entry<String, List<String>> mp : header.entrySet()) {
	                System.out.print(mp.getKey() + " : ");
	                System.out.println(mp.getValue().toString());
	            }
	            System.out.println();
	            System.out.println("Código fonte completo da páxina:");
	            System.out.println("---------------------------------");
	              
	            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
	            String i;	              
	            while ((i = br.readLine()) != null) {
	                System.out.println(i);
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
