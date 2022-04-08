package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class _12UDPServidor {

	public static void main(String[] args) throws IOException {

		byte[] buffer = new byte[5];
		DatagramSocket socket = new DatagramSocket(12345);
		
		//Agardando datagrama
		System.out.println("Esperando datagrama");
		DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(recibo);		
		String paquete = new String(recibo.getData()).trim();//obteño a información
		
		System.out.println("Servidor recibe: " + paquete);
		//Contar as
		int contador = 0;
		for (int i= 0; i < paquete.length(); i++) {
			if(paquete.charAt(i) == 'a')
				contador++;
		}
		
		InetAddress IPOrixe = recibo.getAddress();
		int portoOrixe = recibo.getPort();
		System.out.println("Enviando información ao cliente, número de as: " + contador);
		byte b = (byte) contador;
		byte[] enviados = new byte[1024];
		enviados[0] = b;
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrixe, portoOrixe);
		socket.send(envio);
		socket.close();

		
		
		
		socket.close();
	}

}
