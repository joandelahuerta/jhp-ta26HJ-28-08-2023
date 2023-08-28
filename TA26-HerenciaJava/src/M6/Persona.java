package M6;

import java.time.LocalDate;

public class Persona {
    private static int contadorIDs = 0;

    protected int ID;
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.ID = ++contadorIDs;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getID() {
        return ID;
    }

    public String obtenerNombreCompleto() {
        return nombre + " " + apellidos;
    }
}