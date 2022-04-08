package gal.mosquera.clases.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class FioServidor extends Thread{

	private BufferedReader br;
	private PrintWriter bw;
	private Socket socket;
	
	public FioServidor(Socket socket) {
		this.socket = socket;		
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bw = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void run() {
		String cadea = "";
		
		try { 
			System.out.println("Comunico con : " + socket.toString());		
			while(!cadea.trim().equalsIgnoreCase("*")) {				
				cadea = br.readLine();				
				bw.println(cadea.trim().toUpperCase());
			}
			System.out.println("Fin con: " + socket.toString());
			br.close();
			bw.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
