package com.pbermejo.boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio3App {
    public static void main(String[] args) {

        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca IP o nombre de la máquina: ");
            InetAddress url = InetAddress.getByName(teclado.readLine());
            System.out.println("Salida para la URL");
            System.out.println("Método getHostName: " + url.getHostName());
            System.out.println("Método getHosAddress: " + url.getHostAddress());
            System.out.println("Método toString: " + url.toString());
            System.out.println("Método getCanonicalHostName: " + url.getCanonicalHostName());
            System.out.println("Direcciones IP para: " + url.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(url.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t" + direcciones[i]);
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
