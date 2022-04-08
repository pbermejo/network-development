package com.pbermejo.boletin4;

import java.io.IOException;
import java.net.*;
import java.util.Locale;

public class Ej04Servidor {

    private static final int PUERTO = 9876;

    public static void main(String[] args) {
        try{
            DatagramSocket serverSocket = new DatagramSocket(PUERTO);
            byte[] recibidos = new byte[1024];
            byte[] enviados = new byte[1024];
            String cadena;

            while(true) {
                System.out.println("Esperando datagrama...");
                recibidos = new byte[1024];
                DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);

                serverSocket.receive(paqRecibido);
                cadena = new String(paqRecibido.getData());

                InetAddress IPOrigen = paqRecibido.getAddress();
                int puerto = paqRecibido.getPort();

                System.out.println("\tOrigen: " + IPOrigen + ": " + puerto);
                System.out.println("\tMensaje recibido: " + cadena.trim());

                String mayuscula = cadena.trim().toUpperCase();
                enviados = mayuscula.getBytes();

                DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                serverSocket.send(paqEnviado);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
