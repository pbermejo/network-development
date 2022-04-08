package com.pbermejo.boletin3;

import com.pbermejo.boletin3.utils.IO;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej06Cliente{

    private static final int PORT = 55555;
    private final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;

    public Ej06Cliente(){
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

            int numero = IO.getUserNumericInput("Introduce un número: ");
            String[] menu = {
                    "SALIR [->",
                    "Obtener factorial",
                    "Obtener fibonacci"
            };
            int opcion = IO.menuChoice("OPCIONES", menu);

            output.writeInt(numero);
            System.out.println("Enviado: " + numero);
            output.writeInt(opcion);
            System.out.println("Enviado: " + opcion);
            System.out.println("Recibido: " + input.readInt());

            input.close();
            output.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Ej06Cliente cliente = new Ej06Cliente();
        cliente.ejecutaPrograma();
    }
}
