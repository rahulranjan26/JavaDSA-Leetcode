package com.pepcoding.recursionlevel2;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationOfStringWithRepetation {
    public static void main(String[] args) {
        System.out.println("We will write a program to print a permutation for this repeating string");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int len = str.length();
        printPermutations(map, len, "");
    }

    private static void printPermutations(HashMap<Character, Integer> map, int len, String ssf) {
        if (ssf.length() == len) {
            System.out.println(ssf);
            return;
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                printPermutations(map, len, ssf + ch);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }
}
