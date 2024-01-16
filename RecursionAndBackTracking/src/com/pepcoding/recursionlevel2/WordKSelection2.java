package com.pepcoding.recursionlevel2;

import java.util.HashSet;
import java.util.Scanner;

public class WordKSelection2 {
    public static void main(String[] args) {
        System.out.println("We will just do the same question again but with different optics");

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        HashSet<Character> set = new HashSet<>();
        StringBuilder unique = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                unique.append(str.charAt(i));
            }
        }

        String uni = unique.toString();
        findCombinationKWord2(0, k, "", -1, uni);
    }

    private static void findCombinationKWord2(int cs, int ts, String asf, int lcd, String uniq) {
        if (cs == ts) {
            System.out.println(asf);
            return;
        }

        for (int i = lcd + 1; i < uniq.length(); i++) {
            char ch = uniq.charAt(i);
            findCombinationKWord2(cs + 1, ts, asf + ch, i, uniq);

        }


    }
}
