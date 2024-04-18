package com.pepcoding.dplevel1;

public class BestTimeToBuyAndSell_InfiniteTransaction {
    public static void main(String[] args) {

        System.out.println("We will  sell the shares for every dip and rise.See the figure");
//        We sell and buy at every dip and high
        int[] prices = {2, -8, 4, 6, 3, 1, 4, 9, 4, 5, 4, 8, 7, 6, 2, 1, 0, 2, 4, 5, 7, 96, 3, 1, 4, 7, 8, 9, 6, 4, 3, 2, 1, 4, 8, 8};
        int bi = 0;
        int si = 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) si++;
            else {
                ans += prices[si] - prices[bi];
                si = bi = i;
            }
        }
        ans += prices[si] - prices[bi];
        System.out.println(ans);
    }
}
