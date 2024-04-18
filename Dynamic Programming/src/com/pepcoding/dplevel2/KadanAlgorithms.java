package com.pepcoding.dplevel2;

public class KadanAlgorithms {
    public static void main(String[] args) {
        System.out.println("We will work on finding the largest sum for consecutive array elements");
        int[] arr = {1, 8, 7, 9, -20, 4, -6, 8, 4, 6, 9, -15, -1, 3, 6, 7, 9, -2, 6, 7, -9, -1, 9, 5, 3, 0, 0, 1};
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
        System.out.println(osum);
    }
}
