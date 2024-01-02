import java.util.HashMap;

public class CheckIfTwoStringsAreKAnagrams {
    public static void main(String[] args) {
        System.out.println("We will find if 2 strings are K Anagrams. ");
        String s1 = "aabbbcccc";
        String s2 = "abbbbccdd";
        int k = 3;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
        }
        for (char ch : map.keySet()) {
            count += map.getOrDefault(ch, 0);
        }

        if (count > k)
            System.out.println(false);
        else
            System.out.println(true);
    }
}
