import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private static SistemaReservas instancia;
    private List<Reserva> reservas;

    private SistemaReservas() {
        this.reservas = new ArrayList<>();
    }

    public static SistemaReservas getInstancia() {
        if (instancia == null) {
            instancia = new SistemaReservas();
        }
        return instancia;
    }

    public boolean registrarReserva(Reserva reserva) {
        if (!(verificarConflicto(reserva.getFinca(), reserva.getFecha()))) {
            return reservas.add(reserva);
        }
        return false;
    }

    public List<Reserva> obtenerReservasPorFinca(Finca finca) {
        List<Reserva> reservasFinca = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getFinca().equals(finca)) {
                reservasFinca.add(reserva);
            }
        }
        return reservasFinca;
    }

    public boolean verificarConflicto(Finca finca, LocalDate fecha) {
        /*for (Reserva reserva : reservas) {
            if (reserva.getFinca().equals(finca) && reserva.getFecha().equals(fecha)) {
                if (!(horaFin.isBefore(reserva.getHoraInicio()) || horaInicio.isAfter(reserva.getHoraFin()))) {
                    return true;
                }
            }
        }*/
            if (finca.esDisponible(fecha)){
                return false;
            }
        return true;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void listar(List<?> lista) {
        lista.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "SistemaReservas{" +
                "reservas=" + reservas +
                '}';
    }
}
