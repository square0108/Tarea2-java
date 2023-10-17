package main.java.org.example;

public class PagoInsuficienteException extends Exception {
    private final Expendedor expendedor; // Solo para testear.
    public PagoInsuficienteException(Expendedor expendedorFail, Moneda monedaFail) {
        this.expendedor = expendedorFail;
        expendedorFail.getMonVu().add(monedaFail);
        System.out.println("Excepcion ocurrida. Hay vuelto en el expendedor: " + getVueltoExpendedor().toString());
    }
    public Moneda getVueltoExpendedor() {return expendedor.getMonVu().get();}
}
