package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class _09SocketServer {

	public static void main(String[] args) {
		int porto = 6000;
		ServerSocket server;
		try {
			server = new ServerSocket(porto);
			System.out.println("Escoitando no " + server.getLocalPort());
			Socket cliente1 = server.accept();
			Socket cliente2 = server.accept();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
