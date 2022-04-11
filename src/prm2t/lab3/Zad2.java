package prm2t.lab3;
import java.lang.reflect.Array;
import java.util.*;

public class Zad2 {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String text = scanner.nextLine();
        text = text.toLowerCase(Locale.ROOT);
        String[] ar = text.split("");

        for (int i = ar.length-1; i>=0; i--) {
            char c = ar[i].charAt(0);
            int v = map.getOrDefault(c, 0);
            map.put(c, v+1);
        }
        System.out.println(map);
        System.out.println(map.keySet().size() + " rozne znaki");
        int N = 2;

        List keys = new ArrayList(map.keySet());
        Collections.sort(keys);
        System.out.println("Najmniejsze znaki:");
        for(int i = 0; i<N; i++){
            System.out.println(keys.get(i));
        }

        System.out.println("Najwieksze znaki:");
        for(int i = N; i>0; i--){
            System.out.println(keys.get(i));
        }

    }
}
