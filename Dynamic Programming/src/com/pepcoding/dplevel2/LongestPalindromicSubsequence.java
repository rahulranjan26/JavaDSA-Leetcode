package com.pepcoding.dplevel2;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println("We will learn about the Longest Palindromic Subsequence in the question");
        //Just a application of LCS
        String s = "abcceda";
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp.length - 2; j >= 0; j--) {
                char c1 = s.charAt(i);
                char c2 = s2.charAt(j);
                if (c2 == c1) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
