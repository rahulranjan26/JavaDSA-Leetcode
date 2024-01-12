package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class Combinations2 {
    public static void main(String[] args) {
        System.out.println("We will learn about the Combinations using permutations");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        boolean[] used = new boolean[n];
        findCombinations2(used, n, r, -1, 1);
    }

    public static void findCombinations2(boolean[] usedBox, int n, int r, int lub, int ci) {
        if (ci > r) {
            for (int i = 0; i < usedBox.length; i++) {
                if (usedBox[i]) {
                    System.out.print("i");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
            return;
        }

        for (int i = lub + 1; i < usedBox.length; i++) {
            if (!usedBox[i]) {
                usedBox[i] = true;
                findCombinations2(usedBox, n, r, i, ci + 1);
                usedBox[i] = false;
            }

        }


    }
}
