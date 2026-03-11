public class ProductoDigital extends Producto {
   
    private double tamanioDescarga;
    private double porcientoIVA;
    private double descuento;
    

    public ProductoDigital(String nombre, double precio,double tamanioDescarga, double porcientoIVA, double descuento) {
        super(nombre,precio);
        this.tamanioDescarga = tamanioDescarga;
        this.porcientoIVA = porcientoIVA;
        this.descuento = descuento;
    }

    public double getTamanioDescarga() {
        return this.tamanioDescarga;
    }

    public void setTamanioDescarga(double tamanioDescarga) {
        this.tamanioDescarga = tamanioDescarga;
    }

    public double getPorcientoIVA() {
        return this.porcientoIVA;
    }

    public void setPorcientoIVA(double porcientoIVA) {
        this.porcientoIVA = porcientoIVA;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override 
    public double calcularPrecio()
    {
        double ivaAplicado = getPrecio()*(this.porcientoIVA/100.0 +1);
        double precioFinal = ivaAplicado-this.descuento;
        if (precioFinal<0) {
            return 0.0;
        }
        return precioFinal;
    }
    
}
