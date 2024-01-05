package com.pepcoding.recursionlevel2;

public class SudokuSolver {
    public static void main(String[] args) {
        System.out.println("We will learn how to solve sudoku here");
        int[][] board = new int[9][9];
        solveSudoku(board, 0, 0);
    }

    private static void solveSudoku(int[][] board, int i, int j) {


        int ni = 0;
        int nj = 0;

        if (j == board.length) {
            ni = i + 1;
            j = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (board[i][j] != 0) {
            solveSudoku(board, i, j);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isSafeToPut(board, i, j, po)) {
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[ni][nj] = 0;
                }
            }
        }

    }

    private static boolean isSafeToPut(int[][] board, int x, int y, int po) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == po)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[x][j] == po)
                return false;
        }
        int smi = 3 * x / 3;
        int smj = 3 * y / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + smi][j + smj] == po)
                    return false;
            }
        }
        return true;
    }
}
