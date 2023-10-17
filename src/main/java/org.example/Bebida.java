package org.example;

public abstract class Bebida extends Producto {
    private int numSerie;
    public Bebida(int serie){
        this.numSerie = serie;
    }
    public abstract String beber();
    public int getNumSerie() {return numSerie;}
}
