package com.pepcoding.recursionlevel2;

import java.util.Scanner;


public class JosepheusCircle {
    public static void main(String[] args) {
        System.out.println("THis is classic josephus problem");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int ans = solution(n, k);
        System.out.println(ans);
    }

    private static int solution(int n, int k) {
        if (n == 0)
            return 0;
        int temp = solution(n - 1, k);
        return (temp + k) % n;

    }
}
