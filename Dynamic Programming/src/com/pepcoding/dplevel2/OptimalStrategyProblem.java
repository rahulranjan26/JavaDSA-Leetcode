package com.pepcoding.dplevel2;

public class OptimalStrategyProblem {
    public static void main(String[] args) {
        System.out.println("We will learn about optimal strategy problem in this question");
//        Given an array of coins. You play a game where in you need to collect maximum coins
//        Strategy: Select the best when you have the option to choose and expect the worst to happen with you
        int[] arr = {10, 9, 16, 2, 20, 48, 31};
        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = arr[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int val = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    int ans = Math.max(val,val2);
                    dp[i][j] = ans;
                }

            }

        }
        System.out.println(dp[0][arr.length-1]);
    }
}
