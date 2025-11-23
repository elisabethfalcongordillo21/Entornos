package Apartado3;

import java.sql.Date;

public class Estudiante extends Persona {
    private boolean repetidor;

    

    public Estudiante(String dni, String nombre, Date fechaNacimiento, boolean repetidor) {
        super(dni, nombre, fechaNacimiento);
        this.repetidor = repetidor;
    }

    public Matricula inscribirse(Curso c) {
        return null; 
    }
}
