import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;

public class CountOfEquivalentSubarray {
    public static void main(String[] args) {
        System.out.println("We will learn about the count of sub-arrays that are equivalent in nature");
        //Equivalent Sub-arrays : Number of unique elements in array is equal to that of in each subarray
        String str = "abcd";
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            set.add(ch);
        }
        int K = set.size();

        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < str.length() - 1) {
                i = i + 1;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == K) {
                    count += str.length() - i;
                    break;
                }
                f1 = true;

            }

            while (j < i) {
                j = j + 1;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
                if (map.size() < K) {
                    break;
                } else if (map.size() == K) {
                    count += str.length() - i;
                }
                f2 = true;
            }

            if (!f1 && !f2)
                break;
        }
        System.out.println(count);

    }
}
