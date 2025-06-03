package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private Finca finca;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public double calcularTotal(){
        return 0;
    }

    public boolean esValida(){
        return true;
    }
}
