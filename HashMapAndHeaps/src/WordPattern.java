import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println("We will work on solving and mapping the pattern");
        String s = "the pep pep coding the the";
        String[] strs = s.split(" ");
        String t = "abbcal";
        HashMap<Character, String> s2t = new HashMap<>();
        HashMap<String, Character> t2s = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            String ss = strs[i];
            if (s2t.containsKey(ct) && !s2t.get(ct).equals(ss)) {
                System.out.println(false);
                return;
            }
            if (t2s.containsKey(ss) && !t2s.get(ss).equals(ct)) {
                System.out.println(false);
                return;
            }
            t2s.put(ss, ct);
            s2t.put(ct, ss);
        }
        System.out.println(true);

    }
}
