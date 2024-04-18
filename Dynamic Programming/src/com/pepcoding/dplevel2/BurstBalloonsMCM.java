package com.pepcoding.dplevel2;

public class BurstBalloonsMCM {
    public static void main(String[] args) {
        System.out.println("We will work on MCM  : Burst Balloon");
        int[] arr = {2, 3, 5, 1, 4, 6};
        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == arr.length - 1 ? 1 : arr[j + 1]);

                    max = Math.max(max, left + val + right);
                }
                dp[i][j] = max;
            }
        }
        System.out.println(dp[0][dp.length - 1]);
    }
}
