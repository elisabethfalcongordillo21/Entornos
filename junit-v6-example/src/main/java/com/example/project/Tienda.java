package com.example.project;

import java.time.LocalDate;

/**
 * Clase Tienda, se encarga de gestionar las ventas
 */
public class Tienda {

    private String nombre;
    private String direccion;
    private int telf;

    private static int contadorFacturas = 1; // MEJORA: cambio para el test final

    // MEJORA: cambio para el test final
    public Tienda() {}

    /**
     * @param nombre nombre de la tienda
     * @param direccion direccion de la tienda
     * @param telf telefono de la tienda
     */
    public Tienda(String nombre, String direccion, int telf) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telf = telf;
    }

    /** @return nombre de la tienda */
    public String getNombre() { 
        return nombre; 
    }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /** @return direccion de la tienda */
    public String getDireccion() { 
        return direccion; 
    }

    /** @param direccion nueva direccion */
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }

    /** @return telefono de la tienda */
    public int getTelf() { 
        return telf; 
    }
    
    /** @param telf nuevo telefono */
    public void setTelf(int telf) { 
        this.telf = telf; 
    }

    /**
     * Hace la venta, aplica el descuento del cliente y devuelve la factura
     * @param cliente cliente que compra
     * @param pedido pedido con los productos
     * @return factura generada
     */
    public Factura realizarVenta(Cliente cliente, Pedido pedido) {

        if (pedido.getProductos().isEmpty()) {
            throw new IllegalArgumentException(Pedido.PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE);
        }

        String pais = cliente.getPais();
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("El pais del cliente no puede ser nulo o estar vacio");
        }

        if (cliente.getId() != pedido.getCliente().getId()) {
            throw new IllegalArgumentException("El cliente no coincide con el cliente del pedido");
        }

        double totalNeto = 0.0;
        for (Producto p : pedido.getProductos()) {
            int cantidad = pedido.getCantidades().getOrDefault(p.getId(), 1);
            totalNeto += p.getPrecioBase() * cantidad;
        }

        double descuento = totalNeto * cliente.getDescuento();
        double totalIva = pedido.calcularIva("GENERAL");
        double totalEnvio = pedido.calcularEnvio(pais);
        double totalFinal = totalNeto + totalIva + totalEnvio - descuento;

        String codigoFactura = "FACT-" + LocalDate.now() + "-" + contadorFacturas;
        contadorFacturas++;

        return new Factura(codigoFactura, LocalDate.now(), totalNeto, totalIva, totalEnvio, totalFinal, descuento);
    }
}