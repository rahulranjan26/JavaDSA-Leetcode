package com.pepcoding.dplevel2;

public class EditDistances {
    public static void main(String[] args) {
        System.out.println("We will read about the edit distance in which one string is converted to another in minimum ops");
        // S1 --> S2
        String s1 = "ahellobye";
        String s2 = "amezooe";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int f1 = dp[i - 1][j];
                        int f2 = dp[i - 1][j - 1];
                        int f3 = dp[i][j - 1];
                        dp[i][j] = 1 + Math.min(f1, Math.min(f2, f3));
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
