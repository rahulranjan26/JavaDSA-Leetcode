package com.pepcoding.dplevel1;

import java.util.Scanner;

public class BuyAndSellStocksWithInfiniteTransAndSellingCost {
    public static void main(String[] args) {
        System.out.println("We will buy and sell the stocks as many times as possible but with each sell we have a" +
                " tax attached to it");
        int[] prices = {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        int obp = -prices[0];
        int osp = 0;
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();

        for (int i = 1; i < prices.length; i++) {
            int nbp = 0;
            int nsp = 0;
            if (osp - prices[i] > obp) {
                nbp = osp - prices[i];
            } else {
                nbp = obp;
            }
            if (prices[i] + obp - k > osp) {
                nsp = prices[i] + obp - k;
            } else {
                nsp = osp;
            }
            osp = nsp;
            obp = nbp;
        }
        System.out.println(osp);
    }
}
