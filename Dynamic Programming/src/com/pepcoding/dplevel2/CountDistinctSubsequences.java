package com.pepcoding.dplevel2;

import java.util.HashMap;

public class CountDistinctSubsequences {
    public static void main(String[] args) {
        System.out.println("We will learn about the ways of finding distinct subsequences ");
        String s = "abc";
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = dp[i] - dp[j - 1];
            }
            map.put(ch, i);
        }

        System.out.println(dp[dp.length - 1]);
    }
}
