import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanciar horarios disponibles de la finca y agregarlos a la lista de horarios
        List<Horario> horariosFinca1 = new ArrayList<>();
        horariosFinca1.add(new Horario(LocalDate.of(2025, 6, 7), LocalTime.of(9, 0), LocalTime.of(21, 0)));
        horariosFinca1.add(new Horario(LocalDate.of(2025, 6, 8), LocalTime.of(9, 0), LocalTime.of(21, 0)));
        // Instanciar una finca cargando los datos solicitados y pasando por parametro la lista de horarios disponibles
        Finca finca1 = new Finca("Dominguez", "La Plata", 20000, horariosFinca1);
        System.out.println(finca1);
        System.out.println("Horarios Disponibles:");
        finca1.listar(finca1.getHorarioDisponibles());

        // Instanciar horarios disponibles de la finca y agregarlos a la lista de horarios
        List<Horario> horariosFinca2 = new ArrayList<>();
        horariosFinca2.add(new Horario(LocalDate.of(2025, 6, 9), LocalTime.of(13, 0), LocalTime.of(20, 0)));
        horariosFinca2.add(new Horario(LocalDate.of(2025, 6, 10), LocalTime.of(13, 0), LocalTime.of(20, 0)));
        horariosFinca2.add(new Horario(LocalDate.of(2025, 6, 11), LocalTime.of(13, 0), LocalTime.of(20, 0)));
        horariosFinca2.add(new Horario(LocalDate.of(2025, 6, 12), LocalTime.of(13, 0), LocalTime.of(20, 0)));
        horariosFinca2.add(new Horario(LocalDate.of(2025, 6, 13), LocalTime.of(13, 0), LocalTime.of(20, 0)));
        // Instanciar una finca cargando los datos solicitados y pasando por parámetro la lista de horarios disponibles
        Finca finca2 = new Finca("Cayetano", "Cordoba", 15000, horariosFinca2);
        System.out.println();
        System.out.println(finca2);
        System.out.println("Horarios Disponibles:");
        finca2.listar(finca2.getHorarioDisponibles());

        //### RESERVAS ###
        //Solicitamos la instancia del sistema de reservas que es static y le aplicamos el principio SINGLETON
        SistemaReservas sistema = SistemaReservas.getInstancia();
        //Instanciamos un cliente para empezar con las reservas
        Cliente cliente1 = new Cliente("Maria Rodriguez", "mrodriguez@email.com");
        //Instanciamos nuevas reservas de finca correspondiente cargando los datos brindados por el cliente
        Reserva nuevaReserva1 = new Reserva(finca1, cliente1, LocalDate.of(2025, 6, 7), LocalTime.of(9, 0), LocalTime.of(21, 0));
        Reserva nuevaReserva2 = new Reserva(finca1, cliente1, LocalDate.of(2025, 6, 8), LocalTime.of(9, 0), LocalTime.of(21, 0));
        //Registramos las nuevas reservas con las correspondientes validaciones de disponibilidad
        System.out.println("\n\n\n");
        if (sistema.registrarReserva(nuevaReserva1) && sistema.registrarReserva(nuevaReserva2)) {
            System.out.println("Las reservas se efectuaron correctamente.");
        } else {
            System.out.println("ERROR no se efectuaron las reservas.");
        }

        //Instanciamos un cliente para empezar con las reservas
        Cliente cliente2 = new Cliente("Esteban Quito", "equito@email.com");
        //Instanciamos nuevas reservas de finca correspondiente cargando los datos brindados por el cliente
        Reserva nuevaReserva3 = new Reserva(finca2, cliente2, LocalDate.of(2025, 6, 9), LocalTime.of(13, 0), LocalTime.of(20, 0));
        Reserva nuevaReserva4 = new Reserva(finca2, cliente2, LocalDate.of(2025, 6, 11), LocalTime.of(13, 0), LocalTime.of(20, 0));
        Reserva nuevaReserva5 = new Reserva(finca2, cliente2, LocalDate.of(2025, 6, 13), LocalTime.of(13, 0), LocalTime.of(20, 0));

        //Registramos las nuevas reservas con las correspondientes validaciones de disponibilidad
        if (sistema.registrarReserva(nuevaReserva3) && sistema.registrarReserva(nuevaReserva4) && sistema.registrarReserva(nuevaReserva5)) {
            System.out.println("Las reservas se efectuaron correctamente.");
        } else {
            System.out.println("ERROR no se efectuaron las reservas.");
        }

        Cliente cliente3 = new Cliente("Carlos Contreras", "ccontreras@email.com");
        Reserva nuevaReserva6 = new Reserva(finca2, cliente3, LocalDate.of(2025, 6, 13), LocalTime.of(13, 0), LocalTime.of(20, 0));

        //Registramos las nuevas reservas con las correspondientes validaciones de disponibilidad
        if (sistema.registrarReserva(nuevaReserva6)) {
            System.out.println("Las reservas se efectuaron correctamente.");
        } else {
            System.out.println("ERROR no se efectuaron las reservas.");
        }

        System.out.println("\n\n");

        System.out.println(" ### TODAS LAS RESERVAS ### ");
        sistema.listar(sistema.getReservas());
        System.out.println("\n\n");

        System.out.println(" ### RESERVAS POR FINCA ### ");
        System.out.println(finca1.getNombre());
        sistema.listar(sistema.obtenerReservasPorFinca(finca1));
        System.out.println();
        System.out.println(finca2.getNombre());
        sistema.listar(sistema.obtenerReservasPorFinca(finca2));

        System.out.println("\n\n");
        System.out.println(" ### HORARIOS DISPONIBLES POR FINCA ### ");
        System.out.println(finca2);
        System.out.println("Horarios Disponibles:");
        if (!finca1.listar(finca1.getHorarioDisponibles())){
            System.out.println("No hay horarios disponibles.\n");
        }
        System.out.println(finca2);
        System.out.println("Horarios Disponibles:");
        if (!finca2.listar(finca2.getHorarioDisponibles())){
            System.out.println("No hay horarios disponibles.");
        }
    }
}
