package com.pepcoding.dplevel2;

import java.util.Scanner;

public class CombinationsOfBalancedParenthesis {
    public static void main(String[] args) {
        System.out.println("We will solve count of balanced parenthesis which is nothing but catalan number.");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);
    }

    /*
    * Catalan Number
    * Number of BSTs
    * Count of Mountain and Valley
    * Count Bracket
    * Circles and Chords ==> C(n//2)
    * Number of ways of Triangulations ==> C(n-2)
    * Minimum score of Triangulations
    *
    * */
}
