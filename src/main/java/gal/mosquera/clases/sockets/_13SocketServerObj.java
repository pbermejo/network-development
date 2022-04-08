package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _13SocketServerObj {

	public static void main(String[] args) throws IOException {

		int numPorto = 6000;
		ServerSocket servidor = new ServerSocket(numPorto);
		System.out.println("Agardando ao cliente");
		
		Socket cliente = servidor.accept();
		
		ObjectOutputStream outObxecto = new ObjectOutputStream(cliente.getOutputStream());
		
		Estudante est = new Estudante("Xan Chouza Carou", 44);
		outObxecto.writeObject(est);
		System.out.println("Enviando obxecto");
		
		outObxecto.close();
		cliente.close();
		servidor.close();
	}

}
