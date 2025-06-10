import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private static int contadorId = 1;
    private int id;
    private Finca finca;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Reserva(Finca finca, Cliente cliente, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = contadorId++;
        this.finca = finca;
        this.cliente = cliente;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Finca getFinca() {
        return finca;
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

    public double calcularTotal() {
        return Duration.between(horaInicio, horaFin).toHours() * finca.getTarifaHora();
    }

    public boolean esValida() {
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id +", "+ finca.toString() +
                ", cliente: " + cliente.toString() +
                ", fecha: " + fecha +
                ", de " + horaInicio +
                "h a " + horaFin + "h, " +
                "total: $" + calcularTotal();
    }
}
