package com.example.project;

// MEJORA: cambio para el test final
public class Producto {
    
    private int id; // MEJORA: cambio para el test final
    private String nombre;
    private double precioBase;

// MEJORA: cambio para el test final    
    public Producto(int id, String nombre, double precioBase)
    {
        if (precioBase<0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id=id;
        this.nombre=nombre;
        this.precioBase=precioBase;
    }

// MEJORA: cambio para el test final    
    public int getId() {
        return id;
    }

// MEJORA: cambio para el test final    
    public void setId(int id) {
        this.id = id;
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

// MEJORA: cambio para el test final    
    public double calcularPrecioFinal() {
        return precioBase;
    }

    @Override
    public String toString(){
        return nombre + "-" + precioBase;
    }
}