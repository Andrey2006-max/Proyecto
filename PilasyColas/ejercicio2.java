public class ejercicio2 {
   
    public static boolean panSimilar(String[] s1, String[] s2) {
        return s1[0].equals(s2[0]) && s1[s1.length - 1].equals(s2[s2.length - 1]);
    }

    public static void main(String[] args) {
        String[] sandwich1 = {"pan blanco", "lechuga", "pan blanco"};
        String[] sandwich2 = {"pan blanco", "tomate", "pan blanco"};
        System.out.println(panSimilar(sandwich1, sandwich2)); 

        String[] sandwich3 = {"pan integral", "queso", "pan integral"};
        String[] sandwich4 = {"pan blanco", "queso", "pan integral"};
        System.out.println(panSimilar(sandwich3, sandwich4)); 
    }
}

