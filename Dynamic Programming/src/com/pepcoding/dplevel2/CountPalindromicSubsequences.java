package com.pepcoding.dplevel2;

public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println("We will work on counting the palindromic subsequences of a string ");

        /*                       |---------------> c1=c2-----> C(c1m)+C(mc2)+1
         *                       |
         *                      |
         *    C(c1mc2)-----------
         *                     |
         *                    |
         *                   |---------------------> c1!=c2----> C(c1m)+C(mc2)-C(m)
         *
         * */
        String s = "aabbcbbaa";
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 3;
                    else
                        dp[i][j] = 2;
                } else {
                    if (s.charAt(j) == s.charAt(i))
                        dp[i][j] = 1 + dp[i][j - 1] + dp[i + 1][j];
                    else
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
            }
        }
        System.out.println(dp[0][dp.length - 1]);

    }
}
