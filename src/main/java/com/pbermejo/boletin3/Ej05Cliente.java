package com.pbermejo.boletin3;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej05Cliente {

    private static final int PORT = 55555;
    private static final String HOST = "localhost";
    private Socket client;

    public Ej05Cliente(String host, int port){
        try {
            this.client = new Socket(InetAddress.getByName(host), port);
            System.out.println("Cliente conectado a host por defecto: " + host + " en puerto por defecto " + port);
            client.close();
        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + host);
        } catch (ConnectException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("No es posible realizar conexión");
        }
    }

    public static void main(String[] args) {
        String host = HOST;
        int port = PORT;
        if(args.length > 0){
            host = args[0];
        }
        if(args.length > 1){
            port = Integer.parseInt(args[1]);
        }
        Ej05Cliente cliente = new Ej05Cliente(host, port);
    }
}
