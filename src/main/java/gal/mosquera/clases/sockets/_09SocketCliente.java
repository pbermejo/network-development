package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class _09SocketCliente {

	public static void main(String[] args) {
		
		String host = "localhost";
		int porto = 6000;
		
		Socket cliente;
		try {
			cliente = new Socket(host, porto);		
			InetAddress dir = cliente.getInetAddress();
			System.out.println("Porto local: " + cliente.getLocalPort());
			System.out.println("Porto remoto: " + cliente.getPort());
			System.out.println("Nome host/IP: " + cliente.getInetAddress());
			System.out.println("Host remoto: " + dir.getHostName());
			System.out.println("IP host remoto: " + dir.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
