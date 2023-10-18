package org.example;

public class NoHayProductoException extends Exception {
    /**
     * Ocurre en dos casos:
     * 1. El producto que se desea comprar no posee mas stock en el deposito.
     * 2. El ID de producto ingresado no corresponde con ningun ID de Main.Catalogo
     * En ambos casos se ingresa la moneda de Comprador al deposito de vueltos del expendedor.
     * @param expendedorFail Expendedor donde la compra ha fallado
     * @param monedaFail Moneda que fue rechazada
     */
    public NoHayProductoException(Expendedor expendedorFail, Moneda monedaFail) {
        expendedorFail.getMonVu().add(monedaFail);
    }
}
