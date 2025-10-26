package ui;

import java.util.Scanner;
import model.SchoolController;
import model.Computer;

public class SchoolApp {

    private Scanner input;
    private SchoolController controller;

    public static void main(String[] args) {
        SchoolApp ui = new SchoolApp();
        ui.menu();
    }

    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController();
    }

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            System.out.print("Opción: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    public void registrarComputador() {
        input.nextLine();

        System.out.println("\n--- Registrar Computador ---");
        System.out.print("Ingrese serial: ");
        String serial = input.nextLine();

        System.out.print("Ingrese piso (numero): ");
        int floor;
        try {
            floor = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Piso invalido. Se registra piso = 0 por defecto.");
            floor = 0;
        }

        System.out.print("Ingrese columna (numero): ");
        int column;
        try {
            column = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Columna invalida. Se registra columna = 0 por defecto.");
            column = 0;
        }

        controller.agregarComputador(serial, floor, column);
        System.out.println("Computador registrado correctamente.");
    }

    public void registrarIncidenteEnComputador() {
        input.nextLine();

        System.out.println("\n--- Registrar Incidente ---");
        System.out.print("Ingrese serial del computador: ");
        String serial = input.nextLine();

        System.out.print("Descripcion del incidente: ");
        String description = input.nextLine();

        controller.agregarIncidenteEnComputador(serial, description);
        System.out.println("Incidente registrado (si el serial existe).");
    }

    public void consultarComputadorConMasIncidentes() {
        System.out.println("\n--- Computador con más incidentes ---");

        Computer mayor = controller.getComputerWithMoreIncidents();

        if (mayor == null) {
            System.out.println("No hay computadores registrados aún.");
            return;
        }

        System.out.println("Serial: " + mayor.getSerialNumber());
        System.out.println("Piso: " + mayor.getFloor());
        System.out.println("Columna: " + mayor.getColumn());
        System.out.println("Incidentes: " + mayor.getTotalIncidents());
    }
}