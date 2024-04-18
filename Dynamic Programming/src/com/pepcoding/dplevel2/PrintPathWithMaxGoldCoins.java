package com.pepcoding.dplevel2;

import java.util.Arrays;
import java.util.LinkedList;

public class PrintPathWithMaxGoldCoins {
    private static class Pair {

        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will work on finding the minimum cost path in a 2D matrix");

        int[][] cost = {
                {2, 6, 1, 1, 3},
                {9, 1, 1, 0, 5},
                {0, 7, 5, 2, 0},
                {4, 3, 0, 4, 7},
                {2, 0, 1, 4, 1}
        };
        int[][] dp = new int[cost.length][cost[0].length];
        for (int i = cost.length - 1; i >= 0; i--) {
            for (int j = cost[0].length - 1; j >= 0; j--) {
                if (i == cost.length - 1 && j == cost[0].length - 1) {
                    dp[i][j] = cost[i][j];
                } else if (i == cost.length - 1) {
                    dp[i][j] = cost[i][j] + dp[i][j + 1];
                } else if (j == cost[0].length - 1) {
                    dp[i][j] = cost[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = cost[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        for (int i = 0; i < cost.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        Pair p = new Pair(0, 0, "0-0");
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(p);

        while (!queue.isEmpty()) {
            Pair pp = queue.removeFirst();
            int i = pp.i;
            int j = pp.j;
            String psf = pp.psf;

            if (i == cost.length - 1 && j == cost[0].length - 1) {
                System.out.println(psf);
                continue;
            }
            if (i + 1 > cost.length - 1) {
                int jj = j + 1;
                String temp = i + "-" + jj;
                Pair ptemp = new Pair(i, j + 1, psf + " " + temp);
                queue.addLast(ptemp);
            } else if (j + 1 > cost[0].length - 1) {
                int ii = i + 1;
                String temp = ii + "-" + j;
                Pair ptemp = new Pair(i + 1, j, psf + " " + temp);
                queue.addLast(ptemp);
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    int jj = j + 1;
                    String temp = i + "-" + jj;
                    Pair ptemp = new Pair(i, j + 1, psf + " " + temp);
                    queue.addLast(ptemp);
                } else if (dp[i + 1][j] < dp[i][j + 1]) {
                    int ii = i + 1;
                    String temp = ii + "-" + j;
                    Pair ptemp = new Pair(i + 1, j, psf + " " + temp);
                    queue.addLast(ptemp);
                } else {
                    int jj = j + 1;
                    String temp = i + "-" + jj;
                    Pair ptemp = new Pair(i, j + 1, psf + " " + temp);
                    queue.addLast(ptemp);
                    int ii = i + 1;
                    String temp1 = ii + "-" + j;
                    Pair ptemp1 = new Pair(i + 1, j, psf + " " + temp1);
                    queue.addLast(ptemp1);
                }
            }

        }
    }
}
