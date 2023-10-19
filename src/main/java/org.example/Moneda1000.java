package org.example;
/**
 * Representa una moneda con valor 1000. Puede ser utilizada por <code>Comprador</code> para comprar en <code>Expendor</code>.
 * @see Moneda
 * @see Moneda500
 * @see Moneda100
 * @see Moneda1500
 */
public class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }
    public Moneda getSerie() {return this;}
    public int getValor() {return 1000;}
    public String toString() {return "Moneda de 1000";};
}
