package org.example;
import java.util.ArrayList;

public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;

    /**
     * Metodo constructor de Expendedor. Genera un stock dentro de los depositos de Productos de Expendedor.
     * @param stock Cantidad de productos en cada deposito de Expendedor (el mismo número para todos).
     */
    public Expendedor(int stock) {
        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.fanta = new Deposito<>();
        this.snickers = new Deposito<>();
        this.super8 = new Deposito<>();
        this.monVu = new Deposito<>();

        /* Se rellenan todos los depositos con la misma cantidad de stock. */
        /*GLLRM: En caso de que el stock sea menor o igual a cero, simplemente no se añade nada a los
        * depositos ¿verdad?*/
        /* SQUARE: Si, en realidad el if (stock>0) no seria necesario porque en caso contrario aunque no estuviese el If, no se ejecutaria el for. */
        if (stock>0){
            for (int i = 1; i <= stock; i++) {
                coca.add(new CocaCola(1000 + i));
                sprite.add(new Sprite(2000 + i));
                fanta.add(new Fanta(3000 + i));
                snickers.add(new Snickers(4000 + i));
                super8.add(new Super8(5000 + i));
            }
        }
    }

    /**
     * Emula la acción de comprar en el Expendedor. Utilizado unicamente por el constructor de Comprador.
     * @param ID int, Identificador de Producto. Ver Catalogo para determinar los posibles IDs.
     * @param moneda Moneda usada por Comprador.
     * @return Si el producto es comprado de forma exitosa, la referencia del producto. En otro caso null.
     * @throws NoHayProductoException Ocurre en caso de stock agotado o de que se ingrese un ID de producto invalido.
     * @throws PagoIncorrectoException Ocurre en caso de que se intente realizar un pago con moneda de referencia null.
     * @throws PagoInsuficienteException Ocurre en caso de que el valor de la moneda ingresada sea menor al precio del producto.
     */
    public Producto comprarProducto(int ID, Moneda moneda) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        /* Antes de ejecutar cualquier paso, se revisa que la moneda sea valida (no null). */
        if (moneda == null) throw new PagoIncorrectoException();

        /* Se crea la siguiente variable para verificar dos cosas: Que el ID ingresado sea valido, y que el pago ingresado sea suficiente. */
        Catalogo Compra = null;

        /* Se recorre el array Main.Catalogo.values(), que contiene todas las constantes de Catalogo, las cuales almacenan los IDs y los precios. */
        for (int i = 0; i < Catalogo.values().length; i++) {
            if (Catalogo.values()[i].id == ID) { /* Chequea: ID es valido? */
                if (moneda.getValor() >= Catalogo.values()[i].precio) { /* Chequea: El pago es suficiente? */
                    Compra = Catalogo.values()[i];
            }
                else {
                    throw new PagoInsuficienteException(this, moneda);
                }
            }
        }
        /* Si Compra permanece inicializada como NULL, entonces el ID ingresado no es valido. */
        if (Compra == null) throw new NoHayProductoException(this, moneda);

        // GLLRM: Generar monedas segun monto de vuelto y añadirlas al deposito de vuelto
        int montovuelto = moneda.getValor() - Compra.precio;
        while( montovuelto > 0 ){
            montovuelto -= 100;
            Moneda100 moneda100 = new Moneda100();
            monVu.add(moneda100);
        }

        /* Primero se crea ProductoComprado.
        * Si al hacer get() desde un deposito se le asigna null a ProductoComprado, es porque este deposito ha quedado vacio. */
        Producto ProductoComprado;
        switch (Compra) {
            case COCA:
                ProductoComprado = coca.get();
                if (ProductoComprado == null) throw new NoHayProductoException(this, moneda);
                else return ProductoComprado;
            case SPRITE:
                ProductoComprado = sprite.get();
                if (ProductoComprado == null) throw new NoHayProductoException(this, moneda);
                else return ProductoComprado;
            case FANTA:
                ProductoComprado = fanta.get();
                if (ProductoComprado == null) throw new NoHayProductoException(this, moneda);
                else return ProductoComprado;
            case SNICKERS:
                ProductoComprado = snickers.get();
                if (ProductoComprado == null) throw new NoHayProductoException(this, moneda);
                else return ProductoComprado;
            case SUPER8:
                ProductoComprado = super8.get();
                if (ProductoComprado == null) throw new NoHayProductoException(this, moneda);
                else return ProductoComprado;
            default:
                return null;
        }
    }

    /**
     * @return Moneda recogida por usuario desde deposito de vuelto
     */
    public Moneda getVuelto(){return monVu.get();}

    /*Getters de Depositos*/
    public Deposito<Producto> getCoca() {
        return coca;
    }

    public Deposito<Producto> getSprite() {
        return sprite;
    }

    public Deposito<Producto> getFanta() {
        return fanta;
    }

    public Deposito<Producto> getSnickers() {
        return snickers;
    }

    public Deposito<Producto> getSuper8() {
        return super8;
    }

    public Deposito<Moneda> getMonVu() {
        return monVu;
    }
}
