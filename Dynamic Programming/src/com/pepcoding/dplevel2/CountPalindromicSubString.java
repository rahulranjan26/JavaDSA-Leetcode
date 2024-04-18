package com.pepcoding.dplevel2;

public class CountPalindromicSubString {
    public static void main(String[] args) {
        System.out.println("We will count the number of palindromic substring in the question");
        String s = "aabbcbbaa";
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                } else {
                    if (s.charAt(j) == s.charAt(i))
                        dp[i][j] = dp[i + 1][j - 1];
                    else
                        dp[i][j] = false;
                }
                if (dp[i][j])
                    count++;
            }

        }
        System.out.println(count);

    }
}
