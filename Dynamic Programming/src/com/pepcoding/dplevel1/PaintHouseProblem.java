package com.pepcoding.dplevel1;

public class PaintHouseProblem {
    public static void main(String[] args) {
        System.out.println("We will find the min value to pain the houses red, blue and green");
        int[][] arr = {
                {1, 8, 9},
                {2, 4, 8},
                {3, 1, 9},
                {8, 4, 5},
                {1, 2, 3},
                {8, 6, 3},
                {1, 2, 7}};
        int[][] dp = new int[arr.length][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(dp[arr.length - 1][0], Math.min(dp[arr.length - 1][1], dp[arr.length - 1][2])));
    }

}
