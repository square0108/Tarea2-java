package org.example;

public enum Catalogo {
    COCA(0, 100),
    SPRITE(1, 200),
    FANTA(2, 300),
    SNICKERS(4, 600),
    SUPER8(5, 700);
    public final int id;
    public final int precio;

    Catalogo(int Identidad, int Precio) {
        this.id = Identidad;
        this.precio = Precio;
    }
}
