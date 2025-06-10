public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "nombre: '" + nombre + '\'' +
                ", correo: '" + correo + '\'';
    }
}
