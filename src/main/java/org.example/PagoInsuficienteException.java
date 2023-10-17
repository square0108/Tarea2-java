package main.java.org.example;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(Expendedor expendedorFail, Moneda monedaFail) {
        /*Creo que no tiene sentido que desde acá se quite la moneda del deposito, esto
        lo deberia hacer el comprador*/
        expendedorFail.getMonVu().add(monedaFail);
        System.err.println("PAGO INSUFICIENTE");
    }
}
