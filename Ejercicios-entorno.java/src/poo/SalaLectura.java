package poo;

import java.util.List;
import java.util.ArrayList;

public class SalaLectura extends Sala {
private List<Libro>listaLibros;
   
   public SalaLectura(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva)
   {
        super(nombre, capacidad, pizarra, tipo, dispReserva);
        this.listaLibros = new ArrayList<>();
   }

   public List<Libro> getListaLibros()
   {
        return listaLibros;
   }

public void addListaLibros(Libro libro){
    this.listaLibros.add(libro);
    System.out.println("El libro " + libro.getTitulo() + " se ha añadido a la sala " + getNombre() );
}
public void mostrarLibros(){
    System.out.println("El número de libros disponibles es: " + this.listaLibros.size());
    System.out.println();

    if (this.listaLibros.isEmpty()) {
        System.out.println("No hay libros en la sala");
    }else{
        for(int i = 0; i< this.listaLibros.size(); i++){
            Libro libro = this.listaLibros.get(i);
            System.out.println((i+1)+ ". " + libro.getTitulo());
        }
    }
}

}
