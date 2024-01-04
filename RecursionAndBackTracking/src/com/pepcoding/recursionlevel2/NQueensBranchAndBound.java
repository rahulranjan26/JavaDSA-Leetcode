package com.pepcoding.recursionlevel2;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class NQueensBranchAndBound {
    public static void main(String[] args) {
        System.out.println("We will learn about N-Queens branch and bound technique");

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        boolean[] col = new boolean[n];
        boolean[] ndiag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        solution(board, 0, col, ndiag, rdiag, "");
    }

    private static void solution(boolean[][] board, int row, boolean[] col, boolean[] ndiag, boolean[] rdiag, String asf) {
        if (row == board.length) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (!col[i] && !ndiag[row + i] && !rdiag[row - i + board.length - 1]) {
                col[i] = true;
                ndiag[row + i] = true;
                rdiag[row - i + board.length - 1] = true;
                solution(board, row + 1, col, ndiag, rdiag, asf + row + "-" + i + ",");
                col[i] = false;
                ndiag[row + i] = false;
                rdiag[row - i + board.length - 1] = false;
            }
        }

    }
}
