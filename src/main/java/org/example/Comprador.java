package org.example;

public class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida bebida;
        this.sonido = null;
        this.vuelto = 0;
        bebida = exp.comprarBebida(m,cualBebida);

        if(bebida != null){
            this.sonido = bebida.beber();
        }
        Moneda monedavuelto = exp.getVuelto();
        while(monedavuelto != null){
            this.vuelto = this.vuelto + monedavuelto.getValor();
            monedavuelto = exp.getVuelto();
        }
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sonido;
    }
}