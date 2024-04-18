package com.pepcoding.dplevel1;

import java.util.Scanner;

public class Z01KnapsackProblem {
    public static void main(String[] args) {
        System.out.println("Simple zero one knapsack problem");
        int[] set = {2, 5, 1, 3, 4};
        int[] wt = {15, 14, 10, 45, 30};
        Scanner scn = new Scanner(System.in);
        int sum = scn.nextInt();
        int[][] matrix = new int[set.length + 1][sum + 1];
        int[][] dp = new int[set.length + 1][sum + 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (j >= set[i - 1]) {
                    dp[i][j] = Math.max(wt[i - 1] + dp[i - 1][j - set[i - 1]], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        System.out.println(dp[set.length][sum]);
    }
}
