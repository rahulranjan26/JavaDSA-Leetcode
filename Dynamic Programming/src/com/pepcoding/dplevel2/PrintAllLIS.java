package com.pepcoding.dplevel2;

import java.util.Arrays;
import java.util.LinkedList;

public class PrintAllLIS {
    private static class Pair {
        int len;
        int idx;
        int val;
        String psf;

        public Pair(int len, int idx, int val, String psf) {
            this.len = len;
            this.idx = idx;
            this.val = val;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        System.out.println("Find the longest increasing subsequence");
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] dp = new int[arr.length];
        int gMax = 0;
        int mIdx = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }

            }
            dp[i] = max + 1;
            if (dp[i] > gMax) {
                gMax = dp[i];
                mIdx = i;
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(gMax);
        System.out.println(mIdx);
        LinkedList<Pair> queue = new LinkedList<>();
        Pair in = new Pair(gMax, mIdx, arr[mIdx], "" + arr[mIdx]);
        queue.addLast(in);

        while (!queue.isEmpty()) {
            Pair p = queue.removeFirst();
            int len = p.len;
            int idx = p.idx;
            int val = p.val;
            String psf = p.psf;
            if (len == 1)
                System.out.println(psf);

            for (int i = idx - 1; i >= 0; i--) {
                if (dp[i] == len - 1 && arr[i] <= val) {
                    Pair temp = new Pair(dp[i], i, arr[i], arr[i] + "->" + psf);
                    queue.addLast(temp);
                }
            }
        }
    }
}
