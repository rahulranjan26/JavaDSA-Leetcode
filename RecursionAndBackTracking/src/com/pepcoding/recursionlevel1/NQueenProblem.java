package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class NQueenProblem {
    public static void main(String[] args) {
        System.out.println("This is famous NQueens Problem where we have to place N queen in NXN board such that no " +
                "one kills either of them");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] board = new int[n][n];

        placeNQueen(board, "", 0);
    }

    private static void placeNQueen(int[][] board, String qsf, int row) {
        if (row == board.length) {
            System.out.println(qsf);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafeToPlace(board, row, col)) {
                board[row][col] = 1;
                placeNQueen(board, qsf + row + "-" + col + ",", row + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafeToPlace(int[][] board, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }
}
