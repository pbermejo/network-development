package com.pbermejo.boletin4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ej05Servidor {
    private static final int PUERTO = 9876;
    private static final String USUARIO = "admin";
    private static final String CONTRASEÑA = "abc123.";

    public static void main(String[] args) {
        try{
            DatagramSocket serverSocket = new DatagramSocket(PUERTO);
            byte[] recibidos = new byte[1024];
            byte[] enviados = new byte[1024];
            DatagramPacket paqEnviado;
            DatagramPacket paqRecibido;

            while(true) {
                // Usuario
                System.out.println("Esperando usuario...");
                paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);
                String usuario = new String(paqRecibido.getData()).trim();

                InetAddress IPOrigen = paqRecibido.getAddress();
                int puerto = paqRecibido.getPort();

                String respuesta;
                if(usuario.equals("USUARIO")){
                    respuesta = "Usuario incorrecto";
                } else{
                    respuesta = "Usuario correcto";
                }
                enviados = respuesta.getBytes();
                paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                serverSocket.send(paqEnviado);

                // Contraseña
                System.out.println("Esperando contraseña...");
                paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);

                String contraseña = new String(paqRecibido.getData()).trim();
                if(usuario.equals("USUARIO")){
                    respuesta = "Contraseña incorrecta";
                } else{
                    respuesta = "Contraseña correcta";
                }
                enviados = respuesta.getBytes();
                paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                serverSocket.send(paqEnviado);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
