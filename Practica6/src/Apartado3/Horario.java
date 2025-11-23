package Apartado3;

import java.sql.Time;

public class Horario {
      private String diaSemana;
    private Time horaInicio;
    private Time horaFin;

    private Curso curso; // relación hacia Curso


    public Horario(String diaSemana, Time horaInicio, Time horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}
