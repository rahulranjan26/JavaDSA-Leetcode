import java.util.HashMap;

public class FindAllTheAnagramicSubstringWithGivenString {
    public static void main(String[] args) {
        System.out.println("Given two string: S1,S2. Find the anagrams of S2 in S1");
        HashMap<Character, Integer> base = new HashMap<>();
        HashMap<Character, Integer> process = new HashMap<>();

        String s1 = "abcbcabac";
        String s2 = "abc";
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            base.put(ch, base.getOrDefault(ch, 0) + 1);
            process.put(s1.charAt(i), process.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int i = s2.length();
        int res = 0;
        String ans = "";
        boolean comparison = compareMaps(base, process);
        if (comparison) {
            res += 1;
            ans = i - s2.length() + " ";
        }
        while (i < s1.length()) {
            int j = i - s2.length();
            char start = s1.charAt(j);
            char end = s1.charAt(i);
            if (process.getOrDefault(start, 0) == 1) {
                process.remove(start);
            } else {
                process.put(start, process.getOrDefault(start, 0) - 1);
            }
            process.put(end, process.getOrDefault(end, 0) + 1);
            boolean comp = compareMaps(base, process);
            if (comp) {
                res += 1;
                ans += i  + " ";
            }
            i = i + 1;
        }

        System.out.println(res + "  " + ans);
    }

    private static boolean compareMaps(HashMap<Character, Integer> base, HashMap<Character, Integer> process) {
        for (char ch : base.keySet()) {
            if (process.get(ch) != base.getOrDefault(ch, 0)) {
                return false;
            }
        }
        return true;
    }
}
