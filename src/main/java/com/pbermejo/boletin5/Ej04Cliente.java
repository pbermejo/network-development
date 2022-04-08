package com.pbermejo.boletin5;
/*Escribe un programa que cuente el número de conexiones que vaya recibiendo.
 Este programa dispondrá de un socket stream servidor. Cada vez que un socket
 cliente se conecte, este le enviará un mensaje con el número de clientes
 conectados hasta ahora. Así pues, el primer cliente que se conecte recibirá
 un 1, el segundo un 2, el tercero un 3, etc.*/

import java.io.*;
import java.net.*;
public class Ej04Cliente {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6001;// puerto remoto
		try{
			Socket Cliente = new Socket(Host, Puerto);
			
			// CREO FLUJO DE SALIDA AL SERVIDOR
			PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
			
			// CREO FLUJO DE ENTRADA AL SERVIDOR
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			
			// FLUJO PARA ENTRADA ESTANDAR
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String cadena, eco="";
			eco=fentrada.readLine(); //recibo cadena del servidor. Número de cliente
			System.out.println(eco);
			System.out.println("Fin del servicio ... ");
			fsalida.close () ;
			fentrada.close();
			in.close();
			Cliente.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}//
}//