package gal.mosquera.clases.pruebas;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PruebaServer {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        ServerSocket server;
        Socket cliente;
        DataInputStream dis;
        DataOutputStream dos;

        try{
            server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            // Cliente 1
            cliente = server.accept();
            System.out.println("Cliente conectado");
            System.out.println(cliente.toString());

            // Cliente 2
//            cliente = server.accept();
//            System.out.println("Cliente conectado");
//            System.out.println(cliente.toString());

            // Flujo entrada cliente
            dis = new DataInputStream(cliente.getInputStream());
            System.out.println("Iniciando procesamiento de datos");
            int numero = dis.readInt();
            numero += 150;


            dos = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Enviado resultado a cliente. FIN");
            dos.writeInt(numero);

            
            server.close();

        } catch (IOException e){

        }
    }
}
