package M5;

public class Mid extends Employee {
    public Mid(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 0.90;
    }
}