package com.pbermejo.boletin2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio8App {
    private static void pruebaHost(String host){
        try {
            InetAddress dns = InetAddress.getByName(host);
            System.out.println("Nombre: " + dns.getHostName());
            System.out.println("IP: " + dns.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Introduce una URL correcta");
        }
    }

    public static void main(String[] args) {

        try{
            pruebaHost(args[0]);
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No se ha especificado un host");
        }
    }
}
