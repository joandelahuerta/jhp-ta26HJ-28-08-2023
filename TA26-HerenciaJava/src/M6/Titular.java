package M6;

import java.time.LocalDate;

public class Titular extends Persona {
    private boolean seguro;
    private boolean garajePropio;

    public Titular(String nombre, String apellidos, LocalDate fechaNacimiento, boolean seguro, boolean garajePropio) {
        super(nombre, apellidos, fechaNacimiento);
        this.seguro = seguro;
        this.garajePropio = garajePropio;
    }

    public boolean tieneSeguro() {
        return seguro;
    }

    public boolean tieneGarajePropio() {
        return garajePropio;
    }
}
