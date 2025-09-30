import java.util.*;

public class ejercicio8 {
    public static int guerraNumeros(int[] numeros) {
        Queue<Integer> cola = new LinkedList<>();
        for (int n : numeros) {
            cola.add(n);
        }

        int sumaPares = 0;
        int sumaImpares = 0;

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual % 2 == 0) {
                sumaPares += actual;
            } else {
                sumaImpares += actual;
            }
        }

        return Math.abs(sumaImpares - sumaPares);
    }

    public static void main(String[] args) {
        System.out.println(guerraNumeros(new int[]{2, 8, 7, 5}));   
        System.out.println(guerraNumeros(new int[]{1, 3, 5, 9}));   
        System.out.println(guerraNumeros(new int[]{2, 4, 6, 8}));   
    }
}
