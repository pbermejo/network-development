package gal.mosquera.clases.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class _10SocketCliente {

	public static void main(String[] args) {
		
		String host = "localhost";
		int porto = 6000;
		DataInputStream flujoEntrada;
		DataOutputStream flujoSalida;
		
		Socket cliente;
		try {
			System.out.println("CLIENTE INICIANDO");
			cliente = new Socket(host, porto);
			InetAddress dir = cliente.getInetAddress();
			flujoEntrada = new DataInputStream(cliente.getInputStream());
			flujoSalida = new DataOutputStream(cliente.getOutputStream());
			
			flujoSalida.writeUTF("Epa dende cliente");
			
			System.out.println("Recibindo do SERVIDOR: " + flujoEntrada.readUTF());
			
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
