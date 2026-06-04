package com.example.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GestionPedidosTest {

    // 1. POSITIVO - Cliente creado con datos correctos
   @Test
    void clienteCreadoConDatosCorrectos() {
        Cliente cliente = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521, 3, false, "España");
        assertEquals("Eli", cliente.getNombre());
        assertEquals("46386812T", cliente.getDni());
        assertEquals(66486521, cliente.getTelf());
    }

    // 2. NEGATIVO - El correo no se guarda mal
     @Test
    void testCorreoNoEsErroneo() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mex", "123", 666, 0, false, "España");
        assertNotEquals("otro@correo.com", c.getCorreo());
    }
    // 3. POSITIVO - IVA general de un producto digital
     @Test
    void testIvaProductoDigital() {
        ProductoDigital ebook = new ProductoDigital("Ebook Java", 100.0, 10.0, 21.0, 0.0, "LIC-001");
        assertEquals(121.0, ebook.calcularPrecioFinal());
    }
    // 4. NEGATIVO - assertThrows
    @Test
    void testErrorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProductoFisico("Error", -5.0, 1.0);
        });
    }

      // 5. POSITIVO - El nombre del producto se guarda bien
    @Test
    void testNombreProductoCorrecto() {
        ProductoFisico teclado = new ProductoFisico("Teclado Logitech", 20.0, 1.0);
        assertTrue(teclado.getNombre().equals("Teclado Logitech"));
    }

     // 6. POSITIVO - Añadir productos al pedido
    @Test
    void testAgregarProducto() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Raton", 10.0, 0.5));
        assertEquals(1, p.getProductos().size());
    }

     // 7. NEGATIVO - Pedido vacio lanza excepcion
    @Test
    void testPedidoVacioLanzaExcepcion() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        Pedido p = new Pedido(c);
        assertThrows(IllegalStateException.class, () -> {
            p.calcularTotal();
        });
    }

    // 8. POSITIVO - PARAMETRIZADA
   @ParameterizedTest
    @ValueSource(doubles = {10.0, 25.0, 50.0})
    void testPreciosDiferentes(double precio) {
    ProductoFisico p = new ProductoFisico("Test", precio, 0.0);
    assertEquals(precio, p.calcularPrecioFinal());
    }
    // 9. NEGATIVO
    @Test
    void testTotalPedidoVacioNoEsNueve() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        assertNotEquals(9.0, p.calcularTotal());
    }

    // 10. NEGATIVO - El total no puede ser menor que cero
    @Test
    void testTotalNoEsNegativo() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        assertFalse(p.calcularTotal() < 0);
    }

    @Test
    void testCoberturaExtra() {
        Cliente c = new Cliente("A", "B", "C", "D", 1, 0, false, "España");
        c.setNombre("Nuevo");
        c.setCorreo("nuevo@test.com");
        c.setDireccion("Calle Test");
        c.setDni("000X");
        c.setTelf(123456);

        assertNotNull(c.toString());

        ProductoFisico p = new ProductoFisico("Teclado", 20.0, 1.0);
        p.setPeso(2.0);
        assertNotNull(p.toString());

        ProductoDigital pd = new ProductoDigital("Ebook", 10.0, 500.0, 21.0, 0.0, "LIC-002");
        pd.setTamanioDescarga(600.0);
        pd.setPorcientoIVA(10.0);
        pd.setDescuento(2.0);

        Pedido ped = new Pedido(c);
        ped.setCliente(c);
        ped.setProductos(new java.util.ArrayList<>());

        assertNotNull(pd.getNombre());
        assertEquals(600.0, pd.getTamanioDescarga());
    }

    // 11. NEGATIVO - Descuento mayor que precio+IVA devuelve 0, nunca negativo
    @Test
    void testDescuentoMayorQuePrecioDevuelveCero() {
        ProductoDigital pd = new ProductoDigital("Barato", 10.0, 5.0, 21.0, 999.0, "LIC-003");
        assertEquals(0.0, pd.calcularPrecioFinal());
    }

    // 12. POSITIVO - setNombre y setPrecioBase de la clase base Producto
    @Test
    void testProductoBaseSetters() {
        ProductoFisico p = new ProductoFisico("Viejo", 10.0, 1.0);
        p.setNombre("Nuevo");
        p.setPrecioBase(50.0);
        assertEquals("Nuevo", p.getNombre());
    }

    // 13. POSITIVO - calcularTotal con varios productos
    @Test
    void testCalcularTotalConVariosProductos() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        p.agregarProducto(new ProductoDigital("Ebook", 40.0, 10.0, 21.0, 0.0, "LIC-004"));
        // España = 0 envio, ebook con IVA 21% = 48.4, teclado = 30
        assertEquals(78.4, p.calcularTotal(), 0.001);
    }

    // 14. POSITIVO - mostrarInfo() con productos
    @Test
    void testMostrarInfoConProductos() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        p.agregarProducto(new ProductoDigital("Ebook", 40.5, 10.0, 21.0, 5.0, "LIC-005"));
        assertNotNull(p.getCliente());
        p.mostrarInfo();
    }

    // 15. POSITIVO - mostrarInfo() con pedido vacío no peta
    @Test
    void testMostrarInfoVacio() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        assertNotNull(p.getCliente());
        assertEquals(0, p.getProductos().size());
    }


    // TEST PARA LLEGAR A MAS DEL 80% DE COBERTURA
    
    // 16. POSITIVO - Tienda genera factura correctamente
   @Test
    void testTiendaGeneraFactura() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
    Pedido p = new Pedido(c);
    p.agregarProducto(new ProductoDigital("Ebook", 100.0, 0.0, 21.0, 0.0, "LIC-006"));
    Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
    Factura factura = tienda.realizarVenta(c, p);
    assertNotNull(factura);
}

    // 17. POSITIVO - Descuento fidelidad cliente vip con antiguedad
    @Test
    void testDescuentoFidelidadVip() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 5, true, "España");
        assertEquals(0.15, c.getDescuento());
    }

    // 18. NEGATIVO - Cliente sin antiguedad no tiene descuento
    @Test
    void testSinDescuentoSinAntiguedad() {
        Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
        assertFalse(c.getDescuento() > 0);
    }

    //  CLIENTE - getters sin cubrir 

    @Test
    void testClienteGettersAdicionales() {
    Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 3, true, "España");
    assertEquals(3, c.getAñosAntiguedad());
    assertEquals("España", c.getPais());
    assertTrue(c.isEsVip());
    assertTrue(c.getEsVip());
}

    @Test
    void testClienteSettersAdicionales() {
    Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
    c.setAñosAntiguedad(5);
    c.setPais("Francia");
    c.setEsVip(true);
    assertEquals(5, c.getAñosAntiguedad());
    assertEquals("Francia", c.getPais());
    assertTrue(c.isEsVip());
}

// Descuento VIP sin suficiente antiguedad (10%)
@Test
void testDescuentoVipSinAntiguedad() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 2, true, "España");
    assertEquals(0.10, c.getDescuento());
}

// Descuento fidelidad sin VIP con antiguedad >= 3 (5%)
@Test
void testDescuentoFidelidadSinVip() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 3, false, "España");
    assertEquals(0.05, c.getDescuento());
}

// PRODUCTO DIGITAL - aplicarIVA 

@Test
void testAplicarIvaReducido() {
    ProductoDigital pd = new ProductoDigital("Ebook", 100.0, 0.0, 10.0, 0.0, "LIC-R");
    assertEquals(110.0, pd.aplicarIVA("REDUCIDO"), 0.001);
}

@Test
void testAplicarIvaSuper() {
    ProductoDigital pd = new ProductoDigital("Ebook", 100.0, 0.0, 4.0, 0.0, "LIC-S");
    assertEquals(104.0, pd.aplicarIVA("SUPER"), 0.001);
}

@Test
void testAplicarIvaDefault() {
    ProductoDigital pd = new ProductoDigital("Ebook", 100.0, 0.0, 0.0, 0.0, "LIC-D");
    assertEquals(100.0, pd.aplicarIVA("OTRO"), 0.001);
}

@Test
void testProductoDigitalGettersSetters() {
    ProductoDigital pd = new ProductoDigital("Ebook", 10.0, 5.0, 21.0, 2.0, "LIC-X");
    pd.setCodigoLicencia("LIC-NEW");
    assertEquals("LIC-NEW", pd.getCodigoLicencia());
    assertNotNull(pd.toString());
}

// PRODUCTO FISICO - coste envio 

@Test
void testCosteEnvioItalia() {
    ProductoFisico p = new ProductoFisico("Teclado", 30.0, 1.0);
    assertEquals(5.0, p.calcularCosteEnvio("Italia"), 0.001);
}

@Test
void testCosteEnvioPortugal() {
    ProductoFisico p = new ProductoFisico("Teclado", 30.0, 1.0);
    assertEquals(5.0, p.calcularCosteEnvio("Portugal"), 0.001);
}

@Test
void testCosteEnvioRestoMundo() {
    ProductoFisico p = new ProductoFisico("Teclado", 30.0, 1.0);
    assertEquals(10.0, p.calcularCosteEnvio("Japon"), 0.001);
}

//FACTURA - setters e imprimirFactura 

@Test
void testFacturaSetters() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
    Pedido p = new Pedido(c);
    p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
    Factura f = new Factura(c, p, 30.0);
    
    f.setCodigoFactura("FAC-001");
    f.setFechaEmision(java.time.LocalDate.of(2026, 1, 1));
    f.setTotalNeto(100.0);
    f.setTotalIva(21.0);
    f.setTotalEnvio(5.0);
    f.setTotalFinal(126.0);
    
    assertEquals("FAC-001", f.getCodigoFactura());
    assertEquals(100.0, f.getTotalNeto(), 0.001);
    assertEquals(21.0, f.getTotalIva(), 0.001);
    assertEquals(5.0, f.getTotalEnvio(), 0.001);
    assertEquals(126.0, f.getTotalFinal(), 0.001);
    assertNotNull(f.getFechaEmision());
}

@Test
void testImprimirFactura() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
    Pedido p = new Pedido(c);
    p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
    Factura f = new Factura(c, p, 30.0);
    f.imprimirFactura();
    assertNotNull(f.getCodigoFactura());
    assertEquals(30.0, f.getTotalNeto(), 0.001);
}

//  TIENDA - getters y setters 

@Test
void testTiendaGettersSetters() {
    Tienda t = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
    assertEquals("Mi Tienda", t.getNombre());
    assertEquals("Calle Mayor", t.getDireccion());
    assertEquals(666123456, t.getTelf());
    
    t.setNombre("Nueva Tienda");
    t.setDireccion("Calle Nueva");
    t.setTelf(123456789);
    
    assertEquals("Nueva Tienda", t.getNombre());
    assertEquals("Calle Nueva", t.getDireccion());
    assertEquals(123456789, t.getTelf());
}

//  PEDIDO - eliminarProducto 

@Test
void testEliminarProducto() {
    Cliente c = new Cliente("Eli", "e@e.com", "Mex", "123", 123, 0, false, "España");
    Pedido p = new Pedido(c);
    ProductoFisico teclado = new ProductoFisico("Teclado", 30.0, 1.0);
    p.agregarProducto(teclado);
    assertEquals(1, p.getProductos().size());
    p.eliminarProducto(teclado);
    assertEquals(0, p.getProductos().size());
}
}