package com.pepcoding.dplevel1;

import java.util.Scanner;

public class BinaryStringWithNoConsecutive0s {
    public static void main(String[] args) {
        System.out.println("We will count the number of bStrings which do not ends with " +
                "consecutive 0s");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] dp = new int[2][n + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < dp[0].length; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }
        System.out.println(dp[0][n] + dp[1][n]);
    }
}
