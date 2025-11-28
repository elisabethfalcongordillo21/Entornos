public class ProductoDigital extends Producto {
     private String licencia;

    public ProductoDigital(String nombre, double precio, String licencia) {
        super(nombre, precio);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 0.90; // descuento digital
    }
}
