package com.pbermejo.boletin4;

import com.pbermejo.boletin2.utils.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.Buffer;

public class Ej04Cliente {
    private static final int PUERTO = 9876;

    public static void main(String[] args){

        try{
            DatagramSocket clientSocket = new DatagramSocket(PUERTO);
            clientSocket.setSoTimeout(5000);

            byte[] enviados = new byte[1024];
            DatagramPacket paqEnviado;
            InetAddress IPDestino = InetAddress.getLocalHost();

            String teclado;
            while(!(teclado = IO.getUserInput("Introduce texto (* para salir)")).equals("*")){
                enviados = teclado.getBytes();
                paqEnviado = new DatagramPacket(enviados, enviados.length, IPDestino, PUERTO);
            }

        } catch (SocketTimeoutException e){
            System.out.println("Tiempo de espera máximo excedido: El paquete se ha perdido");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
