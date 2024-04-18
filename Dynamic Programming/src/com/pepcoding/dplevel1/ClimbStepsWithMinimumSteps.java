package com.pepcoding.dplevel1;

import java.util.Arrays;

public class ClimbStepsWithMinimumSteps {
    public static void main(String[] args) {
        System.out.println("We will climb steps with minimum steps");
        //Go from 0 to Nth stair
        int[] steps = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        Integer[] dp = new Integer[steps.length + 1];
        dp[steps.length] = 0;

        for (int i = steps.length - 1; i >= 0; i--) {
            int step = steps[i];
            if (step > 0) {
                int temp = Integer.MAX_VALUE;
                for (int j = 1; j <= step && i + j < dp.length; j++) {
                    if (dp[i+j]!=null)
                        temp = Math.min(temp, dp[i + j]);
                }
                if (temp == Integer.MAX_VALUE)
                    dp[i] = 0;
                else
                    dp[i] = temp + 1;
            }

        }
        System.out.println(Arrays.toString(dp));
    }
}
