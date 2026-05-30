package com.example.project;

import java.util.ArrayList;
import java.util.List;


public class Pedido {

private List<Producto> productos;
private Cliente cliente;

public Pedido (Cliente cliente)
{
    this.cliente = cliente;
    this.productos = new ArrayList<>();

}

//getters y setters

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
    return productos;
}

public void setProductos(List<Producto> productos)
{
    this.productos = productos;
}

//metodos

public void agregarProducto(Producto p)
{
     if (p != null) {
        productos.add(p);
    }
}


public void eliminarProducto(Producto p) {
        productos.remove(p);
}


public double calcularTotal()
{
    if (productos.isEmpty()) {
        throw new IllegalStateException("El pedido no tiene productos");
    }
    double total = 0;
    for (Producto p : productos)
    {
        if (p instanceof ProductoFisico) {
            ProductoFisico pf = (ProductoFisico) p;
            total += pf.getPrecioBase() + pf.calcularCosteEnvio(cliente.getPais());
        } else {
            total += p.calcularPrecioFinal();
        }
    }
    return total;
}

public void mostrarInfo()
{

    System.out.println("Resumen pedido: ");
    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Correo: " + cliente.getCorreo());
    System.out.println("Direccion: " + cliente.getDireccion());
    System.out.println("\n Productos: ");

    for(Producto p : productos)
    {
        System.out.println("-" + p.toString() + " euros" );
    }

    System.out.println("\nTotal: " + calcularTotal() + " euros");


}

}
