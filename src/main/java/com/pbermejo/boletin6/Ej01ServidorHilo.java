package com.pbermejo.boletin6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ej01ServidorHilo extends Thread{

    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;

    public Ej01ServidorHilo(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try{

            this.input = new DataInputStream(client.getInputStream());
            this.output = new DataOutputStream(client.getOutputStream());

            int operacion = input.readInt();
            double resultado = -1;
            int op1 = input.readInt();
            int op2 = input.readInt();

            switch (operacion){
                case 0:
                    resultado = op1 + op2;
                    break;
                case 1:
                    resultado = op1 - op2;
                    break;
                case 2:
                    resultado = op1 * op2;
                    break;
                case 3:
                    resultado = op1 / op2;
                    break;
            }
            output.writeDouble(resultado);
            System.out.println("Enviado " + Double.toString(resultado));
            System.out.println("Cálculo realizado");
            input.close();
            output.close();
            client.close();

        } catch (IOException e){
            System.out.println( "Excepción de entrada/salida" );
        }
    }
}
