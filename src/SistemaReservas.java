import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SistemaReservas {
    private List<Reserva> reservas;

    public boolean registrarReserva(Reserva reserva){
        return true;
    }

    public List<Reserva> obtenerReservasPorFinca(Finca finca){
        List<Reserva> reservasPorFinca = List.of();
        return reservasPorFinca;
    }

    public boolean verificarConflicto(Finca finca, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        return true;
    }
}
