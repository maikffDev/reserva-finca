import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public boolean cubre(LocalTime horaInicio, LocalTime horaFin) {
        boolean cubierto = false;
        if ((horaInicio.isAfter(this.horaInicio) || horaInicio.equals(this.horaInicio)) && (horaFin.isBefore(this.horaFin) || horaFin.equals(this.horaFin))) {
            cubierto = true;
        }
        return cubierto;
    }

    @Override
    public String toString() {
        return "fecha: " + fecha +
                " de: " + horaInicio +
                "h a " + horaFin +
                "h.";
    }
}
