import java.util.LinkedList;
import java.util.Queue;

public class ejercicio4 {
    public static String formatearTelefono(int[] numeros) {
        if (numeros.length != 10) {
            return "Error: se necesitan 10 dígitos";
        }

        Queue<Integer> cola = new LinkedList<>();
        for (int n : numeros) {
            cola.add(n);
        }

        String numero = "(";
        for (int i = 0; i < 3; i++) {
            numero += cola.poll();
        }
        numero += ") ";
        for (int i = 0; i < 3; i++) {
            numero += cola.poll();
        }
        numero += "-";
        for (int i = 0; i < 4; i++) {
            numero += cola.poll();
        }

        return numero;
    }

    public static void main(String[] args) {
        int[] tel1 = {1,2,3,4,5,6,7,8,9,0};
        int[] tel2 = {3,0,0,1,2,3,4,5,6,7};

        System.out.println(formatearTelefono(tel1)); 
        System.out.println(formatearTelefono(tel2));  
    }
}