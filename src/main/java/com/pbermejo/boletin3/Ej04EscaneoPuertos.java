package com.pbermejo.boletin3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej04EscaneoPuertos {
    private static final int MAX_PORT = 1024;
    private static final String DEFAULT_HOST = "localhost";
    private Socket socket;
    private InetAddress host;

    public Ej04EscaneoPuertos(String host) {
        try {
            this.host = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + host);
            e.printStackTrace();
        }
    }

    private void probarPuerto(int port){
        try {
            socket = new Socket(host, port);
            System.out.println("Puerto " + port + " > ABIERTO!");
            socket.close();
        } catch (IOException e) {
            System.out.println("Puerto " + port + " > Cerrado");
        }
    }

    private void probarPuertos(){
        System.out.println("Comprobando puertos en " + host);
        for (int i = 1; i <= MAX_PORT; i++) {
            probarPuerto(i);
        }
    }

    public static void main(String[] args) {
        String host = DEFAULT_HOST;
        try{
            host = args[0];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No se ha definido un host. Se procederá a analizar puertos en " + host);
        }
        Ej04EscaneoPuertos escanerPuertos = new Ej04EscaneoPuertos(host);
        escanerPuertos.probarPuertos();
    }
}
