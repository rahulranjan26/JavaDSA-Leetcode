package com.pepcoding.dplevel2;

public class RodCuttingProblem {
    public static void main(String[] args) {
        System.out.println("We will work on cutting the rod problem");
        int[] cost = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] np = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            np[i + 1] = cost[i];
        }
        int[] dp = new int[np.length];
        dp[0] = 0;
        dp[1] = np[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = np[i];

            int li = 1;
            int hi = i - 1;
            while (li <= hi) {
                dp[i] = Math.max(dp[li] + dp[hi], dp[i]);
                li++;
                hi--;
            }
        }

        System.out.println(dp[dp.length - 1]);
    }
}
