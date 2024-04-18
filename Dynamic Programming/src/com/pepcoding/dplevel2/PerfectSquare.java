package com.pepcoding.dplevel2;

import java.util.Arrays;
import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println("We will work on finding the minimum numbers of perfect squares summed to a number");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j < i; j++) {
                int rem = i - j * j;
                min = Math.min(dp[rem], min);
            }
            dp[i] = min + 1;
        }
        System.out.println(Arrays.toString(dp));
    }
}
