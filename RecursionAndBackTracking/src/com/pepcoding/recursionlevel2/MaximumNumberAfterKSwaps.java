package com.pepcoding.recursionlevel2;

import java.util.Scanner;

public class MaximumNumberAfterKSwaps {

    static int maxAns = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println("We will learn the K swap max");

        Scanner scn = new Scanner(System.in);

        String number = scn.next();
        int swaps = scn.nextInt();
        findMax(number, swaps);
        System.out.println(maxAns);
    }

    private static void findMax(String number, int swaps) {
        if (Integer.parseInt(number) > maxAns) {
            maxAns = Integer.parseInt(number);

        }
        if (swaps == 0) {
            return;
        }

        for (int i = 0; i < number.length() - 1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) < number.charAt(j)) {
                    number = swap(number, i, j);
                    findMax(number, swaps - 1);
                    number = swap(number, i, j);
                }

            }

        }


    }

    private static String swap(String number, int i, int j) {
        char chi = number.charAt(i);
        char chj = number.charAt(j);
        String left = number.substring(0, i);
        String middles = number.substring(i + 1, j);
        String right = number.substring(j + 1);
        return left + chj + middles + chi + right;
    }
}
