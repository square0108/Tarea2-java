package org.testing;

import org.example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Expendedor expFive = new Expendedor(5);
    private Expendedor expEmpty = new Expendedor(-5);

    @Test
    @DisplayName("Comprador recibe su vuelto y sabor, al realizar una compra exitosa.")
    void CompradorTieneVueltoYSabor() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Comprador Pepe = new Comprador(expFive, Catalogo.SPRITE.id, new Moneda500());
        assertEquals(300, Pepe.cuantoVuelto());
        assertEquals("sprite", Pepe.getSabor());

        Pepe = new Comprador(expFive, Catalogo.SNICKERS.id, new Moneda1000());
        assertEquals(400, Pepe.cuantoVuelto());
        assertEquals("snickers", Pepe.getSabor());
    }

    @Test
    @DisplayName("Placeholder")
    void CompradorExpVacio() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        AtomicReference<Comprador> Epep = null;
        assertThrows(NoHayProductoException.class, () -> {
            Epep.set(new Comprador(expEmpty, Catalogo.FANTA.id, new Moneda500()));
        });
    }
}