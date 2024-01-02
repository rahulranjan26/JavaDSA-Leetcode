import java.util.HashMap;

public class SmallestSubstringOfAStringHavingAllCharsOfAnotherString {
    public static void main(String[] args) {
        System.out.println("We will find the smallest substring with all the chars of another string");
        String s1 = "dbaecbbdcaafbddcabgba";
        String s2 = "abbcdc";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int baseCount = s2.length();
        int runningCount = 0;
        int i = -1;
        int j = -1;
        String ans = "";
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s1.length() - 1 && runningCount < baseCount) {
                i = i + 1;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    runningCount = runningCount + 1;
                }
                f1 = true;
            }
            while (j < i && baseCount == runningCount) {
                String temp = s1.substring(j + 1, i + 1);
                if (ans.length() == 0 || temp.length() < ans.length()) {
                    ans = temp;
                }
                j = j + 1;
                char ch = s1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    runningCount = runningCount - 1;
                }
                f2 = true;
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        System.out.println(ans);
    }
}
