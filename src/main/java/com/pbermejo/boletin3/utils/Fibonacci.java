package com.pbermejo.boletin3.utils;

public class Fibonacci implements Runnable{
    private int num;
    private Resultado resultado;

    public Fibonacci(int num, Resultado resultado) {
        this.num = num;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        System.out.println("Comienza Fibonacci");
        for (int i = 1; i <= this.num; i++) {
            int r = resultado.getNum();
            resultado.setNum(r + i);
        }
        System.out.println("FIN Fibonacci");
    }
}
