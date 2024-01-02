package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class PrintBackwards {
    public static void main(String[] args) {
        System.out.println("Lets learn about printing backwards using recursion");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printBack(n);
    }

    private static void printBack(int n) {
        if (n == 0)
            return;

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        printBack(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();


    }
}
