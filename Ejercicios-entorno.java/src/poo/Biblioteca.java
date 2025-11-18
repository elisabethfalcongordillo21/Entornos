package poo;

import java.util.List;
import java.security.Permissions;
import java.util.ArrayList;

public class Biblioteca {
 
  //Declarar variables y las listas  

  private String nombre;
  private String direccion;
  private int horaApertura;
  private int horaCierre;

  private List<Libro>libros;
  private List<Sala>salas;

  //Practica 5
  private List<PersonaPoo>personas;

  //Crear constructor

  public Biblioteca( String nombre, String direccion, int horaApertura, int horaCierre){
    this.nombre = nombre;
    this.direccion = direccion;
    this.horaApertura = 9;
    this.horaCierre = 22;
    this.libros = new ArrayList<>();
    this.salas = new ArrayList<>();

    //Practica 5
    this.personas =  new ArrayList<>();
}

//Añadir, eliminar y mostrar  libros

public void addLibro(Libro libro){
    this.libros.add(libro);
    System.out.println("El libro " + libro.getTitulo() + " se ha añadido");
}

public void removeLibro(Libro libro){
   if (this.libros.remove(libro)){
    System.out.println("El libro " + libro.getTitulo() + " se ha eliminado");
    } else {System.out.println("El libro" + libro.getTitulo()  + " no estaba añadido");}
}

public void mostrarLibros(){
    System.out.println("El número de libros disponibles es: " + this.libros.size());
    System.out.println();

    if (this.libros.isEmpty()) {
        System.out.println("No hay libros en la biblioteca");
    }else{
        for(int i = 0; i< this.libros.size(); i++){
            Libro libro = this.libros.get(i);
            System.out.println((i+1)+ ". " + libro.getTitulo());
        }
    }
}

//Añadir, eliminar y mostrar salas

public void addSala (Sala sala){
    this.salas.add(sala);
    System.out.println("La sala ha sido añadida");
}
public void removeSala (Sala sala){
    if(this.salas.remove(sala)){
        System.out.println("La sala se ha eliminado");
    }else {System.out.println( "La sala no estaba añadida");}
}

public void mostrarSalas(){
    System.out.println("El número de salas es: " + this.salas.size());
    System.out.println();

    if (this.salas.isEmpty()) {
        System.out.println("No hay salas");
    }else{
        for(int i = 0; i< this.salas.size(); i++){
            Sala sala = this.salas.get(i);
            System.out.println((i+1)+ ". " + sala.getNombre() + "- Capacidad: " +  sala.getCapacidad() + "-Tipo: " + sala.getTipo() + "-Numero Personas: " + sala.getNumeroPersonas());
        }
    }
}

//Metodo para verificar si está abierta

public void estaAbierta(int hora) {

    if (hora > this.horaApertura && hora < this.horaCierre) {
        System.out.println("La biblioteca está abierta");
    }else{
        System.out.println("La biblioteca está cerrada");
    }
}

//Metodos para mostrar informacion y mostrar datos de la biblioteca


public void mostrarBiblioteca(){
    System.out.println("El nombre de la biblioteca es: " + this.nombre);
    System.out.println("La dirección de la biblioteca es: " + this.direccion);
    System.out.println("La hora de apertura es: " + this.horaApertura + " y la hora del cierre es: " + this.horaCierre);

    
    System.out.println("El número de libros disponibles es: " + this.libros.size());
    System.out.println();

    if (this.libros.isEmpty()) {
        System.out.println("No hay libros en la biblioteca");
    }else{
        for(int i = 0; i< this.libros.size(); i++){
            Libro libro = this.libros.get(i);
            System.out.println((i+1)+ ". " + libro.getTitulo());
        }
    }
   
    System.out.println("El número de salas  es: " + this.salas.size());
    System.out.println();

    if (this.salas.isEmpty()) {
        System.out.println("No hay salas");
    }else{
        for(int i = 0; i< this.salas.size(); i++){
            Sala sala = this.salas.get(i);
            System.out.println((i+1)+ ". " + sala.getNombre() + "-" +  sala.getCapacidad() + "-" + sala.getTipo());
        }
    }
}

//Metodo para buscar libro por el titulo

public Libro buscarLibroPorTitulo(String titulo){
    for(Libro libro : this.libros){
        if (libro.getTitulo().equals(titulo)) {
            return libro;
        }
    }
    return null;
} 

//Metodo para mostrar las salas vacias

public void mostrarSalasDisponibles(){
 System.out.println( "Numero de salas vacías ");
    for(int i = 0; i < this.salas.size(); i++) {
            Sala sala = this.salas.get(i);
            if (sala.getNumeroPersonas() == 0) {
                System.out.println((i+1) +". Nombre: "+ sala.getNombre() + ", capacidad " + sala.getCapacidad() + ", tipo " + sala.getTipo());
            } 
        }
    }

//Metodo para mostrar el total de personas en una sala

public void mostrarTotalPersonas(){

    int totalPersonas = 0;
    for(Sala sala : this.salas){
        totalPersonas += sala.getNumeroPersonas();
    }
    System.out.println("El total de personas en la sala es: " + totalPersonas);
}

//Metodos para practica 5


public void registroVisita(PersonaPoo visitante ){

    System.out.println(visitante.getNombre() + " ha estado en la biblioteca " + nombre);

}

public void registrarPrestamo(PersonaPoo prestador, Libro libro){

    System.out.println(prestador.getNombre() + " ha cogido prestado el libro " + libro.getTitulo());

}

//metodo para registrar el responsable
public void asignarResponsable(Sala s, PersonaPoo personaResponsable)
{
  if (salas.contains(s)) 
  {
    s.setPersonaResponsable(personaResponsable); 
    System.out.println("La persona responsable de la sala " +  s.getNombre() +" es: " + personaResponsable);
  }else
  {
    System.out.println("La sala: " + s.getNombre() + " no tiene ninguna persona responsable, ya que no pertecene a la biblioteca " + nombre);
  }
}


public void mostrarInformacion(){
    System.out.println("Biblioteca: " + nombre + "," + direccion + "." + "Abierto de " + horaApertura + " a " + horaCierre+ ". " + "Los libros disponibles son: " + this.libros.size() + ". Las salas que hay en la biblioteca son: " + this.salas.size() );



}


}