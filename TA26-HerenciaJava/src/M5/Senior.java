package M5;

public class Senior extends Employee {
    public Senior(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 0.95;
    }
}