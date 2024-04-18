package com.pepcoding.dplevel1;

public class MinimumCostPathDP {
    public static void main(String[] args) {
        System.out.println("We will work on minimum cost path on a matrix");
        int[][] matrix = {
                {2, 8, 4, 1, 6, 4, 2},
                {6, 0, 9, 5, 3, 8, 5},
                {1, 4, 3, 4, 0, 6, 5},
                {6, 4, 7, 2, 4, 6, 1},
                {1, 0, 3, 7, 1, 2, 7},
                {1, 5, 3, 2, 3, 0, 9},
                {2, 5, 5, 1, 9, 8, 2}
        };
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (i == matrix.length - 1 && j == matrix.length - 1) {
                    matrix[i][j] = matrix[i][j];
                } else if (i == matrix.length - 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i][j + 1];
                } else if (j == matrix.length - 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i + 1][j];
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }
        System.out.println(matrix[matrix.length - 1][matrix.length - 1]);
        System.out.println(matrix[0][0]);
    }
}
