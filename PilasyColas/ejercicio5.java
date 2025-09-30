import java.util.LinkedList;
import java.util.Queue;
public class ejercicio5 {
    public static int segundoMayor(int[] numeros) {
        Queue<Integer> cola = new LinkedList<>();
        for (int n : numeros) {
            cola.add(n);
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual > max1) {
                max2 = max1;
                max1 = actual;
            } else if (actual > max2 && actual != max1) {
                max2 = actual;
            }
        }

        return max2;
    }

    public static void main(String[] args) {
        System.out.println(segundoMayor(new int[]{10, 40, 30, 20, 50})); 
        System.out.println(segundoMayor(new int[]{5, 5, 5, 5, 9}));      
        System.out.println(segundoMayor(new int[]{-3, -1, -7, -2}));     
    }
}