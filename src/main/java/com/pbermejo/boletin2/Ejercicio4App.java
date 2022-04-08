package com.pbermejo.boletin2;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio4App {
    private static final String FILE_PATH = "./src/main/java/com/pbermejo/boletin2/as_com.html";
    private static final Path PATH = Paths.get(FILE_PATH);
    private static File FILE = PATH.toFile();

    public static void main(String[] args) {
        try {
            URL url = new URL("https://as.com");
            URLConnection urlcon = url.openConnection();
            if(!Files.exists(PATH)){
                FILE.createNewFile();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));
            String i;
            while ((i = br.readLine()) != null) {
                bw.write(i);
            }
            bw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
