package M6;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import M6.*;

public class Milestone03 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Vehiculo> vehiculos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Crear persona");
            System.out.println("2. Crear vehículo");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPersona(personas, scanner);
                    break;
                case 2:
                    crearVehiculo(personas, vehiculos, scanner);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearPersona(List<Persona> personas, Scanner scanner) {
        System.out.println("Ingresa el nombre de la persona:");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa los apellidos de la persona:");
        String apellidos = scanner.nextLine();

        System.out.println("Ingresa la fecha de nacimiento de la persona (yyyy-MM-dd):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("¿La persona es titular (T) o conductor (C)?");
        char tipoPersona = scanner.nextLine().charAt(0);

        boolean seguro = false;
        boolean garajePropio = false;

        if (tipoPersona == 'T' || tipoPersona == 't') {
            System.out.println("¿Tiene seguro el titular? (true/false):");
            seguro = scanner.nextBoolean();

            System.out.println("¿Tiene garaje propio el titular? (true/false):");
            garajePropio = scanner.nextBoolean();
        }

        Titular titular = null;
        Conductor conductor = null;

        if (tipoPersona == 'T' || tipoPersona == 't') {
            titular = new Titular(nombre, apellidos, fechaNacimiento, seguro, garajePropio);
            personas.add(titular);
        } else if (tipoPersona == 'C' || tipoPersona == 'c') {
            LicenciaConducir licencia = crearLicencia(scanner);
            conductor = new Conductor(nombre, apellidos, fechaNacimiento, licencia);
            personas.add(conductor);
        } else {
            System.out.println("Tipo de persona no reconocido.");
            return;
        }

        System.out.println("Persona creada exitosamente.");
    }

    private static LicenciaConducir crearLicencia(Scanner scanner) {
        int ID = 1;
        String tipo = "B";
        String nombreCompleto = "Nombre Apellido";
        LocalDate fechaCaducidad = LocalDate.now().plusYears(1);

        return new LicenciaConducir(ID, tipo, nombreCompleto, fechaCaducidad);
    }

    private static void crearVehiculo(List<Persona> personas, List<Vehiculo> vehiculos, Scanner scanner) {
        System.out.println("Ingresa la matrícula del vehículo:");
        String matricula = scanner.nextLine();

        System.out.println("Ingresa la marca del vehículo:");
        String marca = scanner.nextLine();

        System.out.println("Ingresa el color del vehículo:");
        String color = scanner.nextLine();

        System.out.println("Ingresa el ID del titular del vehículo:");
        int idTitular = scanner.nextInt();
        scanner.nextLine();

        Titular titular = null;
        for (Persona persona : personas) {
            if (persona instanceof Titular && persona.getID() == idTitular) {
                titular = (Titular) persona;
                break;
            }
        }

        if (titular == null) {
            System.out.println("Titular no encontrado.");
            return;
        }

        Vehiculo vehiculo = new Coche(matricula, marca, color);
        vehiculo.asignarTitular(titular);

        boolean agregarConductor = true;
        while (agregarConductor) {
            System.out.println("Ingresa el ID del conductor del vehículo (o -1 para finalizar):");
            int idConductor = scanner.nextInt();
            scanner.nextLine();

            if (idConductor == -1) {
                agregarConductor = false;
            } else {
                Conductor conductor = null;
                for (Persona persona : personas) {
                    if (persona instanceof Conductor && persona.getID() == idConductor) {
                        conductor = (Conductor) persona;
                        break;
                    }
                }

                if (conductor == null) {
                    System.out.println("Conductor no encontrado.");
                } else {
                    vehiculo.agregarConductor(conductor);
                    System.out.println("Conductor agregado al vehículo.");
                }
            }
        }

        vehiculos.add(vehiculo);
        System.out.println("Vehículo creado exitosamente.");
    }
}
