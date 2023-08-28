package M5;
import java.util.Scanner;
import M5.*;

public class Milestone01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el tipo de empleado (Boss/Manager/Employee/Volunteer): ");
        String tipo = scanner.nextLine();

        double salarioBase = 0;

        try {
            System.out.print("Ingresa el salario base: ");
            salarioBase = scanner.nextDouble();
            
            if (salarioBase < 0) {
                throw new IllegalArgumentException("El salario no puede ser negativo.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada inválida: " + e.getMessage());
            return;
        }

        Employee empleado;

        switch (tipo) {
            case "Boss":
                empleado = new Boss(nombre, salarioBase);
                break;
            case "Manager":
                empleado = new Manager(nombre, salarioBase);
                break;
            case "Employee":
                empleado = new Employee(nombre, salarioBase);
                break;
            case "Volunteer":
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
