package M5;

public class Employee {
    protected String nombre;
    protected double salarioBase;

    public Employee(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
}