package Apartado3;

import java.util.Date;

public class Matricula {
      private Date fecha;
    private double notaFinal;

    private Curso curso;        // relación
    private Estudiante alumno;  // relación


    public Matricula(Date fecha, Curso curso, Estudiante alumno) {
        this.fecha = fecha;
        this.curso = curso;
        this.alumno = alumno;
    }

    public double calcularNotaFinal() {
        return 0; // sin implementar
    }
}
