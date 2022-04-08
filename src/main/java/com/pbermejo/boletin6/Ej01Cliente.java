package com.pbermejo.boletin6;

import com.pbermejo.boletin6.utils.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej01Cliente {

    private static final int PORT = 7000;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;

    public Ej01Cliente(){
        try {
            this.client = new Socket(HOST, PORT);
            System.out.println("Cliente conectado a host: " + HOST + " en puerto " + PORT);
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
                    "Suma",
                    "Resta",
                    "Multiplicación",
                    "División"
            };
            int operacion;
            while((operacion = IO.menuChoice("CALCULADORA", menu)) > -1){
                output.writeInt(operacion);
                int op1 = IO.getUserNumericInput("> Introduce operando 1 (entero)");
                output.writeInt(op1);
                int op2 = IO.getUserNumericInput("> Introduce operando 2 (entero)");
                output.writeInt(op2);
                double resultado = input.readDouble();
                System.out.println("Recibido: " + Double.toString(resultado));
                input.close();
                output.close();
                client.close();
                System.out.println("Cliente finalizado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Ej01Cliente cliente = new Ej01Cliente();
        cliente.ejecutaPrograma();
    }
}
