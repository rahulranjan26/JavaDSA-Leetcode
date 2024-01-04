package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class PrintAbbreviation {
    public static void main(String[] args) {
        System.out.println("We will print abbreviation for a word in this problem");
        Scanner scn = new Scanner(System.in);
        String word = scn.next();
        findAbb(word, "", 0, 0);

    }

    private static void findAbb(String word, String ssf, int idx, int count) {
        if (idx == word.length()) {
            if (count == 0) {
                System.out.println(ssf);
            } else {
                System.out.println(ssf + count);
            }
            return;
        }

        if (count > 0) {
            findAbb(word, ssf + count + word.charAt(idx), idx + 1, 0);
        } else {
            findAbb(word, ssf + word.charAt(idx), idx + 1, 0);
        }
        findAbb(word, ssf, idx + 1, count + 1);
    }
}
