package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        System.out.println("We will learn about partitioning the string which are palindrom");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        findPartition(str, "");
    }

    private static void findPartition(String str, String asf) {
        if (str.isEmpty()) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindromic(sub)) {
                findPartition(ros, asf + "(" + sub + ")");
            }
        }
    }

    private static boolean isPalindromic(String sub) {
        int st = 0;
        int en = sub.length() - 1;
        while (st < en) {
            if (sub.charAt(st) != sub.charAt(en))
                return false;
            st++;
            en--;
        }
        return true;

    }
}
