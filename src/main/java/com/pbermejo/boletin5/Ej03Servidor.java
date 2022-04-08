package com.pbermejo.boletin5;
/*Implementación de un cliente y un servidor de eco TCP. 
Crea el código Java de un cliente que recibe un mensaje de un servidor
 y le contesta; por otro lado, el servidor está escuchando en un determinado puerto,
 acepta la conexión del cliente, recoge su mensaje y le contesta. Un breve diálogo.
 Haz que los mensajes se introduzcan por teclado, hasta que uno de ellos escriba FIN,
 entonces la conversación se terminará. */
 
import java.io.*;
import java.net.*;

public class Ej03Servidor {
	public static void main(String args[]) throws IOException{
		ServerSocket servidor;
		servidor = new ServerSocket(6001);
		System.out.println(" Servidor iniciado ... ");
		while (true) {
			Socket cliente = new Socket();
			cliente=servidor.accept();//esperando cliente
			//Ex03HiloServidorECO hilo = new Ex03HiloServidorECO(cliente);
			//hilo.start (); // se atiende al cliente
		}
	}
}