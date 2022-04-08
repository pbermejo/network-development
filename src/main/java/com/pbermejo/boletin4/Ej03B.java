package com.pbermejo.boletin4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ej03B {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        byte[] buffer = new byte[5];
        DatagramSocket socket = new DatagramSocket(PORT);
        System.out.println("Esperando datos...");
        DatagramPacket datosPaquete = new DatagramPacket(buffer, buffer.length);

        socket.receive(datosPaquete);
        InetAddress IPOrigen = datosPaquete.getAddress();
        int puertoOrigen = datosPaquete.getPort();
        System.out.println("Datos recibidos");
        String mensajeRecibido = new String(datosPaquete.getData()).trim();
        System.out.println("Servidor recibe: " + mensajeRecibido);

        if(mensajeRecibido.equals("TOKEN")){
            System.out.println("Preparando respuesta...");
            String respuesta = "Recibido";
            byte[] envio = new byte[10];
            envio = respuesta.getBytes();
            DatagramPacket paqueteEnvio = new DatagramPacket(envio, envio.length, IPOrigen, puertoOrigen);
            socket.send(paqueteEnvio);
            System.out.println("Enviando información al cliente: " + respuesta);
        }
        socket.close();
    }
}
