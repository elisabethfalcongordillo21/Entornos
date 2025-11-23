package Apartado3;
public class Curso {
     private String codigo;
    private String nombre;
    private int cupoMaximo;

    private Profesor profesor;         // cursosDictados
    private Horario[] horarios;        // 1..*
    private Matricula[] inscripciones; // 0..*

    

    public Curso(String codigo, String nombre, int cupoMaximo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
    }

    public Matricula inscribir(Estudiante e) {
        return null; // sin implementar
    }
}