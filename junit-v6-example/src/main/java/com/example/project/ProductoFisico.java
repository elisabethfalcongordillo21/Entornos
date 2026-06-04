package com.example.project;
public class ProductoFisico extends Producto {

    private double peso;

    // MEJORA: cambio para el test final
    public ProductoFisico(int id, String nombre, double precioBase, double peso) {
        super(id, nombre, precioBase);
        this.peso = peso;
    }

    public ProductoFisico(String nombre, double precioBase, double peso) {
        super(0, nombre, precioBase);
        this.peso = peso;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
   
    public double calcularCosteEnvio(String pais) {
        if (pais.equalsIgnoreCase("España"))
            return 0;
        else if (pais.equalsIgnoreCase("Francia") ||
                 pais.equalsIgnoreCase("Italia") ||
                 pais.equalsIgnoreCase("Portugal"))
            return 5;
        else
            return 10;
    }

    // MEJORA: cambio para el test final
    public double calcularCosteEnvioPorPeso(String pais) {
        if (pais == null || pais.isEmpty()) return 0.0;
        return peso * 0.10;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase();
    }
    
    @Override
    public String toString() {
        return getNombre() + " - " + getPrecioBase() + "€ (peso: " + peso + "kg)";
    }
}