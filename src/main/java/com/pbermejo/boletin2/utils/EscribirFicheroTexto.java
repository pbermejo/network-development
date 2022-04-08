package com.pbermejo.boletin2.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroTexto {

    public static void main(String[] args) {
// Validamos si existe el fichero
        String sFichero = "c:/fichero.txt";
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            System.out.println("El fichero " + sFichero + " ya existe");
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new
                        FileWriter(sFichero));
                for (int x = 0; x < 10; x++)
                    bw.write("Fila numero " + x + "\r\n");
                bw.close();
                System.out.println("archivo creado");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
