import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {

    @Test
    @DisplayName("Monedas poseen valor esperado")
    void monedasValorEsperado() {
        assertEquals(100, new Moneda100().getValor());
        assertEquals(500, new Moneda500().getValor());
        assertEquals(1000, new Moneda1000().getValor());
        assertEquals(1500, new Moneda1500().getValor());
    }
    @Test
    @DisplayName("Monedas con el mismo valor")
    void monedasDelMismoValor() {
        assertEquals(new Moneda100().getValor(), new Moneda100().getValor());
        assertEquals(new Moneda500().getValor(), new Moneda500().getValor());
        assertEquals(new Moneda1500().getValor(), new Moneda1500().getValor());
        assertEquals(new Moneda1000().getValor(), new Moneda1000().getValor());
    }
    @Test
    @DisplayName("Monedas con distinto valor")
    void monedasDeDistintoValor() {
        assertNotEquals(new Moneda100().getValor(), new Moneda500().getValor());
        assertNotEquals(new Moneda100().getValor(), new Moneda1000().getValor());
        assertNotEquals(new Moneda100().getValor(), new Moneda1500().getValor());

        assertNotEquals(new Moneda500().getValor(), new Moneda100().getValor());
        assertNotEquals(new Moneda500().getValor(), new Moneda1000().getValor());
        assertNotEquals(new Moneda500().getValor(), new Moneda1500().getValor());

        assertNotEquals(new Moneda1000().getValor(), new Moneda500().getValor());
        assertNotEquals(new Moneda1000().getValor(), new Moneda100().getValor());
        assertNotEquals(new Moneda1000().getValor(), new Moneda1500().getValor());

        assertNotEquals(new Moneda1500().getValor(), new Moneda500().getValor());
        assertNotEquals(new Moneda1500().getValor(), new Moneda1000().getValor());
        assertNotEquals(new Moneda1500().getValor(), new Moneda100().getValor());
    }
    @Test
    @DisplayName("Metodo getSerie devuelve Referencia")
    void monedagetSerie() {
        assertNotNull(new Moneda100().getSerie());
        assertNotNull(new Moneda500().getSerie());
        assertNotNull(new Moneda1000().getSerie());
        assertNotNull(new Moneda1500().getSerie());
    }
    @Test
    @DisplayName("Metodo toString funciona de forma correcta")
    void monedatoString() {
        assertEquals("Moneda de 100",new Moneda100().toString());
        assertEquals("Moneda de 500",new Moneda500().toString());
        assertEquals("Moneda de 1000",new Moneda1000().toString());
        assertEquals("Moneda de 1500",new Moneda1500().toString());
    }

}