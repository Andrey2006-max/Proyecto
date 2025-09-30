import java.util.Stack;

public class ejercicio3 {
    
    public static boolean compararRaices(int a, int b) {
        Stack<Double> pila = new Stack<>();

        pila.push((double) a);
        pila.push((double) b);

      
        double valorB = pila.pop();
        double valorA = pila.pop();

       
        double raizA = Math.sqrt(valorA);
        double raizB = Math.sqrt(valorB);

       
        double tolerancia = 1e-6;
        return Math.abs(raizA - 3 * raizB) < tolerancia;
    }

    public static void main(String[] args) {
        System.out.println(compararRaices(4, 8));   // true
        System.out.println(compararRaices(16, 48)); // false
        System.out.println(compararRaices(9, 27));  // true
    }
}

