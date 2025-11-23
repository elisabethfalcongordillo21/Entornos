package Apartado3;
public class Universidad {
    private String nombre;

    // relación 1..* con Departamento
    private Departamento[] departamentos;


    public Universidad(String nombre) {
        this.nombre = nombre;
    }
}
