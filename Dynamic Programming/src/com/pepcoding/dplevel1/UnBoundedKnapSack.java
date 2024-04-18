package com.pepcoding.dplevel1;

import java.util.Scanner;

public class UnBoundedKnapSack {
    public static void main(String[] args) {
        System.out.println("We will learn about Unbounded Knapsack here");
        int[] set = {2, 5, 1, 3, 4};
        int[] wt = {15, 14, 10, 45, 30};
        Scanner scn = new Scanner(System.in);
        int sum = scn.nextInt();
        int[] dp = new int[sum + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < set.length; j++) {
                int temp = Integer.MIN_VALUE;
                if (i >= set[j]) {
                    dp[i] = Math.max(dp[i], wt[j] + dp[i - set[j]]);

                }

            }

        }
        System.out.println(dp[sum]);
    }
}
