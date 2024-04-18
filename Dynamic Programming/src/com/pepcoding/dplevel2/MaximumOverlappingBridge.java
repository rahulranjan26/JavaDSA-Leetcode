package com.pepcoding.dplevel2;

import java.util.Arrays;

public class MaximumOverlappingBridge {
    private static class Bridge implements Comparable<Bridge> {
        int n;
        int s;

        public Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        @Override
        public int compareTo(Bridge o) {
            if (this.n != o.n)
                return this.n - o.n;
            else
                return this.s - o.s;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will do a direct application of LIS in this question.");
        int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] arr2 = {18, 25, 10, 30, 5, 3, 35, 68, 90, 6};
        Bridge[] bridge = new Bridge[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            bridge[i] = new Bridge(arr1[i], arr2[i]);
        }

        Arrays.sort(bridge);

        int[] dp = new int[bridge.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (bridge[j].s <= bridge[i].s) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;
        }

        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < bridge.length; i++) {
            System.out.println(bridge[i].n + " " + bridge[i].s);

        }


    }
}
