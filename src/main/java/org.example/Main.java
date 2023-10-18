package org.example;

public class Main {
    public static void main(String[] args){
        try {
            Expendedor Maquina = new Expendedor(4);
            Moneda500 CincoCienPeso = new Moneda500();
            Moneda100 CienPeso = new Moneda100();
            Moneda1500 QuinceCienPeso = new Moneda1500();
            Comprador Pepito = new Comprador(Maquina, Catalogo.COCA.id, CincoCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.COCA.id, CincoCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.COCA.id, QuinceCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.COCA.id, new Moneda500());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.SUPER8.id, new Moneda1000());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.SPRITE.id, new Moneda100());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());

            System.out.println("\nNo hubieron excepciones... por ahora.");
        }
        catch (PagoIncorrectoException e) {
            System.out.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.out.println("Error. No hay stock o el producto ingresado no existe. Retire su vuelto desde la maquina.");
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }
    }
}
