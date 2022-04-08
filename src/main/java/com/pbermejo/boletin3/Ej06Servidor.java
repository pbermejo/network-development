package com.pbermejo.boletin3;

import com.pbermejo.boletin3.utils.Factorial;
import com.pbermejo.boletin3.utils.Fibonacci;
import com.pbermejo.boletin3.utils.Resultado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej06Servidor {

    private static final int PORT = 55555;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    private Socket client;
    private int port = PORT;

    public Ej06Servidor(){
        try {
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

            int num = input.readInt();
            System.out.println("Recibido: " + num);
            int opcion = input.readInt();
            System.out.println("Recibido: " + opcion);
            Resultado resultado = new Resultado();
            Thread calculo = null;
            switch (opcion){
                case 1:
                    calculo = new Thread(new Factorial(num, resultado));
                    break;
                case 2:
                    calculo = new Thread(new Fibonacci(num, resultado));
                    break;
            }
            calculo.start();
            try {
                calculo.join();
                num = resultado.getNum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Cálculo realizado");
            output.writeInt(num);

            input.close();
            output.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ej06Servidor servidor = new Ej06Servidor();
        servidor.ejecutaPrograma();
    }
}
