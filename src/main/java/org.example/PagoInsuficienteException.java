package org.example;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(Expendedor expendedorFail, Moneda monedaFail) {
        expendedorFail.getMonVu().add(monedaFail);
    }
}
