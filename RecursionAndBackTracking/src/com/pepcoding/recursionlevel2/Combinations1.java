package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class Combinations1 {
    public static void main(String[] args) {
        System.out.println("We will learn about combinations here");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        findCombinations(n, r, 1, "", 0);
    }

    public static void findCombinations(int n, int r, int box, String asf, int esf) {
        if (box > n) {
//            int count = 0;
//            for (int i = 0; i < asf.length(); i++) {
//                char ch = asf.charAt(i);
//                if (ch == 'X') {
//                    count += 1;
//                }
//            }
            if (esf == r) {
                System.out.println(asf);
            }
            return;
        }
        findCombinations(n, r, box + 1, asf + "X", esf + 1);
        findCombinations(n, r, box + 1, asf + "_", esf);

    }


}
