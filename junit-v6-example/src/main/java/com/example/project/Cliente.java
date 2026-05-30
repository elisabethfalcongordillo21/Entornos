package com.example.project;
public class Cliente {
    private String nombre;
    private String correo;
    private String direccion;
    private String dni;
    private int telf;
    private int añosAntiguedad;
    private boolean esVip;
    private String pais;


    public Cliente(String nombre, String correo, String direccion, String dni, int telf,int añosAntiguedad, boolean esVip, String pais) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.dni = dni;
        this.telf = telf;
        this.añosAntiguedad = añosAntiguedad;
        this.esVip = esVip;
        this.pais = pais;
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

    public int getAñosAntiguedad() {
        return this.añosAntiguedad;
    }

    public void setAñosAntiguedad(int añosAntiguedad) {
        this.añosAntiguedad = añosAntiguedad;
    }

    public boolean isEsVip() {
        return this.esVip;
    }

    public boolean getEsVip() {
        return this.esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public double getDescuento() {
        if (esVip && añosAntiguedad >= 5)
            return 0.15;
        else if (esVip)
            return 0.10;
        else if (añosAntiguedad >= 3)
            return 0.05;
        else
            return 0.0;
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



