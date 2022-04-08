package com.pbermejo.boletin2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.pbermejo.boletin2.utils.IO;

public class Ejercicio10App {
    private static String obtenerIP(String host){
        String ip = "";
        try {
            ip = InetAddress.getByName(host).getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        return ip;
    }
    private static String obtenerURL(String host){
        String url = "";
        try {
            url = InetAddress.getByName(host).getHostName();
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        return url;
    }

    public static void menu() throws IOException{
        String[] menu = {
                "SALIR [->",
                "Obtener IP",
                "Obtener URL"
        };
        switch (IO.menuChoice("OPCIONES", menu)) {
            case 0:
                System.exit(0);
                break;
            case 1:
                String ip = obtenerIP(IO.getUserInput("Escribe la ip: "));
                System.out.println("La ip es: " + ip);
                menu();
                break;
            case 2:
                String url = obtenerURL("Escribe la dirección: ");
                System.out.println("La dirección es: " + url);
                menu();
        }
    }

    public static void main(String[] args) throws IOException {
        menu();
    }
}
