package com.pepcoding.recursionlevel2;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations1 {
    public static void main(String[] args) {
        System.out.println("We will learn the Permutations here ");
        Scanner scn = new Scanner(System.in);
        int box = scn.nextInt();
        int items = scn.nextInt();
        findPermutations(new int[box], 1, items);

    }

    private static void findPermutations(int[] boxes, int ci, int items) {
        if (ci > items) {
            System.out.println(Arrays.toString(boxes));
            return;
        }


        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                findPermutations(boxes, ci + 1, items);
                boxes[i] = 0;
            }

        }
    }
}
