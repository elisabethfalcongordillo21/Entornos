package Apartado3;

import java.util.Date;

public class Profesor extends Persona {

    private double salario =0;
    private Curso cursoAsignado;

    

    public Profesor(String dni, String nombre, Date fechaNacimiento, double salario ){
        super(dni, nombre, fechaNacimiento);
        this.salario=salario;
    }
    
    public void  asignarCurso(Curso c){
        this.cursoAsignado = c;
    }
}