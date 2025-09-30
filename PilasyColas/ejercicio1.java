import java.util.LinkedList;
import java.util.Queue;

public class ejercicio1 {

    public static int votos(int upvotes, int downvotes) {
        Queue<Integer> cola = new LinkedList<>();

       
        for (int i = 0; i < upvotes; i++) {
            cola.add(1);
        }

        for (int i = 0; i < downvotes; i++) {
            cola.add(-1);
        }

        int resultado = 0;
        while (!cola.isEmpty()) {
            resultado += cola.poll(); 
        }

        return resultado;
    }

    public static void main(String[] args) {
  
        System.out.println(votos(13, 0));   
        System.out.println(votos(2, 33));    
        System.out.println(votos(132, 132));   
    }
}