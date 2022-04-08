package gal.mosquera.clases.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _10SocketServer {

	public static void main(String[] args) {
		int porto = 6000;
		ServerSocket server;
		InputStream entrada;
		DataInputStream flujoEntrada;
		DataOutputStream flujoSalida;
		
		try {
			server = new ServerSocket(porto);
			System.out.println("Escoitando no " + server.getLocalPort());
			Socket cliente = null;
			
			cliente = server.accept();
			entrada = cliente.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
			System.out.println("Recibindo de cliente: " + flujoEntrada.readUTF());
			
			flujoSalida = new DataOutputStream(cliente.getOutputStream());
			flujoSalida.writeUTF("Hi cliente!!!");
			
			flujoSalida.close();
			flujoEntrada.close();
			cliente.close();
			server.close();
			
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
