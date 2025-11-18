package poo;

public class SalaInformatica extends Sala {
    private int numEquipos;

public SalaInformatica(String nombre, int capacidad, boolean pizarra, String tipo, boolean dispReserva, int numEquipos)
{
    super(nombre, capacidad, pizarra, tipo, dispReserva);
    this.numEquipos=numEquipos;
}

public void setNumEquipos(int numEquipos)
{
    this.numEquipos=numEquipos;
}
public int getNumEquipos()
{
    return this.numEquipos;
}
@Override 
 public void informacion()
{
 super.informacion(); 
 System.out.println("Numero de equipos: " + numEquipos);
 
}











}
