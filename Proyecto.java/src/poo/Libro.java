package poo;

public class Libro {
    
    String titulo;
    String ISBN;
    String editorial;
    String idioma;
    int numPag;
    int anio;
    boolean dispreserva;

    public Libro(String titulo,String ISBN, String editorial, String idioma, int numPag, int anio, boolean dispreserva) {

        this.titulo= titulo;
        this.ISBN =  ISBN;
        this.editorial =  editorial;
        this.idioma = idioma;
        this.numPag = numPag;
        this.anio = anio;
        this.dispreserva = dispreserva;

    }

    public void setTitulo ( String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo (){
        return this.titulo;
    }



}
