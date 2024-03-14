package com.rahul.pepcoding.graphs2;

public class ConclavesCount {
    public static void main(String[] args) {
        System.out.println("Count the number of numbers with are not touching the boundaries");
        int[][] matrix = {
                {0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 1}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1) {
                    if (matrix[i][j] == 1)
                        dfs(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 0)
            return;
        matrix[row][col] = 0;
        dfs(matrix, row - 1, col);
        dfs(matrix, row, col - 1);
        dfs(matrix, row + 1, col);
        dfs(matrix, row, col + 1);
    }
}
