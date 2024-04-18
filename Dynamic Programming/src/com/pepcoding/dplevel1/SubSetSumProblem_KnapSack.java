package com.pepcoding.dplevel1;

import java.util.Scanner;

public class SubSetSumProblem_KnapSack {
    public static void main(String[] args) {
        System.out.println("We will work on Knapsack problem or subset sum problem");
        int[] set = {4, 2, 7, 3, 1};
        Scanner scn = new Scanner(System.in);
        int sum = scn.nextInt();
        int[][] matrix = new int[set.length + 1][sum + 1];
        boolean[][] dp = new boolean[set.length + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (j >= set[i - 1])
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i-1]];
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[set.length][sum]);
    }
}
