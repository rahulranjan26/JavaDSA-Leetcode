package com.pepcoding.dplevel1;

import java.util.Arrays;

public class StairsClimbing {
    public static void main(String[] args) {
        System.out.println("We will learn about the DP of FIB series");

        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        fibWithDP(10, dp);
        System.out.println(dp[10]);

    }


    public static int fibWithDP(int n, int[] dp) {
        if (n <= 3) {
            return dp[n];
        }
        if (dp[n] != -1)
            return dp[n];
        System.out.println("WDP" + " " + n);

        int temp = fibWithDP(n - 1, dp) + fibWithDP(n - 2, dp) + fibWithDP(n - 3, dp);
        dp[n] = temp;
        return temp;
    }
}
