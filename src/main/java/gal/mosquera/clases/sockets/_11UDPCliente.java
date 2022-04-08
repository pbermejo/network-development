package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class _11UDPCliente {

	public static void main(String[] args) throws IOException {

		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345;
		
		byte[] mensaxe = new byte[1024];
		String saudo = "Enviando Saúdos!!!";
		mensaxe = saudo.getBytes();
		
		//ENVIANDO DATAGRAMA
		DatagramPacket envio = new DatagramPacket(mensaxe, mensaxe.length, destino, port);
		DatagramSocket socket = new DatagramSocket(34567);
		System.out.println("Enviando Datagrama de lonxitude " + mensaxe.length);
		System.out.println("Host destino: " + destino.getHostName());
		System.out.println("IP destino: " + destino.getHostAddress());
		System.out.println("Porto local do socket " + socket.getLocalPort());
		System.out.println("Porto ao que envío: " + envio.getPort());
		
		socket.send(envio);
		socket.close();
		
	}

}
