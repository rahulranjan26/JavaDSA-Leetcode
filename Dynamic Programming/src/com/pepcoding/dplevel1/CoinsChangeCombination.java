package com.pepcoding.dplevel1;

import java.util.Scanner;

public class CoinsChangeCombination {
    public static void main(String[] args) {
        System.out.println("We will learn about the coins change problem in the question!");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        int[] coins = {2, 3, 5};
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {

                dp[j] = dp[j] + dp[j - coins[i]];
            }

        }
        System.out.println(dp[n]);
    }
}
