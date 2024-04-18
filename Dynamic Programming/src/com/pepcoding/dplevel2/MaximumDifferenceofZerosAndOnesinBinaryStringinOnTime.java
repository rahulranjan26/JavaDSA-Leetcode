package com.pepcoding.dplevel2;

import java.util.Scanner;

public class MaximumDifferenceofZerosAndOnesinBinaryStringinOnTime {
    public static void main(String[] args) {
        System.out.println("We will learn about the finding the max difference of zeroes and ones in binary string");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();

        int ans = -1;
        int csum = 0;
        int val = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1')
                val += -1;
            else
                val += 1;

            if (csum > 0)
                csum = csum + val;
            else
                csum = val;

            if (csum > ans)
                ans = csum;


        }

        System.out.println(ans);
    }
}
