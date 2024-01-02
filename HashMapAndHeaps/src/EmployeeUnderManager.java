import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeUnderManager {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < n; i++) {
            map.put(scn.next(), scn.next());
        }

        HashMap<String, Integer> result = findCount(map);
        for (String key : result.keySet()) {
//            System.out.println(key + "-->" + ValueToString(result.get(key)));
            System.out.println(key + "-->" + result.get(key));
        }

//        for (String el : map.keySet()) {
//            System.out.println(el + "--->" + map.get(el));
//        }

    }

    public static String ValueToString(HashSet<String> vals) {
        StringBuilder results = new StringBuilder();
        results.append("[");
        for (String val : vals) {
            results.append(val).append(" ");
        }
        results.append("]");
        return results.toString();
    }

    private static HashMap<String, Integer> findCount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<String, HashSet<String>>();
        String ceo = "";

        for (String emp : map.keySet()) {
            String manager = map.get(emp);

            if (manager.equals(emp)) {
                ceo = manager;
            } else {
                if (tree.containsKey(manager)) {
                    HashSet<String> emps = tree.get(manager);
                    emps.add(emp);
                } else {
                    HashSet<String> emps = new HashSet<String>();
                    emps.add(emp);
                    tree.put(manager, emps);
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        getSize(tree, ceo, result);
        return result;

    }

    private static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result) {
        if (!tree.containsKey(man)) {
            result.put(man, 0);
            return 1;
        }

        int sz = 0;
        for (String child : tree.get(man)) {
            int cs = getSize(tree, child, result);
            sz += cs;
        }
        result.put(man, sz);

        return sz + 1;
    }
}
