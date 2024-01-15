package com.pepcoding.recursionlevel2;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationsOfString {
    public static void main(String[] args) {
        System.out.println("We will just do a permutation of string here");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        findPermutationsOfString(str, "", map, str.length());

    }

    private static void findPermutationsOfString(String str, String asf, HashMap<Character, Integer> map, int len) {
        if (asf.length() == len) {
            System.out.println(asf);
            return;
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                map.put(ch, map.get(ch) - 1);
                findPermutationsOfString(str, asf + ch, map, len);
                map.put(ch, map.get(ch) + 1);
            }
        }


    }
}
