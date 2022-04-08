package com.pbermejo.boletin6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej01Servidor {
    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;

    public Ej01Servidor(){
        try {
            this.server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado. Puerto " + server.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutaPrograma(){
        try {
            System.out.println("Cliente conectado");

            while (true) {
                Socket client = new Socket();
                client = server.accept();
                Ej01ServidorHilo hilo = new Ej01ServidorHilo(client);
                hilo.start(); // se atiende al cliente
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
        Ej01Servidor servidor = new Ej01Servidor();
        servidor.ejecutaPrograma();
    }
}
