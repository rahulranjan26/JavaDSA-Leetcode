package com.pepcoding.dplevel2;

import java.util.Arrays;

public class LongestBiTonicSubSequence {
    public static void main(String[] args) {
        System.out.println("Find the longest increasing subsequence");
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] lis = new int[arr.length];
        int[] lisR = new int[arr.length];

        for (int i = 0; i < lis.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(lis[j], max);
                }

            }
            lis[i] = max + 1;
        }

        System.out.println(Arrays.toString(lis));

        for (int i = lisR.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = lis.length - 1; j > i; j--) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(lisR[j], max);
                }

            }
            lisR[i] = max + 1;
        }
        System.out.println(Arrays.toString(lisR));
    }
}
