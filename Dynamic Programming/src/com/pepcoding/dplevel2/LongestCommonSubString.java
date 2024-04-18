package com.pepcoding.dplevel2;

public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println("We will find the longest common substring");
        String s1 = "abcbc";
        String s2 = "ebc";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
