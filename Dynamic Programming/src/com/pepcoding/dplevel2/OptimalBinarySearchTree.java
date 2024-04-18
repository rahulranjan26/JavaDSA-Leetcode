package com.pepcoding.dplevel2;

public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("We will learn about the optimal way to search in a binary tree");
        int[] nodes = {10, 20, 30, 40, 50, 60, 70};
        int[] freq = {1, 9, 2, 1, 2, 6, 7};
        int[] psa = new int[freq.length];
        psa[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            psa[i] = freq[i] + psa[i - 1];
        }
        int[][] dp = new int[nodes.length][nodes.length];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = freq[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.min(freq[i] + 2 * freq[j], freq[j] + 2 * freq[i]);
                } else {
                    int cost = psa[j] - (i == 0 ? 0 : psa[i]);
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        int left = k == i ? 0 : dp[i][k - 1];
                        int right = k == j ? 0 : dp[k + 1][j];
                        min = Math.min(min, left + right + cost);
                    }
                    dp[i][j] = min;
                }
            }

        }
        System.out.println(dp[0][dp.length - 1]);
    }
}
