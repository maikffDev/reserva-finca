package ui;

import enums.DiaSemana;
import models.Finca;
import models.Horario;

import java.time.LocalTime;
import java.util.Scanner;

public class FincaConsole {
    Scanner scanner = new Scanner(System.in);

    public Finca registroFincaConsole() {
        System.out.print("ID de la finca: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre de la finca: ");
        String nombre = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Tarifa por hora: ");
        double tarifa = Double.parseDouble(scanner.nextLine());

        Finca finca = new Finca(id, nombre, ubicacion, tarifa);

        System.out.println("\nIngrese horarios disponibles:");
        boolean continuar = true;

        while (continuar) {
            System.out.print("Día de la semana (ej: LUNES): ");
            DiaSemana dia = DiaSemana.valueOf(scanner.nextLine().trim().toUpperCase());

            System.out.print("Hora de inicio (HH:mm): ");
            LocalTime inicio = LocalTime.parse(scanner.nextLine());

            System.out.print("Hora de fin (HH:mm): ");
            LocalTime fin = LocalTime.parse(scanner.nextLine());

            Horario horario = new Horario(dia, inicio, fin);
            finca.setHorariosDisponibles(new Horario(dia, inicio, fin));

            System.out.print("¿Agregar otro horario? (s/n): ");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }
        return finca;
    }
}
