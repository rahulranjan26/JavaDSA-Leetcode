package com.pepcoding.dplevel2;

import java.util.Arrays;

public class KConcatenationMaximumSum {
    public static void main(String[] args) {
        System.out.println("We will find the maximum sum in KConcatenation array--> Just the application of Kadan");
        int[] arr = {1, 8, 7, 9, -20, 4, -6, 8, 4, 6, 9, -15, -1, 3, 6, 7, 9, -2, 6, 7, -90, -1, 9, 5, 3, 0, 0, 1};
        int k = 5;
        if (k == 1) {
            System.out.println(Kadan(arr));
        } else if (Arrays.stream(arr).sum() < 0) {
            System.out.println("Inside minus");
            System.out.println(KadanOf2(arr));
        } else if (Arrays.stream(arr).sum() > 0) {
            System.out.println((k - 2) * Arrays.stream(arr).sum() + KadanOf2(arr));
        }
    }

    private static int Kadan(int[] arr) {
        int csum = 0;
        int osum = 0;

        for (int el : arr) {
//            csum = Math.max(csum + el, el);
//            osum = Math.max(osum, csum);
            if (csum < 0) {
                csum = el;
            } else
                csum += el;

            osum = Math.max(csum, osum);
        }
        return osum;
    }

    private static int KadanOf2(int[] arr) {
        // Create a new array with twice the size of the original array
        int[] newArray = new int[arr.length * 2];

        // Copy the elements of the original array twice into the new array
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
            newArray[i + arr.length] = arr[i];
        }
        return Kadan(newArray);
    }
}
