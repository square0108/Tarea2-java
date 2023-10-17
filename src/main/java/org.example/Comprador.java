package main.java.org.example;

public class Comprador {
    private String sabor;
    private int vuelto;

    public Comprador(Expendedor expendedor, int producto, Moneda moneda) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto miCompra = expendedor.comprarProducto(producto, moneda);
    }
}
