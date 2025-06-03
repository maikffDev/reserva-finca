package models;

import enums.DiaSemana;

import java.time.LocalTime;

public class Horario {
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public boolean cubre(LocalTime horaInicio, LocalTime horaFin){
        return true;
    }
}