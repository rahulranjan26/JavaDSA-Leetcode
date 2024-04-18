package com.pepcoding.dplevel2;

import java.util.Arrays;

public class RussianDollEnvelopes {
    private static class Doll implements Comparable<Doll> {
        int w;
        int h;

        public Doll(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Doll o) {
            if (this.w != o.w)
                return this.w - o.w;
            else
                return this.h - o.h;
        }
    }

    public static void main(String[] args) {
        System.out.println("We will do a direct application of LIS in this question.");
        int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] arr2 = {18, 25, 10, 30, 5, 3, 35, 68, 90, 6};
        Doll[] dolls = new Doll[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            dolls[i] = new Doll(arr1[i], arr2[i]);
        }

        Arrays.sort(dolls);

        int[] dp = new int[dolls.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (dolls[j].h <= dolls[i].h && dolls[j].w < dolls[i].w) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;
        }

        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < dolls.length; i++) {
            System.out.println(dolls[i].w + " " + dolls[i].h);

        }


    }
}
