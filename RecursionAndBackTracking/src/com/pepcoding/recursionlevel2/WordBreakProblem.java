package com.pepcoding.recursionlevel2;

import java.util.HashSet;
import java.util.Scanner;

public class WordBreakProblem {

    public static void main(String[] args) {
        System.out.println("Learn about Word Break Problem");
        Scanner scn = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(scn.next());
        }

        String str = scn.next();
        findPattern(set, str, "");
    }

    private static void findPattern(HashSet<String> set, String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf.substring(0, asf.length() - 1));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (set.contains(left)) {
                String right = str.substring(i + 1);
                findPattern(set, right, asf + left + "-");
            }
        }


    }

}
