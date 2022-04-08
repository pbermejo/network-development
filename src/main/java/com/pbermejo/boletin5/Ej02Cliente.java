package com.pbermejo.boletin5;
/*Crear una aplicaci�n cliente/servidor que permita el env�o
 del contenido de ficheros al cliente. Para ello, el cliente
 se conectar� al servidor por el puerto 1500 y le solicitar�
 el nombre de un fichero del servidor. Si el fichero existe,
 el servidor, le enviar� el contenido del fichero al cliente
 y �ste lo mostrar� por pantalla. Si el fichero no existe,
 el servidor le enviar� al cliente un mensaje de error. Una vez
 que el cliente ha mostrado el fichero se finalizar� la conexi�n.*/

import java.io.*;
import java.net.*;

class Ej02Cliente {
	static final String HOST = "localhost";
	static final int Puerto=1500;

	public static void main( String[] args) {
		final String HOST = "localhost";
		final int Puerto=1500;
	
		String fichero=new String();
		String datos=new String();

		try{
			// Me conecto al puerto
			Socket skCliente = new Socket(HOST , Puerto );

			// Creo los flujos de entrada y salida
			DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
			DataOutputStream flujo_salida= new DataOutputStream(skCliente.getOutputStream());

			//Leemos el nombre del fichero
			System.out.println("Introduce el nombre del fichero a leer:");
			// para leer del teclado
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			fichero=reader.readLine();
			//Enviamos al servidor el nombre del fichero
			flujo_salida.writeUTF(fichero);			

			do{ //Vamos leyendo lo que nos env�a el servidor
				//hasta que recibamos el indicador de fin de fichero (EOF).
				datos=flujo_entrada.readUTF();	
				if(!datos.equals("EOF"))
					//Mostramos lo que leemos por pantalla
					System.out.println(datos);	
			}while(!datos.equals("EOF"));		

			flujo_salida.writeUTF("FIN");	

			// Se cierra la conexión
			skCliente.close();

		} catch( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

}