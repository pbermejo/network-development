package com.pbermejo.boletin2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio7App {
    private static void pruebaHost(String host){
        try {
            InetAddress dns = InetAddress.getByName(host);
            System.out.println("IP: " + dns.getHostAddress());
            System.out.println("Nombre: " + dns.getHostName());
        } catch (UnknownHostException e) {
            System.out.println(host);
            System.out.println("--> El sitio no existe\n");
        }
    }

    public static void main(String[] args) {
        pruebaHost("es.wikipedia.org");
        pruebaHost("localhost");
    }
}
