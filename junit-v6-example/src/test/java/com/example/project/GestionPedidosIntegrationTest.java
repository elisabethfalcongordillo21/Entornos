package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GestionPedidosIntegrationTest {
 // 1. INTEGRACION - Tienda genera factura con datos correctos
    @Test
    void testTiendaGeneraFacturaConDatosCorrectos() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 3, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoDigital("Ebook", 100.0, 0.0, 21.0, 0.0, "LIC-001"));
        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
        Factura factura = tienda.realizarVenta(c, p);
        assertNotNull(factura);
        assertNotNull(factura.getCodigoFactura());
        assertNotNull(factura.getFechaEmision());
    }

    // 2. INTEGRACION - El totalNeto de la factura es correcto sin descuento
    @Test
    void testTotalFacturaSinDescuento() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoDigital("Ebook", 100.0, 0.0, 21.0, 0.0, "LIC-002"));
        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
        Factura factura = tienda.realizarVenta(c, p);
        assertEquals(121.0, factura.getTotalNeto(), 0.001);
    }

    // 3. INTEGRACION - El descuento VIP se aplica correctamente
    @Test
    void testDescuentoVipSeAplicaEnFactura() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 5, true, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoDigital("Ebook", 100.0, 0.0, 21.0, 0.0, "LIC-003"));
        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
        Factura factura = tienda.realizarVenta(c, p);
        // 121.0 con 15% descuento = 102.85
        assertEquals(102.85, factura.getTotalNeto(), 0.001);
    }

    // 4. INTEGRACION - Pedido con producto fisico en Francia tiene envio de 5
    @Test
    void testPedidoProductoFisicoFrancia() {
        Cliente c = new Cliente("Pierre", "pierre@gmail.com", "Rue de Paris", "123456", 123456, 0, false, "Francia");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        assertEquals(35.0, p.calcularTotal(), 0.001);
    }

    // 5. INTEGRACION - Pedido con producto fisico en España no tiene envio
    @Test
    void testPedidoProductoFisicoEspania() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        assertEquals(30.0, p.calcularTotal(), 0.001);
    }

    // 6. INTEGRACION - Factura con varios productos
    @Test
    void testFacturaConVariosProductos() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(new ProductoFisico("Teclado", 30.0, 1.0));
        p.agregarProducto(new ProductoDigital("Ebook", 40.0, 0.0, 21.0, 0.0, "LIC-004"));
        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
        Factura factura = tienda.realizarVenta(c, p);
        // teclado = 30, ebook con iva 21% = 48.4, total = 78.4
        assertEquals(78.4, factura.getTotalNeto(), 0.001);
    }

    // 7. INTEGRACION - Pedido vacio lanza excepcion al realizar venta
    @Test
    void testVentaConPedidoVacioLanzaExcepcion() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor", 666123456);
        assertThrows(IllegalStateException.class, () -> {
            tienda.realizarVenta(c, p);
        });
    }

    // 8. INTEGRACION - Agregar null no rompe el pedido
    @Test
    void testAgregarNullNoPetaElPedido() {
        Cliente c = new Cliente("Eli", "eli@gmail.com", "Calle Mexico", "46386812T", 66486521, 0, false, "España");
        Pedido p = new Pedido(c);
        p.agregarProducto(null);
        assertEquals(0, p.getProductos().size());
    }
}
