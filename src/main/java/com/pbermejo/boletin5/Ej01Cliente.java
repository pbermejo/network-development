package com.pbermejo.boletin5;

import com.pbermejo.boletin2.utils.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Ej01Cliente {
	public static void main(String[] arg) throws IOException, ClassNotFoundException{
		String Host = "localhost";
		int Puerto = 6001;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO .... ");
		Socket cliente = new Socket(Host, Puerto);
		
		// para leer del teclado el nombre
		String nombre = IO.getUserInput("Introduzca su nombre: ");
		
		//Pedir el tipo de entrada hasta que se meta uno válido.
		int tipo = IO.menuChoice("Introduzca el tipo de entrada", new String[]{
				"Normal: 10€",
				"Niños: 3€",
				"Carnet joven: 5€",
				"3ª edad: 4€"
		});
		
		//Construimos el objeto
		Ej04Ticket ej04Ticket =new Ej04Ticket(nombre, tipo);
				
		//FLUJO DE salida para objetos
		ObjectOutputStream Sal = new ObjectOutputStream(cliente.getOutputStream()) ;
		
		// Se envía el objeto
		Sal.writeObject(ej04Ticket) ;
		//Muestro lo que envío
		System.out.println ("Envio: ");
		System.out.println("Visitante: "+ ej04Ticket.getVisitante());
		System.out.println("Tipo de entrada: "+ ej04Ticket.muestraTipo(ej04Ticket.getTipo()));
	
		//CERRAR STREAMS y SOCKETS
		Sal.close();
		cliente.close();
	}
}
