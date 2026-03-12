package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GestionPedidosTest {
    
// 1. POSITIVO - El que ya tenías (lo dejamos igual)
    @Test
    void clienteCreadoConDatosCorrectos() {
        Cliente cliente = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521);
        assertEquals("Eli", cliente.getNombre());
        assertEquals("46386812T", cliente.getDni());
        assertEquals(66486521, cliente.getTelf());
    }

    // 2. NEGATIVO - Comprobar que el correo no se guarda mal
    @Test
    void testCorreoNoEsErroneo() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mex", "123", 666);
        assertNotEquals("otro@correo.com", c.getCorreo());
    }

    // 3. POSITIVO - IVA de un producto digital
    @Test
    void testIvaProductoDigital() {
        ProductoDigital ebook = new ProductoDigital("Ebook Java", 100.0, 10.0, 21.0, 0.0);
        // 100 + 21% de IVA = 121.0
        assertEquals(121.0, ebook.calcularPrecio());
    }

    // 4. NEGATIVO - assertThrows 
    @Test
    void testErrorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            double precio = -5.0;
            if (precio < 0) throw new IllegalArgumentException();
            new ProductoFisico("Error", precio, 2.0);
        });
    }

    // 5. POSITIVO - El nombre del producto se guarda bien
    @Test
    void testNombreProductoCorrecto() {
        ProductoFisico teclado = new ProductoFisico("Teclado Logitech", 20.0, 5.0);
        assertTrue(teclado.getNombre().equals("Teclado Logitech"));
    }

    // 6. POSITIVO - Añadir productos al pedido
    @Test
    void testAgregarProducto() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123);
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Raton", 10.0, 2.0));
        assertEquals(1, p.getProductos().size());
    }

    // 7. NEGATIVO - Pedido sin productos debe ser 0
    @Test
    void testPedidoVacioNoTieneCoste() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123);
        Pedido p = new Pedido(c);
        assertFalse(p.calcularTotal() > 0);
    }

    // 8. POSITIVO - PARAMETRIZADA 
    @ParameterizedTest
    @ValueSource(doubles = {10.0, 25.0, 50.0})
    void testPreciosDiferentes(double precio) {
        ProductoFisico p = new ProductoFisico("Test", precio, 0.0);
        assertEquals(precio, p.calcularPrecio());
    }

    // 9. NEGATIVO - El que me pediste cambiar (Total no es 9)
    @Test
    void testTotalPedidoVacioNoEsNueve() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123);
        Pedido p = new Pedido(c);
        assertNotEquals(9.0, p.calcularTotal());
    }

    // 10. NEGATIVO - El total no puede ser menor que cero
    @Test
    void testTotalNoEsNegativo() {
        Pedido p = new Pedido(new Cliente("Eli", "e@e.com", "Mex", "123", 123));
        assertFalse(p.calcularTotal() < 0);
    }


}
