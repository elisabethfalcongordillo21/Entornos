package com.example.project;
public abstract class Producto {
    
    private String nombre;
    private double precioBase;

    public Producto(String nombre, double precioBase)
    {
        if (precioBase<0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.nombre=nombre;
        this.precioBase=precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();
    @Override
    public String toString(){
        return nombre + "-" + precioBase;
    }


}
