package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _14SocketServer {

	public static void main(String[] args) throws IOException {

		ServerSocket servidor;
		servidor = new ServerSocket(6000);
		System.out.println("Servidor iniciado ...");
		while(true) {
			Socket cliente = servidor.accept();
			FioServidor fio = new FioServidor(cliente);
			fio.start();
		}
	}

}
