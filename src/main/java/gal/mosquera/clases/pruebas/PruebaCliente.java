package gal.mosquera.clases.pruebas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PruebaCliente {
    private static final int PORT = 8888;
    private static final String SERVER = "localhost";

    public static void main(String[] args) {
    	Socket cliente;
        DataInputStream dis;
        DataOutputStream dos;
        
        try{
            cliente = new Socket(SERVER, PORT);
            
            dos = new DataOutputStream(cliente.getOutputStream());
            dos.writeInt(76);
            
            dis = new DataInputStream(cliente.getInputStream());
            System.out.println("Numero modificado por server: " + dis.readInt());
            
            cliente.close();

        } catch (UnknownHostException e){
        	
        } catch (IOException e){

        }
    }
}
