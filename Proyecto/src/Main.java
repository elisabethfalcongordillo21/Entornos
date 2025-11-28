public class Main {
   public static void main(String[] args) 

    Cliente cliente1 =  new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29");
    ProductoFisico teclado = new ProductoFisico ("Teclado",  30.0, 4.99);
    ProductoDigital ebook = new ProductoDigital ("Ebook Carnaval", 15.0, "CodigoCarnaval");

    Pedido pedido = new Pedido(cliente1);
    pedido.agregarProducto(teclado);
    pedido.agregarProducto(ebook);

    pedido.mostrarInfo();


}
