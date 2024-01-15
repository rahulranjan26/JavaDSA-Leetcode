package com.pepcoding.recursionlevel2;

import java.util.HashSet;
import java.util.Scanner;

public class WordKSelection1 {
    public static void main(String[] args) {
        System.out.println("You got a string. Choose unique K chars and use it to find all the combinations");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashSet<Character> set = new HashSet<>();
        StringBuilder unique = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                unique.append(str.charAt(i));
            }
        }

        String uni = unique.toString();
        findCombinationKWord(0, "", uni, 2, 0);
    }

    private static void findCombinationKWord(int cc, String asf, String uni, int k, int ts) {
        if (cc == uni.length()) {
            if (asf.length() == k) {
                System.out.println(asf);
            }
//            System.out.println();
            return;
        }

        char ch = uni.charAt(cc);
        findCombinationKWord(cc + 1, asf + ch, uni, k, ts + 1);
        findCombinationKWord(cc + 1, asf, uni, k, ts + 1);

    }


}



