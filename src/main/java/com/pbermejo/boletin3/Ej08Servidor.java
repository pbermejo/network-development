package com.pbermejo.boletin3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Ej08Servidor {
    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    private Socket client;
    private int port = PORT;

    public Ej08Servidor(){
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

            int opcion;
            double resultado = -1;
            int num;
            while((opcion = input.readInt()) > -1){
                if(opcion == 0){
                    input.close();
                    output.close();
                    client.close();
                    server.close();
                    System.out.println("Cliente finalizado");
                    break;
                }
                num = input.readInt();
                System.out.println("Recibido: " + num);
                switch (opcion) {
                    case 1:
                        resultado = calculaCuadrado(num);
                        break;
                    case 2:
                        resultado = calculaRaizCuadrada(num);
                        break;
                }
                output.writeDouble(resultado);
                System.out.println("Enviado " + Double.toString(resultado));
                System.out.println("Cálculo realizado");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double calculaCuadrado(int num){
        return (double) num * num;
    }

    private double calculaRaizCuadrada(int num) {
        double raiz = -1;
        try{
            raiz = Math.sqrt((double) num);
        } catch (Exception e){
            System.out.println("Imposible calcular la raíz cuadrada de un número negativo");
            System.out.println(e.getMessage());
        }
        return raiz;
    }

    public static void main(String[] args) {
        Ej08Servidor servidor = new Ej08Servidor();
        servidor.ejecutaPrograma();
    }
}
