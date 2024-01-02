import java.util.HashMap;
import java.util.Stack;

public class MaXFrequencyStack {
    public static int max = Integer.MIN_VALUE;
    private static HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>>();

    public static void main(String[] args) {
        System.out.println("Maximum frequency stack");
//        int max = Integer.MIN_VALUE;
        int[] arr = {2, 8, 3, 7, 4, 9, 6, 1, 4, 9, 3, 5, 7, 8, 2, 5, 4, 9, 6, 4, 7, 8, 5, 2, 6, 9, 4, 5, 9, 7, 5, 4, 3, 1, 0, 2, 5, 9, 4};

        FrequencyStack(freq, map, arr);
        System.out.println(freq.toString());
        System.out.println(map.toString());
        System.out.println(max);
        System.out.println(pop(freq, map));
        System.out.println(max);
        System.out.println(pop(freq, map));
        System.out.println(pop(freq, map));
        System.out.println(pop(freq, map));
        System.out.println(pop(freq, map));


    }

    public static void FrequencyStack(HashMap<Integer, Integer> freq, HashMap<Integer, Stack<Integer>> map, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            int fr = freq.get(val);
            max = Math.max(fr, max);
            map.put(fr, map.getOrDefault(fr, new Stack<>()));
            map.get(fr).push(val);
        }
//        return max;
    }

    public static int pop(HashMap<Integer, Integer> freq, HashMap<Integer, Stack<Integer>> map) {
        int num = map.get(max).pop();
        if (map.get(max).size() == 0) {
            map.remove(max);
            max--;
        }
        int fre = freq.get(num);
        fre--;
        freq.put(num, fre);
        return num;
    }

    public static void push(int num, HashMap<Integer, Integer> freq, HashMap<Integer, Stack<Integer>> map) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);

        int fre = freq.get(num);
        map.put(fre, map.getOrDefault(fre, new Stack<>()));
        map.get(fre).push(num);
    }


}
