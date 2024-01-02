import java.util.ArrayList;
import java.util.HashMap;

public class FindAnagramMapping {
    public static class Pair {
        int idx = 0;
        ArrayList<Integer> arr = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("We will find the anagram mapping of two strings/arrays");
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Pair> map = new HashMap<>();
        String s1 = "aabbccdd";
        String s2 = "adcbbdca";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (map.containsKey(ch)) {
                Pair p = map.get(ch);
                p.arr.add(i);
                map.put(ch, p);
            } else {
                Pair p = new Pair();
                p.arr.add(i);
                map.put(ch, p);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            Pair p = map.get(ch);
            ans.add(p.arr.get(p.idx));
            p.idx = p.idx + 1;
        }
        System.out.println(ans.toString());
    }
}
