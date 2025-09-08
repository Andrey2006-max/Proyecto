public class CasilleroManager {
    private Casillero[][] casilleros; // matriz de casilleros
    private int filas;
    private int columnas;

    // Constructor: crea la matriz de casilleros
    public CasilleroManager(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casilleros = new Casillero[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casilleros[i][j] = new Casillero(i, j); // inicializamos cada casillero vacío
            }
        }
    }

    // Registrar paquete en el primer casillero libre
    public String registrarPaquete(String destinatario, String descripcion) {
        Paquete p = new Paquete(destinatario, descripcion);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casilleros[i][j].estaOcupado()) {
                    casilleros[i][j].asignarPaquete(p);
                    return casilleros[i][j].getId(); // devolvemos dónde quedó
                }
            }
        }
        return null; // si estaba lleno
    }

    // Contar casilleros disponibles
    public int contarDisponibles() {
        int c = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casilleros[i][j].estaOcupado()) {
                    c++;
                }
            }
        }
        return c;
    }

    // Mostrar esquema visual de la matriz
    public void mostrarEsquema() {
        System.out.println("Esquema de casilleros: [ ] Libre | [X] Ocupado");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j].estaOcupado() ? "[X] " : "[ ] ");
            }
            System.out.print("   "); 
            // mostramos identificadores a la derecha
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

    // Buscar un casillero por su ID (ejemplo: "F1-C2")
    public Casillero buscarPorId(String id) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casilleros[i][j].getId().equals(id)) {
                    return casilleros[i][j];
                }
            }
        }
        return null;
    }

    // Buscar un casillero por destinatario
    public Casillero buscarPorDestinatario(String destinatario) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casilleros[i][j].estaOcupado()) {
                    Paquete p = casilleros[i][j].getPaquete();
                    if (p.getDestinatario().equalsIgnoreCase(destinatario)) {
                        return casilleros[i][j];
                    }
                }
            }
        }
        return null;
    }

    // Listar todos los casilleros (para pruebas)
    public void listarTodos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println(casilleros[i][j].toString());
                if (casilleros[i][j].estaOcupado()) {
                    System.out.println("  -> " + casilleros[i][j].getPaquete().toString());
                }
            }
        }
    }
}
