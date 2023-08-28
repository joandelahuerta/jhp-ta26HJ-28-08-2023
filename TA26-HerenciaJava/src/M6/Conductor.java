package M6;

import java.time.LocalDate;

public class Conductor extends Persona {
    private LicenciaConducir licencia;

    public Conductor(String nombre, String apellidos, LocalDate fechaNacimiento, LicenciaConducir licencia) {
        super(nombre, apellidos, fechaNacimiento);
        this.licencia = licencia;
    }

    public boolean puedeConducir(Vehiculo vehiculo) {
        return licencia.obtenerTipo().equals(vehiculo.obtenerTipoLicencia()) && licencia.esValida();
    }
}
