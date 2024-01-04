package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class LexicographicalPrinting {
    public static void main(String[] args) {
        System.out.println("Hello this is for lexicographical printing");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i < 10; i++) {
            dfs(i, n, "" + i);
        }
    }

    private static void dfs(int i, int n, String asf) {
        if (Integer.parseInt(asf) > n)
            return;
        System.out.println(asf);
        for (int j = 0; j < 10; j++) {
            dfs(j, n, asf + j);
        }
    }
}
