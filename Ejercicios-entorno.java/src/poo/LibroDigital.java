package poo;

public class LibroDigital extends Libro
 {
    private String formato;
    private int tamanioMB;

public LibroDigital(String titulo ,String ISBN, String editorial, String idioma, int numPag, int anio, boolean dispReserva, String formato, int tamanioMB)
{
    super(titulo, ISBN, editorial, idioma, numPag, anio, dispReserva);
    this.formato = formato;
    this.tamanioMB = tamanioMB;

}

public void setFormato(String formato)
{
    this.formato = formato;
}
public String getFormato()
{
    return this.formato;
}

public void setTamanioMB(int tamanioMB)
{
    this.tamanioMB = tamanioMB;
}

public int getTamanioMB()
{
    return this.tamanioMB;
}

@Override 
 public void informacion() {
 super.informacion(); 
 System.out.println("Formato: " + formato);
 System.out.println("Tamaño: " +tamanioMB);
 }


}
