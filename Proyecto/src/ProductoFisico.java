public class ProductoFisico extends Producto{
     private double costeEnvio;

     public ProductoFisico(String nombre, double precio, double costeEnvio) {
        super(nombre, precio);
        this.costeEnvio = costeEnvio;
    }

    
    public double getCosteEnvio() {
        return costeEnvio;
    }

    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() + costeEnvio;
    }
    
}
