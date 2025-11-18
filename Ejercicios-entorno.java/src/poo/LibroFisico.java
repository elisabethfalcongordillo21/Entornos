package poo;

public class LibroFisico extends Libro
 {
    private String ubicacion;



public LibroFisico (String titulo ,String ISBN, String editorial, String idioma, int numPag, int anio, boolean dispReserva,String ubicacion)
{
    super(titulo, ISBN, editorial, idioma, numPag, anio, dispReserva);
    this.ubicacion = ubicacion;
 
}

public void setUbicacion (String ubicacion)
{
    this.ubicacion = ubicacion;
}

public String getUbicacion ()
{
    return this.ubicacion;
}


@Override 
 public void informacion() {
 super.informacion(); 
 System.out.println("Ubicacion: " + ubicacion);
 
 }


}

















