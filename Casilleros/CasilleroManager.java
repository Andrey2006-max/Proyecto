public class CasilleroManager {
    private Casillero[][] casilleros; 
    private int filas;
    private int columnas;

    
    public CasilleroManager(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casilleros = new Casillero[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casilleros[i][j] = new Casillero(i, j); 
            }
        }
    }

    
    public String registrarPaquete(String destinatario, String descripcion) {
        Paquete p = new Paquete(destinatario, descripcion);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casilleros[i][j].estaOcupado()) {
                    casilleros[i][j].asignarPaquete(p);
                    return casilleros[i][j].getId(); 
                }
            }
        }
        return null; 
    }

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

    
    public void mostrarEsquema() {
        System.out.println("Esquema de casilleros: [ ] Libre | [X] Ocupado");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j].estaOcupado() ? "[X] " : "[ ] ");
            }
            System.out.print("   "); 
          
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

    
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
