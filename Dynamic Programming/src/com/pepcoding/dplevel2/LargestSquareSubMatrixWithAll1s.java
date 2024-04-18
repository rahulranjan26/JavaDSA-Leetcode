package com.pepcoding.dplevel2;

public class LargestSquareSubMatrixWithAll1s {
    public static void main(String[] args) {
        System.out.println("We will see the largest submatrix square with all ones ");
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1}
        };
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
                if (i == matrix.length - 1)
                    dp[i][j] = matrix[i][j];
                if (j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j];

                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }

        }
        System.out.println(ans);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
