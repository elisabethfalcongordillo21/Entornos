<<<<<<< HEAD
public class Main{

     public static void main(String[] args){ 
=======
public class Main {
   public static void main(String[] args) 
>>>>>>> 9530f17cbb738ab6b97b058382c0c7ef5a781119

    Cliente cliente1 =  new Cliente("Eli", "eli@gmail.com", "calle Mexico, 29");
    ProductoFisico teclado = new ProductoFisico ("Teclado",  30.0, 4.99);
    ProductoDigital ebook = new ProductoDigital ("Ebook Carnaval", 15.0, "CodigoCarnaval");

    Pedido pedido = new Pedido(cliente1);
    pedido.agregarProducto(teclado);
    pedido.agregarProducto(ebook);

    pedido.mostrarInfo();
<<<<<<< HEAD
     

    }
=======


>>>>>>> 9530f17cbb738ab6b97b058382c0c7ef5a781119
}
