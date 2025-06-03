package models;

import enums.DiaSemana;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Finca {
    private int id;
    private String nombre;
    private String ubicacion;
    private double tarifaHora;
    private List<Horario> horariosDisponibles = new ArrayList<>();

    public Finca(int id, String nombre, String ubicacion, double tarifaHora){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tarifaHora = tarifaHora;
    }


    public List<Horario> getHorariosDisponibles(){
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(Horario horario) {
        horariosDisponibles.add(horario);
    }

    public boolean esDisponible(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        return true;
    }

    public double calcularPrecio(int horas){
        double precio = horas * tarifaHora;
        return precio;
    }

    @Override
    public String toString() {
        return "Finca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tarifaHora=" + tarifaHora +
                ", horariosDisponibles=" + horariosDisponibles +
                '}';
    }
}
