package com.example.project;
public class Cliente {
    private String nombre;
    private String correo;
    private String direccion;
    private String dni;
    private int telf;


    public Cliente(String nombre, String correo, String direccion, String dni, int telf) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.dni = dni;
        this.telf = telf;
    }
    

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelf() {
        return this.telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }


    @Override
    public String toString() {
        return 
            " Nombre:" + getNombre() + "\n" +
            "Correo:" + getCorreo() + "\n" +
            "Direccion:" + getDireccion() + "\n" +
            "Dni:" + getDni() + "\n" +
            "Telefono:" + getTelf() + "\n" ;
    }


}



