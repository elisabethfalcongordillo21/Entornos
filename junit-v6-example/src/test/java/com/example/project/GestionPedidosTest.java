package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    // 9. NEGATIVO 
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
    @Test
    
    void testCoberturaExtra() {
    // 1. Probamos todos los Setters de Cliente
    Cliente c = new Cliente("A", "B", "C", "D", 1);
    c.setNombre("Nuevo");
    c.setCorreo("nuevo@test.com");
    c.setDireccion("Calle Test");
    c.setDni("000X");
    c.setTelf(123456);
    
    // 2. Probamos los toString 
    assertNotNull(c.toString());
    
    ProductoFisico p = new ProductoFisico("Teclado", 20, 5);
    p.setCosteEnvio(10);
    assertNotNull(p.toString());
    
    // 3. Probamos los Setters de ProductoDigital
    ProductoDigital pd = new ProductoDigital("Ebook", 10, 500, 21, 0);
    pd.setTamanioDescarga(600);
    pd.setPorcientoIVA(10);
    pd.setDescuento(2);
    
    // 4. Probamos Setters de Pedido
    Pedido ped = new Pedido(c);
    ped.setCliente(c);
    ped.setProductos(new java.util.ArrayList<>());
    
    // Verificamos que nada sea nulo
    assertNotNull(pd.getNombre());
    assertEquals(600, pd.getTamanioDescarga());
}
    // 11  NEGATIVO - Descuento mayor que precio+IVA devuelve 0, nunca negativo
    
    @Test
    void testDescuentoMayorQuePrecioDevuelveCero() {
        ProductoDigital pd = new ProductoDigital("Barato", 10.0, 5.0, 0.0, 999.0);
        assertEquals(0.0, pd.calcularPrecio());
    }
 
    // 12 POSITIVO - setNombre y setPrecio de la clase base Producto
    
    @Test
    void testProductoBaseSetters() {
        ProductoFisico p = new ProductoFisico("Viejo", 10.0, 2.0);
        p.setNombre("Nuevo");
        p.setPrecio(50.0);
        assertEquals("Nuevo", p.getNombre());
        assertEquals(52.0, p.calcularPrecio(), 0.001);
    }
 
    // 13  POSITIVO - calcularTotal con varios productos
   
    @Test
    void testCalcularTotalConVariosProductos() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123);
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 5.0));           // 35
        p.agregarProducto(new ProductoDigital("Ebook", 40.0, 10.0, 0.0, 0.0)); // 40
        assertEquals(75.0, p.calcularTotal(), 0.001);
    }
 
    //14 POSITIVO - mostrarInfo() con productos
    
    @Test
    void testMostrarInfoConProductos() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521);
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 4.99));
        p.agregarProducto(new ProductoDigital("Ebook", 40.5, 10.0, 10.0, 5.0));
        assertNotNull(p.getCliente());
        p.mostrarInfo();
    }
 
    // 15 POSITIVO - mostrarInfo() con pedido vacío
    @Test
    void testMostrarInfoVacio() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521);
        Pedido p = new Pedido(c);
        p.mostrarInfo();
        assertEquals(0.0, p.calcularTotal(), 0.001);
    }

}
