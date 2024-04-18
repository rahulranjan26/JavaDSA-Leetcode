package com.pepcoding.dplevel2;

import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println("We will learn about the word break problem in this question");
        HashSet<String> map = new HashSet<>();
        map.add("pep");
        map.add("pepcoding");
        map.add("mango");
        map.add("go");
        map.add("man");
        map.add("coding");
        map.add("loves");

        String s = "pepcodinglovesmango";
        int[] dp = new int[s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (map.contains(sub)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }

            }

        }
        System.out.println(dp[dp.length - 1]);
    }
}
