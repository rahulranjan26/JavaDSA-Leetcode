package com.pepcoding.dplevel1;

import java.util.Scanner;

public class PaintFence {
    public static void main(String[] args) {
        System.out.println("Paint N fences with K color such that no more than 2 consecutive fences have the same color");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int same = k;
        int diff = k * (k - 1);
        int total = same + diff;
        for (int i = 3; i < n + 1; i++) {
            same = diff * k;

            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(int.class);
    }
}
