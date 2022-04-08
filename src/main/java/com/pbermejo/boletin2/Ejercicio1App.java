package com.pbermejo.boletin2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio1App {
    public static void main(String[] args) {
        try{
            System.out.println("-> Dirección IP de una URL, por nombre");
            InetAddress address = InetAddress.getByName("www.google.es");
            System.out.println(address);

            System.out.println("-> Nombre a partir de una dirección");
            address = InetAddress.getByName(address.getHostAddress());
            System.out.println(address);

            System.out.println("-> Nombre a partir de una dirección");
            byte[]ipNum = address.getAddress();
            address = InetAddress.getByAddress(ipNum);
            System.out.println(address.getHostName());

            System.out.println("-> Nombre actual de localhost");
            System.out.println(InetAddress.getLocalHost().getHostName());

            System.out.println("-> Dirección IP actual de localhost");
            address = InetAddress.getLocalHost();
            System.out.println(address.toString().substring(address.toString().indexOf("/" + 1)));

            byte[] ip = address.getAddress();
            for (int i = 0; i < ip.length; i++) {
                int uByte = ip[i] < 0 ? ip[i] + 256 : ip[i];
                System.out.print(uByte + ".");
            }
            System.out.println();

            System.out.println("-> Direcciones IP actuales de localhost");
            address = InetAddress.getLocalHost();
            InetAddress[] direcciones = address.getAllByName("localhost");
            for (InetAddress d :
                    direcciones) {
                System.out.println(d.toString().substring(d.toString().indexOf("/") + 1));
            }

        } catch (UnknownHostException e){
            System.out.println(e);
            System.out.println("Asegúrate de que está conectado para que funcione bien");
        }
    }
}
