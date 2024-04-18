package com.pepcoding.dplevel2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PrintTargetSumSubset {
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
        System.out.println("Print path for subset sum problem");
        Scanner scn = new Scanner(System.in);
        int sum = scn.nextInt();
        int[] set = {4, 2, 7, 1, 3};
        boolean[][] dp = new boolean[set.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j - set[i - 1] >= 0)
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        LinkedList<Pair> queue = new LinkedList<>();
        Pair p = new Pair(dp.length - 1, dp[0].length - 1, "");
        queue.addLast(p);

        while (!queue.isEmpty()) {
            Pair pp = queue.removeFirst();
            int i = pp.i;
            int j = pp.j;
            String psf = pp.psf;
            if (i == 0 || j == 0) {
                System.out.println(psf);
            } else {
                if (dp[i - 1][j]) {
                    Pair temp = new Pair(i - 1, j, psf);
                    queue.addLast(temp);
                }
                if (j >= set[i - 1] && dp[i - 1][j - set[i - 1]]) {
                    int jj = j - set[i - 1];
                    Pair temp = new Pair(i - 1, jj, psf + set[i - 1] + " ");
                    queue.addLast(temp);
                }

            }

        }

    }
}
