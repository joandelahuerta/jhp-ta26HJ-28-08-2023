package M6;
import java.util.Scanner;
import M6.*;

public class Milestone01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Crear un coche (1) o una moto (2):");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa la matr�cula:");
        String matricula = scanner.nextLine();

        System.out.println("Ingresa la marca:");
        String marca = scanner.nextLine();

        System.out.println("Ingresa el color:");
        String color = scanner.nextLine();

        Vehiculo vehiculo;
        if (tipoVehiculo == 1) {
            vehiculo = new Coche(matricula, marca, color);
        } else {
            vehiculo = new Moto(matricula, marca, color);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Ingresa la marca de la rueda trasera " + (i + 1) + ":");
            String marcaRueda = scanner.nextLine();

            System.out.println("Ingresa el di�metro de la rueda trasera " + (i + 1) + ":");
            double diametroRueda = scanner.nextDouble();
            scanner.nextLine();

            vehiculo.agregarRueda(i, marcaRueda, diametroRueda);
        }

        for (int i = 2; i < 4; i++) {
            System.out.println("Ingresa la marca de la rueda delantera " + (i - 1) + ":");
            String marcaRueda = scanner.nextLine();

            System.out.println("Ingresa el di�metro de la rueda delantera " + (i - 1) + ":");
            double diametroRueda = scanner.nextDouble();
            scanner.nextLine();

            vehiculo.agregarRueda(i, marcaRueda, diametroRueda);
        }

        if (vehiculo.tieneTodasLasRuedas()) {
            System.out.println("Veh�culo creado exitosamente con todas las ruedas.");
        } else {
            System.out.println("No se han agregado todas las ruedas al veh�culo.");
        }
    }
}
