package com.example.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Pedido {

// MEJORA: mejora para el test final
public static final String PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE = "El pedido no tiene productos";

private int idPedido;
private List<Producto> productos;
private List<Integer> idsOriginales; // MEJORA: mejora para el test final
private Map<Integer, Integer> cantidades;
private Cliente cliente;

public Pedido(Cliente cliente)
{
    this.idPedido = 0;
    this.cliente = cliente;
    this.productos = new ArrayList<>();
    this.idsOriginales = new ArrayList<>();
    this.cantidades = new HashMap<>();
}

public Pedido(int idPedido, Cliente cliente)
{
    this.idPedido = idPedido;
    this.cliente = cliente;
    this.productos = new ArrayList<>();
    this.idsOriginales = new ArrayList<>();
    this.cantidades = new HashMap<>();
}

public Pedido(int idPedido, Cliente cliente, List<Producto> productos, Map<Integer, Integer> cantidades)
{
    this.idPedido = idPedido;
    this.cliente = cliente;
    this.productos = new ArrayList<>(productos);
    this.idsOriginales = new ArrayList<>();
    this.cantidades = new HashMap<>(cantidades);
    for (Producto p : this.productos) {
        idsOriginales.add(p.getId());
        if (!this.cantidades.containsKey(p.getId())) {
            throw new IllegalArgumentException("Falta la cantidad del producto con id: " + p.getId());
        }
    }
}

//getters y setters

public int getIdPedido()
{
    return idPedido;
}

public Cliente getCliente()
{
    return cliente;
}

public void setCliente(Cliente cliente)
{
    this.cliente = cliente;
}

public List<Producto> getProductos()
{
    return new ArrayList<>(productos);
}

public void setProductos(List<Producto> productos)
{
    this.productos = productos;
}

public Map<Integer, Integer> getCantidades()
{
    return cantidades;
}

//metodos

// MEJORA: mejora para el test final
    public void addProducto(Producto p, int cantidad)
{
    if (p != null) {
        productos.add(p);
        idsOriginales.add(p.getId());
        cantidades.put(p.getId(), cantidad);
    }
}

public void agregarProducto(Producto p)
{
    if (p != null) {
        productos.add(p);
        idsOriginales.add(p.getId());
        cantidades.put(p.getId(), 1);
    }
}

public void eliminarProducto(Producto p)
{
    int index = productos.indexOf(p);
    if (index != -1) {
        productos.remove(index);
        idsOriginales.remove(index);
    }
}

public double calcularTotal()
{
    if (productos.isEmpty()) {
        throw new IllegalArgumentException(PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE);
    }
    double total = 0;
    for (int i = 0; i < productos.size(); i++)
    {
        Producto p = productos.get(i);
        int idOriginal = idsOriginales.get(i);
        int cantidad = cantidades.getOrDefault(idOriginal, 1);
        total += p.getPrecioBase() * cantidad;
    }
    return total;
}

// MEJORA: mejora para el test final
    public double calcularEnvio(String pais)
{
    double totalEnvio = 0.0;
    boolean hayFisicos = false;
    boolean hayGenericos = false;
    boolean hayDigitales = false;

    for (Producto p : productos) {
        if (p instanceof ProductoFisico) {
            hayFisicos = true;
        } else if (p instanceof ProductoDigital) {
            hayDigitales = true;
        } else {
            hayGenericos = true;
        }
    }

    if (hayFisicos) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p instanceof ProductoFisico) {
                ProductoFisico pf = (ProductoFisico) p;
                int idOriginal = idsOriginales.get(i);
                int cantidad = cantidades.getOrDefault(idOriginal, 1);
                totalEnvio += pf.calcularCosteEnvioPorPeso(pais) * cantidad;
            }
        }
    } else if (hayGenericos && hayDigitales) {
        if (pais != null && !pais.trim().isEmpty() && !pais.equalsIgnoreCase("España")) {
            totalEnvio = 5.0;
        }
    }

    return totalEnvio;
}

// MEJORA: mejora para el test final
    public double calcularIva(String tipoIva)
{
    double totalIva = 0.0;
    double porcentaje = 0.21;
    if (tipoIva.equals("REDUCIDO")) {
        porcentaje = 0.10;
    } else if (tipoIva.equals("SUPER")) {
        porcentaje = 0.04;
    }
    for (int i = 0; i < productos.size(); i++) {
        Producto p = productos.get(i);
        if (p instanceof ProductoDigital) {
            int idOriginal = idsOriginales.get(i);
            int cantidad = cantidades.getOrDefault(idOriginal, 1);
            totalIva += p.getPrecioBase() * porcentaje * cantidad;
        }
    }
    return totalIva;
}

public void mostrarInfo()
{
    System.out.println("Resumen pedido: ");
    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Correo: " + cliente.getCorreo());
    System.out.println("Direccion: " + cliente.getDireccion());
    System.out.println("\n Productos: ");

    for (Producto p : productos)
    {
        System.out.println("-" + p.toString() + " euros");
    }

    System.out.println("\nTotal: " + calcularTotal() + " euros");
}

}