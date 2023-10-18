import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    @BeforeEach
    void beforeEach(){
    }
    @Test
    @DisplayName("Creación de Expendedores")
    void creacionExpendedores(){
        assertNotNull(new Expendedor(2));
        assertNotNull(new Expendedor(0));
        assertNotNull(new Expendedor(-10));
    }

    @Test
    @DisplayName("Compras Exitosas")
    void comprasExitosas() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum catalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(10);
        assertNotNull(expendedor.comprarProducto(0,new Moneda100()));
        assertNotNull(expendedor.comprarProducto(1,new Moneda500()));
        assertNotNull(expendedor.comprarProducto(2,new Moneda1000()));
        assertNotNull(expendedor.comprarProducto(3,new Moneda1500()));
        assertNotNull(expendedor.comprarProducto(4,new Moneda1500()));
    }

    @Test
    @DisplayName("Caso No Hay Producto")
    void noHayProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum catalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(1);
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(1,new Moneda1500());
            expendedor.comprarProducto(1,new Moneda1500());
        });
    }

    @Test
    @DisplayName("Caso Pago Insuficiente")
    void pagoInsuficiente() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum catalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(10);
    }

    @Test
    @DisplayName("Caso Pago Incorrecto")
    void pagoIncorrecto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum catalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(10);
    }
}