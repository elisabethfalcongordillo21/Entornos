package com.example.project;

public class Main{

     public static void main(String[] args){ 

    Cliente cliente1 = new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29", "46386812T", 66486521, 3, false, "España");

        ProductoFisico teclado = new ProductoFisico("Teclado", 30.0, 1.5);
         ProductoDigital ebook = new ProductoDigital("Ebook", 40.5, 10.0, 21.0, 5.0, "LIC-001");

        Pedido pedido = new Pedido(cliente1);
        pedido.agregarProducto(teclado);
        pedido.agregarProducto(ebook);

        pedido.mostrarInfo();

        Tienda tienda = new Tienda("Mi Tienda", "Calle Mayor, 1", 666123456);
        Factura factura = tienda.realizarVenta(cliente1, pedido);
        factura.imprimirFactura();

    }




}


