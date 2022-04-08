package com.pbermejo.boletin3;

import com.pbermejo.boletin2.utils.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej08Cliente {

    private static final int PORT = 7000;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;

    public Ej08Cliente(String host, int port){
        try {
            this.client = new Socket(host, port);
            System.out.println("Cliente conectado a host: " + host + " en puerto " + port);
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

            String[] menu = {
                    "SALIR [->",
                    "Calcular cuadrado",
                    "Calcular raíz cuadrada"
            };
            int opcion;
            while((opcion = IO.menuChoice("CÁLCULOS", menu)) > -1){
                output.writeInt(opcion);
                if(opcion == 0){
                    input.close();
                    output.close();
                    client.close();
                    System.out.println("Cliente finalizado");
                    break;
                }
                int num = IO.getUserNumericInput("> Introduce un entero");
                output.writeInt(num);
                double resultado = input.readDouble();
                System.out.println("Recibido: " + Double.toString(resultado));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String host = HOST;
        if(args.length > 0){
            host = args[0];
        }
        Ej08Cliente cliente = new Ej08Cliente(host, PORT);
        cliente.ejecutaPrograma();
    }
}
