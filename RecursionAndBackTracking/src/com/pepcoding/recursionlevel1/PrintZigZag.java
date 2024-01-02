package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {
        System.out.println("We will learn the zig zag of recursion");

        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        pzn(input);
    }

    private static void pzn(int n) {
        if (n == 0) {
            return;
        }

        System.out.println("Pre Recursion" + n);
        pzn(n - 1);
        System.out.println("In Between" + n);
        pzn(n - 1);
        System.out.println("Post Recursion" + n);
    }
}
