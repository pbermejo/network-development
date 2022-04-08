package com.pbermejo.boletin3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej02Servidor {

    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    private Socket client;
    private int port = PORT;

    public Ej02Servidor(){
        try {
            this.server = new ServerSocket(port);
            System.out.println("Servidor iniciado. Puerto " + server.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutaPrograma(){
        try {
            this.client = server.accept();
            System.out.println("Cliente conectado");

            // Entrada
            this.input = new DataInputStream(client.getInputStream());
            //Salida
            this.output = new DataOutputStream(client.getOutputStream());

            int mensaje = input.readInt();
            System.out.println("Recibido: " + mensaje);
            mensaje *= 2;
            System.out.println("Cálculo realizado");
            output.writeInt(mensaje);

            input.close();
            output.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ej02Servidor servidor = new Ej02Servidor();
        servidor.ejecutaPrograma();
    }
}
