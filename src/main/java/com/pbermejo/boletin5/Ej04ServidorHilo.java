package com.pbermejo.boletin5;
/*Escribe un programa que cuente el número de conexiones que vaya recibiendo.
 Este programa dispondrá de un socket stream servidor. Cada vez que un socket
 cliente se conecte, este le enviará un mensaje con el número de clientes
 conectados hasta ahora. Así pues, el primer cliente que se conecte recibirá
 un 1, el segundo un 2, el tercero un 3, etc.*/
 


import java.io.*;
import java.net.*;
public class Ej04ServidorHilo extends Thread{
	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;
	int num;

	public Ej04ServidorHilo(Socket s, int numero){//CONSTRUCTOR
		num=numero;
		socket =s;
		//se crean flujos de entrada y salida
		try{
			fsalida = new PrintWriter(socket.getOutputStream(),true);//True significa que
			//el bufer de salida se vacía
			fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
			}catch( IOException e ) {
		System.out.println( "Excepción de entrada/salida" );
	}
	}

	public void run() {//tarea a realizar con el cliente
		// FLUJO PARA ENTRADA ESTANDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String cadena="";
		String cadenaMando="";
		try{
			System.out.println("COMUNICO CON: "+ socket.toString());
			fsalida.println("Eres el cliente número :"+Integer.toString(num));//enviar número de cliente
			System.out.println("FIN CON: "+ socket.toString());
			fsalida.close() ;
			fentrada.close() ;
			socket.close() ;
			}catch( IOException e ) {
		System.out.println( "Excepción de entrada/salida" );
		}
	}
}