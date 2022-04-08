package com.pbermejo.boletin4;

import com.pbermejo.boletin2.utils.IO;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Ej05Cliente {
    private static final int PUERTO = 9876;

    public static void main(String[] args){

        try{
            DatagramSocket clientSocket = new DatagramSocket(PUERTO);
            byte[] enviados = new byte[1024];
            byte[] recibidos = new byte[1024];
            InetAddress IPDestino = InetAddress.getLocalHost();
            DatagramPacket paqEnviado;
            DatagramPacket paqRecibido;

            String usuario = IO.getUserInput("Usuario: ");
            enviados = usuario.getBytes();
            paqEnviado = new DatagramPacket(enviados, enviados.length, IPDestino, PUERTO);
            clientSocket.send(paqEnviado);

            paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            clientSocket.receive(paqRecibido);
            System.out.println(new String(paqRecibido.getData()).trim());

            String contraseña = IO.getUserInput("Contraseña: ");
            enviados = contraseña.getBytes();
            paqEnviado = new DatagramPacket(enviados, enviados.length, IPDestino, PUERTO);
            clientSocket.send(paqEnviado);

            paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            clientSocket.receive(paqRecibido);
            System.out.println(new String(paqRecibido.getData()).trim());

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
