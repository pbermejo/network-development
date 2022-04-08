package com.pbermejo.boletin3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej01ServidorComoCliente {
    private static final String MENSAJE = "Mensaje de prueba de SERVIDOR";
    private static final int PORT = 55555;
    private final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;

    public Ej01ServidorComoCliente(){
        try {
            this.client = new Socket(HOST, PORT);
            System.out.println("Cliente conectado a host por defecto: " + HOST + " en puerto por defecto " + PORT);
        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + HOST);
        } catch (ConnectException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("No es posible realizar conexión");
        }
    }

    public void ejecutaPrograma(){
        try {

            // Entrada
            this.input = new DataInputStream(client.getInputStream());
            //Salida
            this.output = new DataOutputStream(client.getOutputStream());

            output.writeUTF(MENSAJE);
            System.out.println("Enviado: " + MENSAJE);
            System.out.println("Recibido: " + input.readUTF());

            input.close();
            output.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Ej01ServidorComoCliente servidor = new Ej01ServidorComoCliente();
        servidor.ejecutaPrograma();
    }
}
