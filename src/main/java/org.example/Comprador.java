package org.example;


public class Comprador {
    private String sabor;
    private int vuelto;

    /**
     * Metodo constructor de Comprador, en este se intenta comprar con una moneda un producto en un expendedor.
     * @param expendedor Expendedor donde se comprara el producto.
     * @param producto ID del producto a comprar.
     * @param moneda Moneda con la que se comprara el producto.
     * @throws NoHayProductoException /TODO: Rellenar esto
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    public Comprador(Expendedor expendedor, int producto, Moneda moneda) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.vuelto = 0;
        /*No estoy completamente seguro de que los errores tengas que manejarse de esta forma*/

        try{
            Producto miCompra = expendedor.comprarProducto(producto, moneda);
            sabor = miCompra.consumir(); // NO estoy seguro de que así se obtenga el "sabor"

            // Quitar el vuelto del deposito monVu, hasta que quede vacio
            Moneda monedavuelto = expendedor.getVuelto();
            while (monedavuelto != null) {
                this.vuelto += monedavuelto.getValor();
                monedavuelto = expendedor.getVuelto();
            }

        } catch(PagoIncorrectoException e){
            // TODO: Aqui supongo que falta poner cosas
            throw e;
        } catch(NoHayProductoException | PagoInsuficienteException e) {
            /*Sabemos que en caso de que no haya producto o el pago sea insuficiente, entonces solo habra una
            * moneda en el deposito monVu, por eso cliente recibe la moneda y directamente su vuelto es la
            * totalidad de lo que pago*/
            this.vuelto = expendedor.getVuelto().getValor();
            System.out.println("La Moneda de " + this.toString() + " ha sido rechazada: " + cuantoVuelto());
            throw e;
        }

    }

    /**
     * @return Cantidad de vuelto que posee el comprador (int).
     */
    public int cuantoVuelto(){return this.vuelto;}

    /**
     * @return "Sonido" que hace el producto al ser consumido (String).
     */
    public String getSabor(){return this.sabor;}
}
