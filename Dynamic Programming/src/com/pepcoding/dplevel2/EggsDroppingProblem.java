package com.pepcoding.dplevel2;

import java.util.Scanner;

public class EggsDroppingProblem {
    public static void main(String[] args) {
        System.out.println("We will work on Egg drop problem which has game strategy.");
//        The game strategy is ==> Choose best from the worst. Always think the luck is against you.
        Scanner scn = new Scanner(System.in);
        int floor = scn.nextInt();
        int eggs = scn.nextInt();

        int[][] dp = new int[eggs + 1][floor + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = j - 1, l = 0; k >= 0; k--, l++) {
                        int a = dp[i][k];
                        int b = dp[i - 1][l];
                        int val = Math.max(a, b);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = 1 + min;
                }

            }

        }
        System.out.println(dp[eggs][floor]);
    }
}
