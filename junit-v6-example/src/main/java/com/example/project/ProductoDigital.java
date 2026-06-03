package com.example.project;
public class ProductoDigital extends Producto {
   
    private double tamanioDescarga;
    private double porcientoIVA;
    private double descuento;
    private String codigoLicencia;

    // MEJORA: mejora para el test final
    public ProductoDigital(int id, String nombre, double precio) {
        super(id, nombre, precio);
        this.tamanioDescarga = 0.0;
        this.porcientoIVA = 21.0;
        this.descuento = 0.0;
        this.codigoLicencia = "";
    }

    // MEJORA: mejora para el test final
    public ProductoDigital(int id, String nombre, double precio, double tamanioDescarga, double porcientoIVA, double descuento, String codigoLicencia) {
        super(id, nombre, precio);
        this.tamanioDescarga = tamanioDescarga;
        this.porcientoIVA = porcientoIVA;
        this.descuento = descuento;
        this.codigoLicencia = codigoLicencia;
    }

    public ProductoDigital(String nombre, double precio,double tamanioDescarga, double porcientoIVA, double descuento,String codigoLicencia) {
        super(0, nombre, precio);
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
        double precioConIva = getPrecioBase() * (1 + porcientoIVA / 100.0);
        double precioFinal = precioConIva - descuento;
        if (precioFinal < 0) return 0.0;
        return precioFinal;
    }

    @Override
    public String toString() {
        return getNombre() + " - " + getPrecioBase() + "€ (licencia: " + codigoLicencia + ")";
    }
}