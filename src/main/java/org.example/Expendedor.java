package org.example;
import java.util.ArrayList;

public class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;

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

    public Producto comprarProducto(int ID, Moneda moneda) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        /* Antes de ejecutar cualquier paso, se revisa que la moneda sea valida (no null). */

        if (moneda == null) throw new PagoIncorrectoException();

        /* Main.Catalogo.values() es un arreglo que contiene todas las constantes del enum Catalogo.
        *  Compra es el producto que ha sido seleccionado por el cliente, si es que se ha ingresado un ID valido. */

        Main.Catalogo Compra = null;

        /* Se busca si el ID ingresado es valido. */
        /* TODO: Implementar Throw PagoIncorrectoException cuando el ID ingresado es invalido!!! */
        /* TODO: Implementar Throw NoHayProductoException */

        for (int i = 0; i < Main.Catalogo.values().length; i++) {
            if (Main.Catalogo.values()[i].id == ID) { /* Chequea: ID es valido? */
                if (moneda.getValor() >= Main.Catalogo.values()[i].precio)
                    Compra = Main.Catalogo.values()[i]; /* Chequea: El pago es suficiente? */
                else {
                    throw new PagoInsuficienteException(this, moneda);
                }
            }
        }
        if (Compra == null) throw new NoHayProductoException(this, moneda);

        // GLLRM: Generar monedas segun monto de vuelto y añadirlas al deposito de vuelto
        int montovuelto = moneda.getValor() - Compra.precio;
        while( montovuelto > 0 ){
            montovuelto -= 100;
            Moneda100 moneda100 = new Moneda100();
            monVu.add(moneda100);
        }

        switch (Compra) { /* TODO: Implementar Throw PagoInsuficienteException */
            case COCA:
                return coca.get();
            case SPRITE:
                return sprite.get();
            case FANTA:
                return fanta.get();
            case SNICKERS:
                return snickers.get();
            case SUPER8:
                return super8.get();
            default:
                return null;
        }
    }

    /**
     * @return Moneda recogida por usuario desde deposito de vuelto
     */
    public Moneda getVuelto(){return monVu.get();}

    //Getters de Depositos
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
