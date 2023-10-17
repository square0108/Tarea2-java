package main.java.org.example;

public class Comprador {
    private String sabor;
    private int vuelto;

    public Comprador(Expendedor expendedor, int producto, Moneda moneda) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto miCompra = expendedor.comprarProducto(producto, moneda);
        this.sabor = miCompra.consumir();
        // SOLO PARA TESTING: BORRAR MAS TARDE:
        System.out.println(this.toString() + " ha consumido: " + getSabor() + ", Numero de serie: " + miCompra.getNumSerie());
    }

    public String getSabor() {
        return sabor;
    }

    public int getVuelto() {
        return vuelto;
    }
}
