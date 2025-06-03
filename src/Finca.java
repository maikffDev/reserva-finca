import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Finca {
    private int id;
    private String nombre;
    private String ubicacion;
    private double tarifaHora;
    private List<Horario> horariosDisponibles;

    public List<Horario> getHorariosDisponibles(){
        List<Horario> horariosDisponibles = List.of();
        return horariosDisponibles;
    }
    public boolean esDisponible(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        return true;
    }

    public double calcularPrecio(int horas){
        double precio = 0;
        return precio;
    }
}
