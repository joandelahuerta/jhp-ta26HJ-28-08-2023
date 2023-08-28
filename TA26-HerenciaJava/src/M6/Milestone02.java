package M6;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import M6.*;

public class Milestone02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Crear un coche (1), una moto (2) o un camión (3):");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa el nombre del titular:");
        String nombreTitular = scanner.nextLine();

        System.out.println("Ingresa los apellidos del titular:");
        String apellidosTitular = scanner.nextLine();

        System.out.println("Ingresa la fecha de nacimiento del titular (yyyy-MM-dd):");
        LocalDate fechaNacimientoTitular = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("¿Tiene seguro el titular? (true/false):");
        boolean seguro = scanner.nextBoolean();

        System.out.println("¿Tiene garaje propio el titular? (true/false):");
        boolean garajePropio = scanner.nextBoolean();

        Titular titular = new Titular(nombreTitular, apellidosTitular, fechaNacimientoTitular, seguro, garajePropio);

        System.out.println("¿El titular también será el conductor? (true/false):");
        boolean mismoConductor = scanner.nextBoolean();
        scanner.nextLine();

        Conductor conductor;
        if (mismoConductor) {
            conductor = new Conductor(nombreTitular, apellidosTitular, fechaNacimientoTitular, null);
        } else {
            System.out.println("Ingresa el nombre del conductor:");
            String nombreConductor = scanner.nextLine();

            System.out.println("Ingresa los apellidos del conductor:");
            String apellidosConductor = scanner.nextLine();

            System.out.println("Ingresa la fecha de nacimiento del conductor (yyyy-MM-dd):");
            LocalDate fechaNacimientoConductor = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            LicenciaConducir licencia = new LicenciaConducir(1, "B", nombreConductor + " " + apellidosConductor, LocalDate.now().plusYears(1));
            conductor = new Conductor(nombreConductor, apellidosConductor, fechaNacimientoConductor, licencia);
        }

        Vehiculo vehiculo;
        if (tipoVehiculo == 1) {
            vehiculo = new Coche("1234ABC", "MarcaCoche", "Rojo");
        } else {
            vehiculo = new Moto("5678DEF", "MarcaMoto", "Azul");
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Ingresa la marca de la rueda trasera " + (i + 1) + ":");
            String marcaRueda = scanner.nextLine();

            System.out.println("Ingresa el diámetro de la rueda trasera " + (i + 1) + ":");
            double diametroRueda = scanner.nextDouble();
            scanner.nextLine();

            vehiculo.agregarRueda(i, marcaRueda, diametroRueda);
        }

        for (int i = 2; i < 4; i++) {
            System.out.println("Ingresa la marca de la rueda delantera " + (i - 1) + ":");
            String marcaRueda = scanner.nextLine();

            System.out.println("Ingresa el diámetro de la rueda delantera " + (i - 1) + ":");
            double diametroRueda = scanner.nextDouble();
            scanner.nextLine();

            vehiculo.agregarRueda(i, marcaRueda, diametroRueda);
        }

        if (!vehiculo.tieneTodasLasRuedas()) {
            System.out.println("No se han agregado todas las ruedas al vehículo.");
            return;
        }

        if (conductor.puedeConducir(vehiculo)) {
            System.out.println("El conductor puede conducir el vehículo.");
        } else {
            System.out.println("El conductor no puede conducir el vehículo.");
        }
    }

}
