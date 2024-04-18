package com.pepcoding.dplevel1;

import java.util.Arrays;

public class FibonacciUsingDP {
    public static void main(String[] args) {
        System.out.println("We will learn about the DP of FIB series");
//        System.out.println(fibWithoutDP(10));
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        fibWithDP(10, dp);
        System.out.println(dp[10]);

    }

    public static int fibWithoutDP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.println("WDP" + " " + n);
        return fibWithoutDP(n - 1) + fibWithoutDP(n - 2);
    }

    public static int fibWithDP(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != -1)
            return dp[n];
        System.out.println("WDP" + " " + n);

        int temp = fibWithDP(n - 1, dp) + fibWithDP(n - 2, dp);
        dp[n] = temp;
        return temp;
    }
}

