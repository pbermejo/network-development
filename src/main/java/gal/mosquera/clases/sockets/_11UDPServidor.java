package gal.mosquera.clases.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class _11UDPServidor {

	public static void main(String[] args) throws IOException {

		byte[] buffer = new byte[1024];
		DatagramSocket socket = new DatagramSocket(12345);
		
		//Agardando datagrama
		System.out.println("Esperando datagrama");
		DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(recibo);
		int bytesRecibidos = recibo.getLength();//obteño número de bytes
		String paquete = new String(recibo.getData());//obteño a información
		
		
		//Amoso a información
		System.out.println("Número de bytes recibidos: " + bytesRecibidos);
		System.out.println("Contido do paquete: " + paquete.trim());
		System.out.println("Porto orixe de mensaxe: " + recibo.getPort());
		System.out.println("IP de orixe: " + recibo.getAddress().getHostAddress());
		System.out.println("Porto destino da mensaxe: " + socket.getLocalPort());
		
		socket.close();
	}

}
