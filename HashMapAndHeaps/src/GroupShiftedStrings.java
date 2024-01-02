import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public static void main(String[] args) {
        System.out.println("We will learn about the shifted string");
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> strs = new ArrayList<>(List.of("acd", "dfg", "mop", "wyz", "yab", "a", "x", "bdfh", "moqs"));
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            String key = code(s);
            if (map.containsKey(key)) {
                ArrayList<String> ls = map.get(key);
                ls.add(s);
                map.put(key, ls);
            } else {
                ArrayList<String> ls = new ArrayList<>();
                ls.add(s);
                map.put(key, ls);
            }

        }
        for (String s : map.keySet()) {
            System.out.println(s + "-->" + map.get(s));
//            System.out.println(map);
        }

    }

    public static String code(String str) {
        String key = "";
        for (int i = 1; i < str.length(); i++) {
            char present = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = present - prev;
            if (diff < 0) {
                diff = diff + 26;
            }
            key += diff + "#";
        }
        if (key.length() > 0) {
            return key;
        }
        return "$";
    }
}
