import java.util.HashMap;

public class LongestSubStringWithKUniqueChars {
    public static void main(String[] args) {
        System.out.println("We will learn about the longest substring with K unique chars");
        String s = "abcdefghijklmnopqrstuvwxyz";
        String ans = "";
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int K = 15;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1) {
                i = i + 1;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() > K) {
                    break;
                }
                if (len == 0 || len < i - j) {
                    len = i - j;
                    ans = s.substring(j + 1, i + 1);
                }
                f1 = true;
            }
            while (j < i) {
                j = j + 1;
                char ch = s.charAt(j);

                if (map.getOrDefault(ch, 0) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
                if (map.size() < K) {
                    break;
                }
                f2 = true;
            }
            if (!f1 && !f2) {
                break;
            }

        }
        System.out.println(len + "  " + ans);
    }
}
