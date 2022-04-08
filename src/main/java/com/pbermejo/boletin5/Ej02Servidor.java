package com.pbermejo.boletin5;
/*Crear una aplicaci�n cliente/servidor que permita el env�o
 del contenido de ficheros al cliente. Para ello, el cliente
 se conectar� al servidor por el puerto 1500 y le solicitar�
 el nombre de un fichero del servidor. Si el fichero existe,
 el servidor, le enviar� el contenido del fichero al cliente
 y �ste lo mostrar� por pantalla. Si el fichero no existe,
 el servidor le enviar� al cliente un mensaje de error. Una vez
 que el cliente ha mostrado el fichero se finalizar� la conexi�n.*/


import java.io.* ;
import java.net.* ;


class Ej02Servidor {
	
	public static void main(String[] args) {
		final int Puerto=1500;
		String strLine;//Cadena donde vamos a leer cada linea del fichero.
		//Declaro los flujos de entrada y salida
		DataInputStream flujo_entrada=null;
		DataOutputStream flujo_salida=null;

		try {
			// Inicio el servidor en el puerto
			ServerSocket skServidor = new ServerSocket(Puerto);
			System.out.println("Escucho el puerto " + Puerto );


			// Se conecta un cliente
			Socket skCliente = skServidor.accept(); // Crea objeto
			System.out.println("Cliente conectado");


			// Creo los flujos de entrada y salida
			flujo_entrada = new DataInputStream( skCliente.getInputStream());
			flujo_salida= new DataOutputStream(skCliente.getOutputStream());


			// Lee el nombre del fichero, que recibe del cliente.
			String fichero=new String();
			fichero=flujo_entrada.readUTF();

			System.out.println("\tEl cliente quiere leer el fichero: " + fichero);

			
			FileInputStream fstream = new FileInputStream(fichero);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			//Vamos leyendo del fichero y enviando lo que leemos al cliente
			while ((strLine = br.readLine()) != null){
				  flujo_salida.writeUTF(strLine);
			}
		
			in.close();

			System.out.println("\tFichero enviado correctamente");
			flujo_salida.writeUTF("EOF");	



			// Espero que el cliente reciba todos los datos para terminar
			strLine=flujo_entrada.readUTF();


			// Se cierra la conexi�n
			skCliente.close();
			System.out.println("Cliente desconectado");

		} catch (FileNotFoundException e){//Si salta esta excepcion el fichero no existe,
					//enviamos al cliente el error y EOF para que pare de leer.
					try{
						flujo_salida.writeUTF("Error, el fichero no existe");
						System.out.println("\tError, el fichero no existe");
						flujo_salida.writeUTF("EOF");
						}catch (IOException ioe){
							System.out.println("Error de entrada y salida");
						}
		}catch( Exception e ) {
			System.out.println( e.getMessage() );
		}
}

}