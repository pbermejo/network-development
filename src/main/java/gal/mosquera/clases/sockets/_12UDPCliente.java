package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class _12UDPCliente {

	public static void main(String[] args) throws IOException {

		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345;				
		
		//ENVIANDO DATAGRAMA		
		DatagramSocket socket = new DatagramSocket();
		String s = "estamos escribindo con letras a";
		byte[] enviados = new byte[5];
		enviados = s.getBytes();
		
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, destino, port);
		socket.send(envio);
		
		//Recibimos a resposta do servidor
		byte[] recibidos = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
		System.out.println("Agardando datagrama ...");
		socket.receive(recibo);
		byte[] hh = recibo.getData();
		int num = hh[0];
		System.out.println("O número de caracteres a: " + num);
		socket.close();		
		
	}

}
