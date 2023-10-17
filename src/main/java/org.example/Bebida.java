package main.java.org.example;

public abstract class Bebida extends Producto {
    public Bebida(int serie){
        super(serie);
    }
    public abstract String consumir();
}
