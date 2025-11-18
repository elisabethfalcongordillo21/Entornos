package poo;

public class SalaEstudio extends Sala {
    private int numMesas;

public SalaEstudio(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numMesas)
{

    super(nombre, capacidad, pizarra, tipo, dispReserva);
    this.numMesas=numMesas;

}

public void setNumMesas( int numMesas)
{
    this.numMesas=numMesas;
}
public int getNumMesas()
{
    return this.numMesas;
}

@Override 
 public void informacion()
{
 super.informacion(); 
 System.out.println("Numero de mesas: " + numMesas);
 
}


}
