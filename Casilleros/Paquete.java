import java.text.SimpleDateFormat;
import java.util.Date;

public class Paquete {
    private String destinatario;
    private String descripcion;
    private String fechaIngreso; 

    public Paquete(String destinatario, String descripcion) {
        this.destinatario = destinatario;
        this.descripcion = descripcion;
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.fechaIngreso = f.format(new Date());
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return "Destinatario: " + destinatario + "\n" +
               "Descripcion: " + descripcion + "\n" +
               "Fecha de ingreso: " + fechaIngreso;
    }
}
