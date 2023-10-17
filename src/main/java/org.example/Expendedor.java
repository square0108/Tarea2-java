package main.java.org.example;

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
        for (int i = 1; i <= stock; i++) {
            coca.add(new CocaCola(1000+i));
            sprite.add(new Sprite(2000+i));
            fanta.add(new Fanta(3000+i));
            snickers.add(new Snickers(4000+i));
            super8.add(new Super8(5000+i));
        }
    }
}
