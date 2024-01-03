package com.pepcoding.recursionlevel1;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsTourProblem {
    public static void main(String[] args) {
        System.out.println("We will learn about Knights tour problem in this question");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);

    }

    private static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0) {
            return;
        } else {
            if (move == chess.length * chess.length) {
                chess[r][c] = move;
                System.out.println(Arrays.deepToString(chess));
                chess[r][c] = 0;
                return;
            }
        }


        chess[r][c] = move;
        printKnightsTour(chess, r - 2, c + 1, move + 1);
        printKnightsTour(chess, r - 2, c - 1, move + 1);

        printKnightsTour(chess, r - 1, c + 2, move + 1);
        printKnightsTour(chess, r + 1, c + 2, move + 1);

        printKnightsTour(chess, r - 1, c - 2, move + 1);
        printKnightsTour(chess, r + 1, c - 2, move + 1);

        printKnightsTour(chess, r + 2, c - 1, move + 1);
        printKnightsTour(chess, r + 2, c + 1, move + 1);
        chess[r][c] = 0;

    }

}
