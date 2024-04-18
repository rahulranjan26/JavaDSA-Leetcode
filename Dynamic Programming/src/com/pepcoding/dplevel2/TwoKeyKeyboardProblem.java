package com.pepcoding.dplevel2;

import java.util.Scanner;

public class TwoKeyKeyboardProblem {
    public static void main(String[] args) {
        System.out.println("We will learn about the 2 key keyboard problem here");

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ans = 0;
        for (int i = 2; i * i < n; ) {
            if (n % i == 0) {
                ans += i;
                n = n / 2;
            } else {
                i++;
            }
        }
        if(n!=1){
            ans+=n;
        }
        System.out.println(ans);
    }
}
