package poo;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends PersonaPoo{
    private  int numSocio;
    private List<Libro> librosPrestados;


public Usuario(String nombre, int edad, String direccion, String apellido, String DNI, String email, String telefono, String profesion, String anios_experiencia, int numSocio)
{
    super(nombre, edad, direccion, apellido, DNI, email, telefono, profesion, anios_experiencia);
    this.numSocio= numSocio;
    this.librosPrestados = new ArrayList<>();
}

public List<Libro> getLibrosPrestados()
{
    return librosPrestados;
}

public void addLibrosPrestados(Libro libro){
    this.librosPrestados.add(libro);
    System.out.println("El libro " + libro.getTitulo() + " se ha añadido");
}

public void devolverLibro(Libro libro){
   if (this.librosPrestados.remove(libro)){
    System.out.println("El libro " + libro.getTitulo() + " se ha devuelto");
    } else {System.out.println("El libro" + libro.getTitulo()  + " no estaba devuelto");}
}

@Override 
 public void informacion()
{
 super.informacion(); 
 System.out.println("Numero de socio: " + numSocio);
 System.out.println("Libros prestados: " + librosPrestados);
 }



}
