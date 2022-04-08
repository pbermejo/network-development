package com.pbermejo.boletin3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Ej07Servidor {

    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    private Socket client;
    private int port = PORT;
    private int secret;
    private static final int MAX_NUM = 100;
    private static final int MIN_NUM = 1;
    private static Random r = new Random();
    private int clientNum;

    public Ej07Servidor(){
        try {
            this.secret = r.nextInt(MAX_NUM) + MIN_NUM;
            this.server = new ServerSocket(port);
            System.out.println("Servidor iniciado. Puerto " + server.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutaPrograma(){
        try {
            this.client = server.accept();
            System.out.println("Cliente conectado");

            // Entrada
            this.input = new DataInputStream(client.getInputStream());
            //Salida
            this.output = new DataOutputStream(client.getOutputStream());

            while((clientNum = input.readInt()) > 0){
                System.out.println("Recibido: " + clientNum);
                String mensaje = calcula();
                output.writeUTF(mensaje);
            }

            input.close();
            output.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String calcula(){
        String resultado = "";
        System.out.println(clientNum);
        System.out.println(secret);
        if(clientNum > secret){
            resultado = "El número es menor";
        } else if(clientNum < secret){
            resultado = "El número es mayor";
        } else{
            resultado = "Has acertado!! el número correcto es " + clientNum;
        }
        System.out.println("Cálculo realizado");

        return resultado;
    }

    public static void main(String[] args) {
        Ej07Servidor servidor = new Ej07Servidor();
        servidor.ejecutaPrograma();
    }
}
