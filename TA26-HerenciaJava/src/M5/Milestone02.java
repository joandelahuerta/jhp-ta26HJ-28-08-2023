package M5;
import java.util.Scanner;
import M5.*;

public class Milestone02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el tipo de empleado (Boss/Manager/Employee/Volunteer): ");
        String tipo = scanner.nextLine();

        double salarioBase = 0;

        try {
            System.out.print("Ingresa el salario base mensual: ");
            salarioBase = scanner.nextDouble();

            if (salarioBase < 0) {
                throw new IllegalArgumentException("El salario no puede ser negativo.");
            }

            if (tipo.equalsIgnoreCase("Boss") && salarioBase < 8000) {
                throw new IllegalArgumentException("El salario del jefe debe ser mayor o igual a 8000€.");
            } else if (tipo.equalsIgnoreCase("Manager") && (salarioBase < 3000 || salarioBase > 5000)) {
                throw new IllegalArgumentException("El salario del manager debe estar entre 3000€ y 5000€.");
            } else if (tipo.equalsIgnoreCase("Volunteer") && salarioBase != 0) {
                throw new IllegalArgumentException("Los voluntarios no deben ser remunerados.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada inválida: " + e.getMessage());
            return;
        }

        Employee empleado = null;

        switch (tipo.toLowerCase()) {
            case "boss":
                empleado = new Boss(nombre, salarioBase);
                break;
            case "manager":
                empleado = new Manager(nombre, salarioBase);
                break;
            case "employee":
                empleado = new Employee(nombre, salarioBase);
                break;
            case "volunteer":
                empleado = new Volunteer(nombre);
                break;
            default:
                System.out.println("Tipo de empleado inválido.");
                return;
        }

        double salarioFinal = empleado.calcularSalario();

        System.out.println("El salario de " + empleado.getNombre() + " es: " + salarioFinal);

    }

}
