package com.pbermejo.boletin2;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio2App {

    public static void main(String[] args) {
        Ejercicio2App obj = new Ejercicio2App();

        try{

            /**
             * https://www.turismo.gal/que-facer/camino-de-santiago
             */
            System.out.println("Constructor simple para URL principal");
            obj.display(new URL("https://www.turismo.gal"));

            System.out.println("Constructor de cadena para URL principal + directorio");
            obj.display(new URL("https://www.turismo.gal/que-facer/camino-de-santiago"));

            System.out.println("Constructor con protocolo, host y directorio");
            obj.display(new URL("https", "www.turismo.gal", "/que-facer/camino-de-santiago"));

            System.out.println("Constructor con protocolo, host, puerto y directorio");
            obj.display(new URL("https", "www.turismo.gal", 80, "/que-facer/camino-de-santiago"));

            System.out.println("Constructor de dirección absoluta a partir de dirección de host y URL relativa");
            URL baseURL = new URL("https://www.turismo.gal");
            obj.display(new URL(baseURL,"que-facer/camino-de-santiago"));


            /**
             * ftp://ftp.microsoft.com/Services/Education/Licensing/UseTerms_Spanish_Spain.doc
             */
            System.out.println("Constructor simple para URL principal");
            obj.display(new URL("ftp://ftp.microsoft.com"));

            System.out.println("Constructor de cadena para URL principal + directorio");
            obj.display(new URL("ftp://ftp.microsoft.com/Services/Education/Licensing/UseTerms_Spanish_Spain.doc"));

            System.out.println("Constructor con protocolo, host y directorio");
            obj.display(new URL("ftp", "ftp.microsoft.com", "/Services/Education/Licensing/UseTerms_Spanish_Spain.doc"));

            System.out.println("Constructor con protocolo, host, puerto y directorio");
            obj.display(new URL("ftp", "ftp.microsoft.com", 21,"/Services/Education/Licensing/UseTerms_Spanish_Spain.doc"));

            System.out.println("Constructor de dirección absoluta a partir de dirección de host y URL relativa");
            baseURL = new URL("ftp://ftp.microsoft.com");
            obj.display(new URL(baseURL,"/Services/Education/Licensing/UseTerms_Spanish_Spain.doc"));

        } catch (MalformedURLException e){
            System.out.println(e);
            System.out.println("Asegúrate de que está conectado para que funcione bien");
        }
    }

    private void display(URL url){
        System.out.print(url.getProtocol() + " ");
        System.out.print(url.getHost() + " ");
        System.out.print(url.getPort() + " ");
        System.out.print(url.getFile() + " ");
        System.out.println(url.toString() + " ");
        System.out.println();
    }
}
