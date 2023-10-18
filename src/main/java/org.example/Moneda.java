package org.example;

public abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){}
    public abstract int getValor();
    public abstract Moneda getSerie();
    public abstract String toString();
    public int compareTo(Moneda o){
        if (this.getValor() > o.getValor()) {
            return 1;
        }
        else if (this.getValor() < o.getValor()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
