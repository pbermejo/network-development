package com.pbermejo.boletin3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej01ClienteComoServidor {

    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    private Socket client;
    private int port = PORT;

    public Ej01ClienteComoServidor(){
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

            String mensaje = input.readUTF();
            System.out.println("Recibido: " + mensaje);
            mensaje = mensaje.toUpperCase();
            System.out.println("Conversión realizada");
            output.writeUTF(mensaje);

            input.close();
            output.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ej01ClienteComoServidor cliente = new Ej01ClienteComoServidor();
        cliente.ejecutaPrograma();
    }
}
