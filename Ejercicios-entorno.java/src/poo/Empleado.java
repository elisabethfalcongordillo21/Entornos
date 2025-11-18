package poo;

public class Empleado extends PersonaPoo {
    
private String puesto;
private double sueldo;

public Empleado(String nombre, int edad, String direccion, String apellido, String DNI, String email, String telefono, String profesion, String anios_experiencia,String puesto, double sueldo)
{
    super(nombre, edad, direccion, apellido, DNI, email, telefono, profesion, anios_experiencia);
    this.puesto=puesto;
    this.sueldo=sueldo;

}

public void setPuesto(String puesto)
{
    this.puesto=puesto;
}

public String getPuesto ()
{
    return this.puesto;
}

public void setSueldo(double sueldo)
{
    this.sueldo=sueldo;
}

public double getSueldo()
{
    return this.sueldo;
}

@Override 
 public void informacion()
{
 super.informacion(); 
 System.out.println("Puesto: " + puesto);
 System.out.println("Sueldo: " + sueldo);
 }


}
