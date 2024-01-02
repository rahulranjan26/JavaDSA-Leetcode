import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class SmallestSubstringOfAStringHavingAllUniqueCharsOfAnotherString {
    public static void main(String[] args) {
        System.out.println("We will find the smallest substring which has all the unique chars of another string");

        String s1 = "bbacacdcbbcaadcdca";
        String s2 = "abcd";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            set.add(ch);
        }
        String ans = "";
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s1.length() - 1 ) {
                i = i + 1;
                char ch = s1.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == set.size())
                    break;
                f1 = true;
            }
            while (j < i ) {

                String temp = s1.substring(j + 1, i + 1);
                if (ans.length() == 0 || temp.length() < ans.length()) {
                    ans = temp;
                }

                j = j + 1;
                char ch = s1.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
                if (map.size() < set.size())
                    break;
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }
        System.out.println(ans);


    }
}
