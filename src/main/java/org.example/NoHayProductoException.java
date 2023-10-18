package org.example;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(Expendedor expendedorFail, Moneda monedaFail) {
        expendedorFail.getMonVu().add(monedaFail);
    }
}
