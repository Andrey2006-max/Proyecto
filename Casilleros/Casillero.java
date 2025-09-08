public class Casillero {
    private int fila;
    private int columna;    
    private Paquete paquete;
    

    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.paquete = null; // null = vacío
    }

    
    public boolean estaOcupado() {
        return paquete != null;
    }

   
    public void asignarPaquete(Paquete p) {
        this.paquete = p;
    }

    
    public Paquete liberarPaquete() {
        Paquete temp = paquete;
        paquete = null; // se libera
        return temp;
    }

   
    public Paquete getPaquete() {
        return paquete;
    }

  
    public String getId() {
        return "F" + (fila + 1) + "-C" + (columna + 1);
    }

  
    @Override
    public String toString() {
        return getId() + (estaOcupado() ? " [Ocupado]" : " [Libre]");
    }
} 

