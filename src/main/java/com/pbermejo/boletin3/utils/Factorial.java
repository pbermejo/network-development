package com.pbermejo.boletin3.utils;

public class Factorial implements Runnable{
    private int num;
    private Resultado resultado;

    public Factorial(int num, Resultado resultado) {
        this.num = num;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        System.out.println("Comienza Factorial");
        for (int i = 1; i <= this.num; i++) {
            int r = resultado.getNum();
            resultado.setNum(r * i);
        }
        System.out.println("FIN Factorial");
    }
}