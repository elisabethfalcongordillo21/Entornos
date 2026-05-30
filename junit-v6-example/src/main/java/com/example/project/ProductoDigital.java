package com.example.project;
public class ProductoDigital extends Producto {
   
    private double tamanioDescarga;
    private double porcientoIVA;
    private double descuento;
    private String codigoLicencia;

    public ProductoDigital(String nombre, double precio,double tamanioDescarga, double porcientoIVA, double descuento,String codigoLicencia) {
        super(nombre,precio);
        this.tamanioDescarga = tamanioDescarga;
        this.porcientoIVA = porcientoIVA;
        this.descuento = descuento;
        this.codigoLicencia= codigoLicencia;
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

    public String getCodigoLicencia() { 
        return codigoLicencia;
    }
    public void setCodigoLicencia(String codigoLicencia) { 
        this.codigoLicencia = codigoLicencia; 
    }

    public double aplicarIVA(String tipoIva) {
        switch (tipoIva) {
            case "GENERAL": return getPrecioBase() * 1.21;
            case "REDUCIDO": return getPrecioBase() * 1.10;
            case "SUPER": return getPrecioBase() * 1.04;
            default: return getPrecioBase();
        }
    }

    @Override
    public double calcularPrecioFinal() {
        double precioConIva = aplicarIVA("GENERAL");
        double precioFinal = precioConIva - descuento;
        if (precioFinal < 0) return 0.0;
        return precioFinal;
    }

    @Override
    public String toString() {
        return getNombre() + " - " + getPrecioBase() + "€ (licencia: " + codigoLicencia + ")";
    }
    
}
