package com.pepcoding.dplevel2;

public class MinimumPalindromicCutsMCM {
    public static void main(String[] args) {
        System.out.println("We will work on minimum palindromic cuts");
        String str = "abccba";
        boolean[][] dpR = new boolean[str.length()][str.length()];
        for (int gap = 0; gap < dpR.length; gap++) {
            for (int i = 0, j = gap; j < dpR.length; i++, j++) {
                if (gap == 0) {
                    dpR[i][j] = true;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j))
                        dpR[i][j] = true;
                    else
                        dpR[i][j] = false;
                } else {
                    if (str.charAt(j) == str.charAt(i))
                        dpR[i][j] = dpR[i + 1][j - 1];
                    else
                        dpR[i][j] = false;
                }
            }
        }
        int[] dp = new int[str.length()];
        for (int j = 0; j < dp.length; j++) {
            if (dpR[0][j])
                dp[j] = 0;
            else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if (dpR[i][j])
                        min = Math.min(min, dp[i - 1]);
                }
                dp[j] = min + 1;
            }
        }
        System.out.println(dp[dp.length - 1]);

    }
}
