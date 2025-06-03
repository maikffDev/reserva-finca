import java.time.LocalTime;

public class Horario {
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public boolean cubre(LocalTime horaInicio, LocalTime horaFin){
        return true;
    }
}