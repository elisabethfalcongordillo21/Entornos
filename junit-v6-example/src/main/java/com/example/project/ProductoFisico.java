package com.example.project;
public class ProductoFisico extends Producto{
     private double peso;

    public ProductoFisico(String nombre, double precioBase, double peso) {
        super(nombre, precioBase);
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

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase();
    }
    
    @Override
    public String toString() {
        return getNombre() + " - " + getPrecioBase() + "€ (peso: " + peso + "kg)";
    }
    
}
