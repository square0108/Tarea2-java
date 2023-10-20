package org.example;

public class Main {
    public static void main(String[] args){
        try {
            // Se crea una maquina expendedora con 4 de cada producto
            Expendedor Maquina = new Expendedor(4);

            // Creación de monedas a utilizar
            Moneda500 CincoCienPeso = new Moneda500();
            Moneda100 CienPeso = new Moneda100();
            Moneda1500 QuinceCienPeso = new Moneda1500();

            // Casos de compra existosos, notar que la compra se hace en el constructor de Comprador
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
            System.out.println(CienPeso.toString());

            // Caso con Excepción, notemos que este es atrapado.
            Pepito = new Comprador(Maquina, Catalogo.SPRITE.id, new Moneda100());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());

            System.out.println("\nNo hubieron excepciones... por ahora.");
        }
        catch (PagoIncorrectoException e) {
            System.err.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.err.println("Error. No hay stock o el producto ingresado no existe.");
        }
        catch (PagoInsuficienteException e) {
            System.err.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }
    }
}
