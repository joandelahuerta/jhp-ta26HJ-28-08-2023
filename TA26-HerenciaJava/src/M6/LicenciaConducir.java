package M6;

import java.time.LocalDate;

public class LicenciaConducir {
    private int ID;
    private String tipo;
    private String nombreCompleto;
    private LocalDate fechaCaducidad;

    public LicenciaConducir(int ID, String tipo, String nombreCompleto, LocalDate fechaCaducidad) {
        this.ID = ID;
        this.tipo = tipo;
        this.nombreCompleto = nombreCompleto;
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean esValida() {
        return LocalDate.now().isBefore(fechaCaducidad);
    }
    public String obtenerTipo() {
        return tipo;
    }
}
