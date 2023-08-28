package M6;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String color;
    private Rueda[] ruedas;
    private Titular titular;
    private List<Conductor> conductores;

    public Vehiculo(String matricula, String marca, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
        this.ruedas = new Rueda[4];
        this.titular = null;
        this.conductores = new ArrayList<>();
    }

    public void agregarRueda(int posicion, String marca, double diametro) {
        if (posicion >= 0 && posicion < ruedas.length) {
            ruedas[posicion] = new Rueda(marca, diametro);
        }
    }

    public boolean tieneTodasLasRuedas() {
        for (Rueda rueda : ruedas) {
            if (rueda == null) {
                return false;
            }
        }
        return true;
    }
    public String obtenerTipoLicencia() {
        return "B";
    }

    public void asignarTitular(Titular titular) {
        this.titular = titular;
    }
	public void agregarConductor(Conductor conductor) {
        conductores.add(conductor);
    }
}
