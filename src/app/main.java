package app;

import models.Finca;
import ui.FincaConsole;

public class main {
    public static void main(String[] args) {
        FincaConsole consola = new FincaConsole();
        Finca finca = consola.registroFincaConsole();

        System.out.println(finca.toString());
    }
}
