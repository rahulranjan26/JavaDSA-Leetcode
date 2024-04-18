package com.pepcoding.dplevel1;

public class BuyAndSellStocks2TransactionsAllowed {
    public static void main(String[] args) {
        System.out.println("We will find the maximum profit if we sell stocks with 2 transactions allowed");
        int[] arr = {2, 8, 4, 6, 3, 1, 4, 9, 4, 5, 4, 8, 7, 6, 2, 1, 0, 2, 4, 5, 7, 96, 3, 1, 4, 7, 8, 9, 6, 4, 3, 2, 1, 4, 8, 8};
        int mpsL = 0;
        int least = arr[0];
        int[] dpL = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < least) {
                least = arr[i];
            }
            mpsL = arr[i] - least;
            dpL[i] = Math.max(dpL[i - 1], mpsL);
        }

        int mpsR = 0;
        int max = arr[arr.length - 1];
        int[] dpR = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            }
            mpsR = arr[i] - max;
            dpR[i] = Math.max(dpR[i + 1], mpsR);
        }
        int ans = 0;
        for (int i = 0; i < dpL.length; i++) {
            ans = Math.max(dpR[i] + dpL[i], ans);
        }
        System.out.println(ans);
    }
}
