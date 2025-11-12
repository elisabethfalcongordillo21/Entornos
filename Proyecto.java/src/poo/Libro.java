package poo;

public class Libro {
    
    private String titulo;
    private String ISBN;
    private String editorial;
    private String idioma;
    private int numPag;
    private int anio;
    private boolean dispReserva;

    public Libro(String titulo,String ISBN, String editorial, String idioma, int numPag, int anio, boolean dispReserva) {

        this.titulo= titulo;
        this.ISBN =  ISBN;
        this.editorial =  editorial;
        this.idioma = idioma;
        this.numPag = numPag;
        this.anio = anio;
        this.dispReserva = dispReserva;

    }

    public void setTitulo ( String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo (){
        return this.titulo;
    }
    public void setISBN (String ISBN){
        this.ISBN = ISBN;
    }

    public String getISBN (){
        return this.ISBN;
    } 

    public void setEditorial(String editorial){
        this.editorial= editorial;
    }

    public String getEditorial(){
        return this.editorial;
    }

    public void setIdioma (String idioma){
        this.idioma = idioma;
    }

    public String getIdioma (){
        return this.idioma;
    }

    public void setNumPag (int numPag){
        this.numPag = numPag;
    }

    public int getNumPag (){
        return this.numPag;
    }

    public void setAnio (int anio){
        this.anio = anio;
    }

    public int getAnio(){
        return this.anio;
    }

    public void setDispReserva(boolean dispReserva){
        this.dispReserva = dispReserva;
    }

    public boolean getDispReserva(){
        return this.dispReserva;
    }

    public boolean estaDisponible(){
        if (dispReserva==true){
            System.out.println("El libro se encuentra disponible para su reserva");
            return true;
        }else {System.out.println("El libro no encuentra disponible para su reserva"); 
            return false;}
    }

    public void esExtranjero(){
        if (idioma.equals("Espanyol")) {
            System.out.println("El libro está escrito en Español");  
        }else {System.out.println("El libro no está escrito en Español, está escrito en " + this.idioma);}
    }

    public void informacion(){
        System.out.println("Libro: " + this.titulo + "," + this.editorial + "," + this.anio + "," + this.idioma + "," + this.numPag + "," + this.dispReserva + ".");
    }
}
