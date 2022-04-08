package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class _13SocketClienteObj {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

		String host = "localhost";
		int porto = 6000;
		
		System.out.println("Iniciando cliente ...");
		Socket cliente = new Socket(host,porto);
		
		ObjectInputStream objIn = new ObjectInputStream(cliente.getInputStream());
		Estudante est = (Estudante)objIn.readObject();
		
		System.out.println("Recibido obxecto " + est.getNome() + " " + est.getIdade());
		
		//Podería modificalo e envialo
		
		objIn.close();
		cliente.close();
		
	}

}
