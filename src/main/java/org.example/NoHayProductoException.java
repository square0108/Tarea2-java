package main.java.org.example;

public class NoHayProductoException extends Exception {
    private final Expendedor expendedor; // Solo para testear.
    public NoHayProductoException(Expendedor expendedorFail, Moneda monedaFail) {
        this.expendedor = expendedorFail;
        expendedorFail.getMonVu().add(monedaFail);
        System.out.println("Vuelto de excepcion: " + getVueltoExpendedor().toString());
    }
    public Moneda getVueltoExpendedor() {return expendedor.getMonVu().get();}
}
