import java.util.*;

public class ejercicio6 {
    public static String crearSociedad(String[] nombres) {
        Queue<String> cola = new LinkedList<>();
        for (String nombre : nombres) {
            cola.add(nombre);
        }

        List<String> letras = new ArrayList<>();

        while (!cola.isEmpty()) {
            String letra = cola.poll().substring(0, 1).toUpperCase();
            letras.add(letra);
        }

        Collections.sort(letras);

        String resultado = "";
        for (String l : letras) {
            resultado += l;
        }

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(crearSociedad(new String[]{"Adam", "Sarah", "Malcolm"})); 
        System.out.println(crearSociedad(new String[]{"bruce", "clark", "diana"}));  
        System.out.println(crearSociedad(new String[]{"Zoe", "anna", "leo"}));       
    }
}
