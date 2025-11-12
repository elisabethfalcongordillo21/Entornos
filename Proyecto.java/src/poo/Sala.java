package poo;

import java.util.List;
import java.util.ArrayList;

public class Sala {
    
    private String nombre;
    private int capacidad;
    private boolean pizarra;
    private String tipo;
    private boolean dispReserva;
    private List<PersonaPoo>personas;
    private int numeroPersonas;

    public Sala(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva){

        this.nombre =  nombre;
        this.capacidad = capacidad;
        this.pizarra =  pizarra;
        this.tipo = tipo;
        this.dispReserva = dispReserva;
        this.personas =  new ArrayList<>();
        this.numeroPersonas = 0;

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre (){
        return this.nombre;
    }
    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    public void setPizarra(boolean pizarra){
        this.pizarra= pizarra;
    }
    public boolean getPizarra(){
        return this.pizarra;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setDispReserva(boolean dispReserva){
        this.dispReserva = dispReserva;
    }
    public boolean getDispReserva(){
        return this.dispReserva;
    }

    public void setNumeroPersonas (int numeroPersonas){
        this.numeroPersonas = numeroPersonas;
    }

    public int getNumeroPersonas(){
        return this.numeroPersonas;
    }

    public boolean estaDisponible(){
        if (dispReserva==true){
            System.out.println("La sala se encuentra disponible para su reserva");
            return true;
        }else {System.out.println("La sala no encuentra disponible para su reserva"); 
            return false;}
    }

    public boolean tienePizarra(){
        if (pizarra==true) {
            System.out.println("La sala dispone de pizarra");
            return true;
        }else { System.out.println( "La sala no dispone de pizarra"); 
        return false;}
    }
    
    public void informacion(){
        System.out.println("Sala: " + nombre + ", " + capacidad+ "." + tipo + ", " + pizarra + ", " + dispReserva + "."); 
    }

    public boolean entrarPersona(PersonaPoo p){
        if (this.personas.size()<this.getCapacidad()){
            this.personas.add(p);
            System.out.println("La persona se ha añadido");
            return true;
        } else {System.out.println("La persona no puede entrar");}
        return false;
    }
    public boolean salirPersona(PersonaPoo p){
        if (this.getCapacidad()>0 && this.personas.remove(p)) {
            System.out.println("La persona " + p.getNombre() + "ha sido eliminada");
            return true;
        }else if (this.getCapacidad() == 0)
        {System.out.println("No hay nadie para eliminar, la sala se encuentra vacía.");
            return false;
        }

        else{System.out.println("La persona " + p.getNombre() + " no estaba en la biblioteca.");
            return false;
        }  
    }

    public void mostrarPersonas(){

        for(int i=0; i<this.personas.size();i++){

            PersonaPoo persona = this.personas.get(i);
            System.out.println((i+1) + ". " + persona.getNombre() + ", " + persona.getApellido() + ", " + persona.getDNI() + ", " + persona.getEdad() + ", " + persona.getTelefono() + "." );

        }
    }





}
