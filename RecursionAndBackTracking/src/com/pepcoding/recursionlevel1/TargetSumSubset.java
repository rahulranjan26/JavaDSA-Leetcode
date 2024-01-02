package com.pepcoding.recursionlevel1;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        System.out.println("Hello we will learn about the Target sum subset in Recursion");
        Scanner scn = new Scanner(System.in);
        int target = scn.nextInt();
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        findSubsetSum(arr, target, 0, "", 0);
    }

    private static void findSubsetSum(int[] arr, int target, int ssf, String s, int idx) {
        if (idx == arr.length) {
            if (ssf == target) {
                System.out.println(s);
            }
            return;
        }

        findSubsetSum(arr, target, ssf + arr[idx], s + arr[idx] + ",", idx + 1);
        findSubsetSum(arr, target, ssf, s, idx + 1);

    }
}
