package com.pepcoding.dplevel1;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args) {
        System.out.println("We will work for Coin change permutation");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        int[] coins = {2, 3, 5, 6};
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
