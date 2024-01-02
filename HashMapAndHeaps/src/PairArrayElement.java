import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PairArrayElement {
    public static void main(String[] args) {
        System.out.println("Pair array elements");


        int[] myArr = {-8, -3, 8, 8, 4, -6, -4, 2, 0, 2, 1, 4, 0, 16, 8, 4};
        Integer[] ar = new Integer[myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            ar[i] = myArr[i];
        }
        if (ar.length == 0) System.out.println(false);
        Arrays.sort(ar, (a, b) ->
        {
            return Math.abs(a) - Math.abs(b);
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : ar
        ) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int el : ar) {
            if (map.get(el) == 0) continue;

            if (map.getOrDefault(2 * el, 0) == 0) {
                System.out.println(false);
                break;
            }

            map.put(el, map.get(el) - 1);
            map.put(2 * el, map.get(2 * el) - 1);

        }
        System.out.println(true);
    }
}
