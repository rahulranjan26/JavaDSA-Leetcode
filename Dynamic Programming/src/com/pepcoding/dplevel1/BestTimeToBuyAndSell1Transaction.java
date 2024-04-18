package com.pepcoding.dplevel1;

public class BestTimeToBuyAndSell1Transaction {
    public static void main(String[] args) {
        System.out.println("We will work on finding the max profit by selling the shares");
        int[] prices = {2, -8, 4, 6, 3, 1, 4, 9, 4, 5, 4, 8, 7, 6, 2, 1, 0, 2, 4, 5, 7, 96, 3, 1, 4, 7, 8, 9, 6, 4, 3,
                2, 1, 4, 8, 8};
        int ans = 0;
        int lsf = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            lsf = Math.min(lsf, prices[i]);
            ans = Math.max(ans, prices[i] - lsf);
        }
        System.out.println(ans);
    }
}
