package com.pbermejo.boletin5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej01Servidor {
	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		int numeroPuerto = 6001;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto) ;
		System.out.println("Esperando al cliente ..... ");
		Socket cliente = servidor.accept();
						
		//Se obtiene un stream para leer objetos
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream()) ;
		Ej04Ticket ej04Ticket = (Ej04Ticket)inObjeto.readObject();
		//Muestro
		System.out.println ("recibo: ");
		System.out.println("Visitante: "+ ej04Ticket.getVisitante());
		System.out.println("Tipo de entrada: "+ ej04Ticket.muestraTipo(ej04Ticket.getTipo()));
		System.out.println("A pagar: "+ ej04Ticket.getPrecio());
		
		
		// CERRAR STREAMS y SOCKETS
		inObjeto.close();
		cliente.close();
		servidor.close();
	}
}
