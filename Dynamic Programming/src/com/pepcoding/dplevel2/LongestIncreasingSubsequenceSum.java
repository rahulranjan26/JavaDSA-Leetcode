package com.pepcoding.dplevel2;

import java.util.Arrays;

public class LongestIncreasingSubsequenceSum {
    public static void main(String[] args) {
        System.out.println("Find the longest increasing subsequence");
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] dp = new int[arr.length];

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }

            }
            dp[i] = max + arr[i];
        }

        System.out.println(Arrays.toString(dp));
    }
}
