package org.example;
/**
 * Representa una moneda con valor 100. Puede ser utilizada por <code>Comprador</code> para comprar en <code>Expendor</code>.
 * @see Moneda
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda1500
 */
public class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public Moneda getSerie() {return this;}
    public int getValor() {return 100;}
    public String toString() {return "Moneda de 100";};
}
