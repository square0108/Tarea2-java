package org.example;

public class Main {
    enum Catalogo {
        COCA(0,100),
        SPRITE(1,200),
        FANTA(2,300),
        SNICKERS(3,600),
        SUPER8(4,700);
        public final int id;
        public final int precio;

        Catalogo(int Identidad, int Precio) {
            this.id = Identidad;
            this.precio = Precio;
        }
    }

    public static void main(String[] args){
        try {
            Expendedor Maquina = new Expendedor(3);
            Moneda500 CincoCienPeso = new Moneda500();
            Comprador Pepito = new Comprador(Maquina, 0, CincoCienPeso);

            System.out.println("\nNo hubieron excepciones... por ahora.");
        }
        catch (Exception NoHayProductoException) {
            System.out.println("Error. No hay stock o el producto ingresado no existe. Retire su vuelto desde la maquina.");
        }
    }
}
