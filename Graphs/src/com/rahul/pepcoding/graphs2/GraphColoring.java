package com.rahul.pepcoding.graphs2;

public class GraphColoring {
    public static void main(String[] args) {
        System.out.println("We will learn about graph coloring in the problem");
        int[][] matrix = {
                {2, 3, 4, 3, 1},
                {4, 2, 2, 2, 1},
                {1, 2, 2, 2, 1},
                {5, 2, 2, 2, 1},
                {6, 7, 0, 1, 1}};
        int color = 7;
        int row = 1;
        int col = 1;
        int val = matrix[row][col];
        colorTheGraph(matrix, row, col, color, val);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0)
                    matrix[i][j] = color;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void colorTheGraph(int[][] matrix, int row, int col, int color, int val) {
        if (row < 0 || col < 0 || row > matrix.length || col > matrix[0].length || matrix[row][col] != val)
            return;
        matrix[row][col] = -val;
        colorTheGraph(matrix, row - 1, col, color, val);
        colorTheGraph(matrix, row, col + 1, color, val);
        colorTheGraph(matrix, row + 1, col, color, val);
        colorTheGraph(matrix, row, col - 1, color, val);

        if (isValid(matrix, row - 1, col) && Math.abs(matrix[row - 1][col]) == val
                &&
                isValid(matrix, row, col - 1) && Math.abs(matrix[row][col - 1]) == val
                &&
                isValid(matrix, row + 1, col) && Math.abs(matrix[row + 1][col]) == val
                &&
                isValid(matrix, row, col + 1) && Math.abs(matrix[row][col + 1]) == val
        ) {
            matrix[row][col] = val;
        }

    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
    }
}
