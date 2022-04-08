package gal.mosquera.clases.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class _14SocketCliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

		String host = "localhost";
		int porto = 6000;		
		Socket cliente = new Socket(host, porto);		
		BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		//PrintWriter bw = new PrintWriter(cliente.getOutputStream(), true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String cadea, eco = "";
		do {
			System.out.println("Introduce cadea: ");
			cadea = teclado.readLine();
			bw.write(cadea);
			bw.newLine();
			bw.flush(); //Fundamental. Se fose con PrintWriter poñer o autoflush e o println
			System.out.println(" => ECO: " + br.readLine());
		}while(!cadea.trim().equals("*"));
		
		teclado.close();
		br.close();
		bw.close();
		cliente.close();
	}

}
