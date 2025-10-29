package poo;

import javax.print.DocFlavor.STRING;

public class PersonaPoo {
    /**
     * Definicion de atributos de la persona
     */

    String nombre;
    int edad;
    String  direccion;
    String apellido;
    String DNI;
    String email;
    String telefono;
    String profesion;
    String anios_experiencia;


    /**
     * Defincion del comportamiento de la persona
     */

     public PersonaPoo (String nombre, int edad) {

        this.nombre = nombre;
        this.edad = edad;
        this.direccion= direccion;
        this.apellido = apellido; 
        this.DNI = DNI;
        this.email = email;
        this.telefono = telefono;
        this.profesion = profesion;
        this.anios_experiencia = anios_experiencia;

     }

    public void MostrarInformacion(){

        System.out.println("Nombre " + this.nombre + " , edad: " + this.edad + " y vive en " + this.direccion) ;
    }

    public void setDireccion (String direccion) {

        this.direccion=direccion;
    }

    public int getEdad(){

        return this.edad;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public String getEmail() {
        return this.email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return this.telefono;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setAnios_experiencia(String anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }
    public String getAnios_experiencia() {
        return this.anios_experiencia;
    }

    public boolean estaJubilado(){

        if (this.edad > 65) {
            System.out.println("La persona está jubilad@");
            return true;
        }else{
            if (this.edad>=18) {
                System.out.println("La persona en cuestión está en edad de trabajar");
            }else{
                System.out.println("La persona en cuestión está en edad de trabajar.");
            }
                
        return false;
    }


    }


}


