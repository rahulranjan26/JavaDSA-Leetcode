import java.util.HashMap;

public class CountOfSubstringWithNoRepeatingChars {
    public static void main(String[] args) {
        System.out.println("We will study about count of all substring with no repeating chars");
        HashMap<Character, Integer> map = new HashMap<>();
        String s = "abcd";
        int ans = 0;
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
                ans = ans + i - j;
//                System.out.println(temp);
//                if (ans.length() == 0 || ans.length() < temp.length()) {
//                    ans = temp;
//                }
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
