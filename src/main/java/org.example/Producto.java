package main.java.org.example;

public abstract class Producto {
    private final int numSerie;
    public Producto(int serie) {
        this.numSerie = serie;
    }
    public abstract String consumir();
    public int getNumSerie() {return this.numSerie;}
}
