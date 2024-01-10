package com.pepcoding.recursionlevel2;

import java.util.HashMap;
import java.util.Scanner;

public class PatternMatchingProblem {
    public static void main(String[] args) {
        System.out.println("Learn about pattern matching string");

        HashMap<Character, String> map = new HashMap<>();
        Scanner scn = new Scanner(System.in);
        String word = scn.next();
        String pattern = scn.next();
        findPattern(map, word, pattern);
    }

    private static void findPattern(HashMap<Character, String> map, String word, String pattern) {
        if (pattern.length() == 0) {
            if (word.length() == 0) {
                System.out.println(map);
            }
            return;
        }


        char ch = pattern.charAt(0);
        String ros = pattern.substring(1);
        if (map.containsKey(ch)) {
            String previousPatt = map.get(ch);
            if (word.length() > previousPatt.length()) {
                String left = word.substring(0, previousPatt.length());
                String right = word.substring(previousPatt.length());
                if (previousPatt.equals(left)) {
                    findPattern(map, right, ros);
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                String left = word.substring(0, i + 1);
                String right = word.substring(i + 1);
                map.put(ch, left);
                findPattern(map, right, ros);
                map.remove(ch);
            }
        }
    }
}
