package Apartado3;
public class Direccion {
    private String calle;
    private int numero;
    private String ciudad;

    private Persona persona; // relación 1 a 1


    public Direccion(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }
}
