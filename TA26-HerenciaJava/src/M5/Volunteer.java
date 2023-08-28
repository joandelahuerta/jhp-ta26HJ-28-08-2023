package M5;

public class Volunteer extends Employee {
    public Volunteer(String nombre) {
        super(nombre, 0);
    }

    @Override
    public double calcularSalario() {
        if (salarioBase != 0) {
            throw new IllegalArgumentException("Los voluntarios no deben ser remunerados.");
        }
        return 0;
    }
}