import java.util.HashMap;

public class LongestSubstringWithoutRepeatChars {
    public static void main(String[] args) {
        System.out.println("We will find the longest substring without repeating chars");
        HashMap<Character, Integer> map = new HashMap<>();
        String s = "abcd";
        String ans = "";
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1) {
                i = i + 1;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                }
                String temp = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || ans.length() < temp.length()) {
                    ans = temp;
                }
                f1 = true;
            }

            while (j < i) {
                j = j + 1;
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
                f2 = true;

            }
            if (!f1 && !f2) {
                break;
            }

        }
        System.out.println(ans);

    }
}
