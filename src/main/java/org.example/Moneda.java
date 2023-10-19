package org.example;

/**
 * Clase abstracta Moneda.
 * @see Moneda100
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda1500
 */
public abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){}

    /**
     * @return int, Valor de la moneda.
     */
    public abstract int getValor();

    /**
     * @return Moneda, referencia a la moneda.
     */
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
