package com.pbermejo.boletin5;
/*Escribe un programa que cuente el número de conexiones que vaya recibiendo.
 Este programa dispondrá de un socket stream servidor. Cada vez que un socket
 cliente se conecte, este le enviará un mensaje con el número de clientes
 conectados hasta ahora. Así pues, el primer cliente que se conecte recibirá
 un 1, el segundo un 2, el tercero un 3, etc.*/
 
 import java.io.*;
import java.net.*;

public class Ej04Servidor {
	public static void main(String args[]) throws IOException{
		int numCliente=0;
		ServerSocket servidor;
		servidor = new ServerSocket(6001);
		System.out.println(" Servidor iniciado ... ");
		while (true) {
			Socket cliente = new Socket();
			cliente=servidor.accept();//esperando cliente
			//Al HiloServidroCuenta le envía el socket y el número de cliente.
			Ej04ServidorHilo hilo = new Ej04ServidorHilo(cliente, ++numCliente);
			hilo.start(); // se atiende al cliente
		}
	}
}