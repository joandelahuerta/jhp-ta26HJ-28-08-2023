package M5;

public class Junior extends Employee {
    public Junior(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 0.85;
    }
}