import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println("Two Strings r isomorphic if there is one to one mapping for each of its chars");
        String s = "boa";
        String t = "cac";

        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (s2t.containsKey(cs) && s2t.get(cs) != ct) {
                System.out.println(false);
                return;
            }
            if (t2s.containsKey(ct) && t2s.get(ct) != cs) {
                System.out.println(false);
                return;
            }
            s2t.put(cs, ct);
            t2s.put(ct, cs);
        }
        System.out.println(true);
        return;
    }
}
