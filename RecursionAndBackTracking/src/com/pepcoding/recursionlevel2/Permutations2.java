package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class Permutations2 {
    public static void main(String[] args) {
        System.out.println("We will learn about the total permutations here too but box will choose now");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int[] used = new int[r];
        findPermuations2(1, n, r, "", used, 0);
    }

    private static void findPermuations2(int boxInUsed, int n, int r, String asf, int[] usedBox, int itemsUsed) {
        if (boxInUsed > n) {
            if (itemsUsed == r) {
                System.out.println(asf);
            }
            return;
        }

//        Box choosing elements from 1 to r
        for (int i = 0; i < r; i++) {
            if (usedBox[i] == 0) {
                usedBox[i] = 1;
                findPermuations2(boxInUsed + 1, n, r, asf + (i + 1), usedBox, itemsUsed + 1);
                usedBox[i] = 0;
            }
        }
//        Box not choosing elements at all
        findPermuations2(boxInUsed + 1, n, r, asf + "_", usedBox, itemsUsed);
    }
}
