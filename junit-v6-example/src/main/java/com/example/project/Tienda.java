package com.example.project;

/**
 * Clase Tienda, se encarga de gestionar las ventas
 */
public class Tienda {

    private String nombre;
    private String direccion;
    private int telf;

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
        double totalBruto = pedido.calcularTotal();
        double descuento = cliente.getDescuento();
        double totalConDescuento = totalBruto * (1 - descuento);
        return new Factura(cliente, pedido, totalConDescuento);
    }
}