package com.pbermejo.boletin4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ej03A {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        InetAddress destino = InetAddress.getLocalHost();

        DatagramSocket socket = new DatagramSocket();
        String mensaje = "TOKEN";
        byte[] enviados = new byte[5];
        enviados = mensaje.getBytes();

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, destino, PORT);
        socket.send(envio);

        byte[] buffer = new byte[10];
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        System.out.println("Esperando respuesta ...");
        socket.receive(recibo);
        String respuesta = new String(recibo.getData()).trim();
        System.out.println("Respuesta recibida: " + respuesta);
        socket.close();
    }
}
