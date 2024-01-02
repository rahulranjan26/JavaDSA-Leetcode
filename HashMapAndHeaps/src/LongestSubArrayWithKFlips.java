import java.util.HashMap;

public class LongestSubArrayWithKFlips {
    public static void main(String[] args) {
        System.out.println("We will learn about longest substring that can be created by flipping K 0s");
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int K = 2;
        String str = "11010110111";
        String res = "";
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < str.length() - 1) {
                i = i + 1;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.getOrDefault('0', 0) == K) {
                    String temp = str.substring(j + 1, i + 1);
                    if (res.length() == 0 || temp.length() > res.length()) {
                        res = temp;
                        ans = i - j;
                    }
                }
                if (map.getOrDefault('0', 0) > K) {
                    break;
                }
                f1 = true;
            }
            while (j < i) {
                j = j + 1;
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.getOrDefault('0', 0) <= K) {
                    break;
                }
                f2 = true;
            }
            if (!f1 && !f2) {
                break;
            }

        }
        System.out.println(res + "  " + ans);

    }
}

