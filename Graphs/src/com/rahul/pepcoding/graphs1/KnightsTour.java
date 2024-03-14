package com.rahul.pepcoding.graphs1;

import java.lang.reflect.Array;
import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        System.out.println("Knight Tour Problem");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] board = new int[n][n];

        findKnightsTour(board, r, c, 1, n);

    }

    private static void findKnightsTour(int[][] board, int r, int c, int count, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n || board[r][c] != 0)
            return;
        if (count == n * n) {
            board[r][c] = count;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            board[r][c] = 0;
            System.out.println("\n");
            return;
        }

        board[r][c] = count;
        findKnightsTour(board, r - 2, c + 1, count + 1, n);
        findKnightsTour(board, r - 2, c - 1, count + 1, n);
        findKnightsTour(board, r - 1, c + 2, count + 1, n);
        findKnightsTour(board, r + 1, c + 2, count + 1, n);
        findKnightsTour(board, r + 2, c + 1, count + 1, n);
        findKnightsTour(board, r + 2, c - 1, count + 1, n);
        findKnightsTour(board, r - 1, c - 2, count + 1, n);
        findKnightsTour(board, r + 1, c - 2, count + 1, n);
        board[r][c] = 0;
    }
}
