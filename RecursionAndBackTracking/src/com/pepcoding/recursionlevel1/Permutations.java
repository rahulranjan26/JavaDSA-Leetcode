package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        System.out.println("Find the permutations of strings");
        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        findPermutations(str, "");
    }

    private static void findPermutations(String str, String s) {
        if (str.length() == 0) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            String ros = left + right;
            findPermutations(ros, s + ch);
        }
    }
}
