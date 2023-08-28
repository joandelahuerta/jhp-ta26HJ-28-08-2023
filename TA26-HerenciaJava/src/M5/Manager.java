package M5;

public class Manager extends Employee {
    public Manager(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        if (salarioBase > 3000 && salarioBase < 5000) {
            return salarioBase * 1.10;
        } else {
            throw new IllegalArgumentException("El salario del manager debe ser mayor a 3000€ y menor a 5000€.");
        }
    }
}