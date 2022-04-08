package com.pbermejo.boletin3;

import com.pbermejo.boletin3.utils.IO;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej03Cliente{

    private static final int PORT = 55555;
    private final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;

    public Ej03Cliente(){
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

            String mensaje = IO.getUserInput("Introduce un mensaje: ");
            output.writeUTF(mensaje);
            System.out.println("Enviado: " + mensaje);
            System.out.println("Recibido: " + input.readUTF());

            input.close();
            output.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Ej03Cliente cliente = new Ej03Cliente( );
        cliente.ejecutaPrograma();
    }
}
