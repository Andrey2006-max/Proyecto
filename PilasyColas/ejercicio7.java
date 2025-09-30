import java.util.*;

public class ejercicio7 {

    public static List<String> filtrarPalabras(List<String> palabras) {
        Queue<String> cola = new LinkedList<>();
        List<String> resultado = new ArrayList<>();

        // Encolar todas las palabras
        for (String palabra : palabras) {
            cola.offer(palabra);
        }

        // Desencolar y filtrar
        while (!cola.isEmpty()) {
            String actual = cola.poll(); // saca el primero
            if (actual.length() == 4) {
                resultado.add(actual);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(filtrarPalabras(Arrays.asList("Tomate", "Papa", "Par")));
        // [Papa]

        System.out.println(filtrarPalabras(Arrays.asList("Luz", "Casa", "Sol", "Lago")));
        // [Casa, Lago]

        System.out.println(filtrarPalabras(Arrays.asList("Azul", "Rojo", "Verde")));
        // [Azul, Rojo]
    }
}

