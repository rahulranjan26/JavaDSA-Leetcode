package com.pepcoding.dplevel1;

public class MaxGoldCollectionDP {
    public static void main(String[] args) {
        System.out.println("We will have  gold mines collection problem. Collect maximum gold");
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
                if (j == matrix.length - 1) {
                    matrix[i][j] = matrix[i][j];
                } else if (i == matrix.length - 1) {
                    matrix[i][j] = matrix[i][j] + Math.max(matrix[i][j + 1], matrix[i - 1][j + 1]);
                } else if (i == 0) {
                    matrix[i][j] = matrix[i][j] + Math.max(matrix[i][j + 1], matrix[i + 1][j + 1]);

                } else {
                    matrix[i][j] = matrix[i][j] + Math.max(matrix[i - 1][j + 1], Math.max(matrix[i][j + 1], matrix[i + 1][j + 1]));
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
