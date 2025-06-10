import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Finca {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String ubicacion;
    private double tarifaHora;
    private List<Horario> horariosDisponibles;

    public Finca(String nombre, String ubicacion, double tarifaHora, List<Horario> horariosDisponibles) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tarifaHora = tarifaHora;
        this.horariosDisponibles = horariosDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public List<Horario> getHorarioDisponibles() {
        List<Horario> horariosFiltrados = new ArrayList<>(horariosDisponibles);
        SistemaReservas sistemaReservas = SistemaReservas.getInstancia();

        horariosFiltrados.removeIf(horario ->
                sistemaReservas.getReservas().stream().anyMatch(reserva ->
                        reserva.getFecha().equals(horario.getFecha()))
        );
        return horariosFiltrados;
    }

    public boolean esDisponible(LocalDate fecha) {
        for (Horario horario : this.getHorarioDisponibles()) {
            if (horario.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false; // No está dentro de ningún rango
    }

    public double calcularPrecio(int horas) {
        return horas * tarifaHora;
    }

    public boolean listar(List<?> lista) {
//        lista.forEach(System.out::println);
        if (lista.isEmpty()) {
            return false;
        } else {
            lista.forEach(System.out::println);
            return true;
        }
    }

    @Override
    public String toString() {
        return "Finca: " + nombre + '\'' +
                ", ubicacion: '" + ubicacion + '\'' +
                ", tarifaHora: $" + tarifaHora;
    }
}
