package M5;

public class Boss extends Employee {
    public Boss(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        if (salarioBase >= 8000) {
            return salarioBase;
        } else {
            throw new IllegalArgumentException("El salario del jefe debe ser mayor o igual a 8000€.");
        }
    }
}