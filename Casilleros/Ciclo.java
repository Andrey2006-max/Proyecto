import java.util.Scanner;

public class Ciclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        CasilleroManager manager = new CasilleroManager(4, 5);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.println("\n=== Registrar Paquete ===");
                    System.out.print("Destinatario: ");
                    String dest = sc.nextLine().trim();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine().trim();

                    String ubicacion = manager.registrarPaquete(dest, desc);
                    if (ubicacion != null) {
                        System.out.println(" Paquete registrado en " + ubicacion);
                    } else {
                        System.out.println(" No hay casilleros disponibles.");
                    }
                    break;

                case "2":
                    System.out.println("\n=== Casilleros Disponibles ===");
                    int disponibles = manager.contarDisponibles();
                    System.out.println("Casilleros libres: " + disponibles);
                    manager.mostrarEsquema();
                    break;

                case "3":
                    System.out.println("\n=== Consultar Paquete ===");
                    System.out.println("Buscar por: ");
                    System.out.println("1. ID de Casillero (ej: F1-C3)");
                    System.out.println("2. Destinatario");
                    System.out.print("Elija opción: ");
                    String sub = sc.nextLine().trim();

                    if (sub.equals("1")) {
                        System.out.print("Ingrese ID: ");
                        String id = sc.nextLine().trim().toUpperCase();
                        Casillero c = manager.buscarPorId(id);
                        if (c == null) {
                            System.out.println(" Casillero no encontrado.");
                        } else if (!c.estaOcupado()) {
                            System.out.println(" El casillero " + id + " está libre.");
                        } else {
                            System.out.println(" Información del paquete:");
                            System.out.println(c.getPaquete());
                        }
                    } else if (sub.equals("2")) {
                        System.out.print("Ingrese destinatario: ");
                        String nombre = sc.nextLine().trim();
                        Casillero c = manager.buscarPorDestinatario(nombre);
                        if (c == null) {
                            System.out.println(" No se encontró paquete para " + nombre);
                        } else {
                            System.out.println(" Paquete de " + nombre + " está en " + c.getId());
                            System.out.println(c.getPaquete());
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case "4":
                    System.out.println("\n Cerrando aplicación...");
                    salir = true;
                    break;

                default:
                    System.out.println(" Opción inválida. Intente de nuevo.");
            }

            System.out.println(); 
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=====  Sistema Casilleros Amazon =====");
        System.out.println("1. Registrar paquete");
        System.out.println("2. Consultar casilleros disponibles");
        System.out.println("3. Buscar información de un paquete");
        System.out.println("4. Salir");
        System.out.print("Seleccione opción: ");
    }
}
