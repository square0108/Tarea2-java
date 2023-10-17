package org.example;

public abstract class Dulce extends Producto {
    private int numSerie;
    public Dulce(int serie) {
        this.numSerie = serie;
    }
    public abstract String comer();
    public int getNumSerie() {return numSerie;}
}
